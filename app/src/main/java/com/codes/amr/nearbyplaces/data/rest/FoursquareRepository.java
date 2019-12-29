package com.codes.amr.nearbyplaces.data.rest;


import com.codes.amr.nearbyplaces.data.model.Image.ImageResponse;
import com.codes.amr.nearbyplaces.data.model.Response;
import com.codes.amr.nearbyplaces.data.model.VenueModel.VenueResponse;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Single;

public class FoursquareRepository {

    private final FoursquareApiService foursquareApiService;

    @Inject
    public FoursquareRepository(FoursquareApiService foursquareApiService) {
        this.foursquareApiService = foursquareApiService;
    }
    public Single<Response> getNearLocations(String sortBy, int page, String apiKey) {
        return foursquareApiService.getLocations(sortBy, page, apiKey);
    }
//    public   Observable<retrofit2.Response<ImageResponse>>  getPhotos(String id, int limit, String versionDate) {
//        return foursquareApiService.getPhotos(id, limit, versionDate);
//    }
//
//    public   Observable<retrofit2.Response<VenueResponse>>  getVenue(String id, String versionDate) {
//        return foursquareApiService.getVenue(id, versionDate);
//    }

}
