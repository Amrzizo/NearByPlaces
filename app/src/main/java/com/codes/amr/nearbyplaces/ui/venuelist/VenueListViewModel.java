package com.codes.amr.nearbyplaces.ui.venuelist;


import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.codes.amr.nearbyplaces.data.location.LocationLiveData;
import com.codes.amr.nearbyplaces.data.model.GroupsItem;
import com.codes.amr.nearbyplaces.data.model.Image.ImageResponse;
import com.codes.amr.nearbyplaces.data.model.Response;
import com.codes.amr.nearbyplaces.data.model.VenueModel.Venue;
import com.codes.amr.nearbyplaces.data.model.VenueModel.VenueResponse;
import com.codes.amr.nearbyplaces.data.rest.FoursquareApiService;
import com.codes.amr.nearbyplaces.data.rest.FoursquareRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class VenueListViewModel extends ViewModel {

    private final FoursquareRepository foursquareRepository;
    private CompositeDisposable disposable;
    private LocationLiveData locationLiveData;
    private final MutableLiveData<List<Venue>> venuesData = new MutableLiveData<>();
    private Observable<String> photoObservable;
    private final MutableLiveData<Boolean> repoLoadError = new MutableLiveData<>();
    private final MutableLiveData<Boolean> loading = new MutableLiveData<>();
    private ArrayList venues;

    @Inject
    public VenueListViewModel(Context context, FoursquareRepository foursquareRepository, String location) {
        this.foursquareRepository = foursquareRepository;
        disposable = new CompositeDisposable();
        locationLiveData = new LocationLiveData(context);

    }

    LiveData<List<Venue>> getVenuesData() {
        return venuesData;
    }

    LiveData<Boolean> getError() {
        return repoLoadError;
    }

    LiveData<Boolean> getLoading() {
        return loading;
    }

    public void getNearLocations(String location) {
        loading.setValue(true);
       foursquareRepository.getNearLocations(location, FoursquareApiService.RADIUS, FoursquareApiService.API_VERSION).subscribeOn(Schedulers.io())
                .map(retrofit2.Response::body)
                        .map(Response::getResponse)
                        .map(Response::getGroups)
                        .flatMap(Observable::fromIterable)
                        .map(GroupsItem::getItems)
                        .flatMap(Observable::fromIterable)
                        .flatMap(itemsItem -> {
                                    Observable<Venue> venueObservable = getVenue(itemsItem.getVenue().getId());
                                    Observable<String> photoUrlObservable =
                                            getVenuePhotoUrlObservable(itemsItem.getVenue().getId());
                                    return
                                            Observable.zip(venueObservable, photoUrlObservable, (venue, imgUrl) -> {

                                                venue.setImgUrl(imgUrl);
                                                return venue;
                                            });
                                }
                        ).observeOn(AndroidSchedulers.mainThread())
               .subscribe(this::onLoadVenue, this::onError, this::onLoadAllVenues);
//                .subscribeWith(new DisposableSingleObserver<Response>() {
//                    @Override
//                    public void onSuccess(Response value) {
//                        repoLoadError.setValue(false);
//                        venuesData.setValue(value);
//                        loading.setValue(false);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        repoLoadError.setValue(true);
//                        loading.setValue(false);
//                    }
//                })
//


    }


    private void onLoadVenue(Venue venue) {
        venues.add(venue);
    }
    private void onLoadAllVenues() {
        venuesData.setValue(venues);
        loading.setValue(false);

    }
    private void onError(Throwable throwable) {
        repoLoadError.setValue(true);
        loading.setValue(false);
    }


    private Observable<String> getVenuePhotoUrlObservable(String id) {
        photoObservable =  foursquareRepository.getPhotos(id,FoursquareApiService.PHOTOS_LIMIT, FoursquareApiService.API_VERSION).
                subscribeOn(Schedulers.io()).
                map(retrofit2.Response::body)
                .map(ImageResponse::getResponse)
                .map(response -> response.getPhotos())
                .map(photos -> photos.getItems())
                .flatMap(Observable::fromIterable)
                .take(1)
                .map(itemsItem ->itemsItem.getPrefix() + "500x500" + itemsItem.getSuffix());

        return  photoObservable;
    }


    private Observable<Venue> getVenue(String id) {
        return   foursquareRepository.getVenue(id,FoursquareApiService.API_VERSION).
                subscribeOn(Schedulers.io()).
                map(retrofit2.Response::body).
                map(VenueResponse::getResponse).map(response -> response.getVenue());
    }


    public LocationLiveData getLocationLiveData() {
        return locationLiveData;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (disposable != null) {
            disposable.clear();
            disposable = null;
        }
    }
}
