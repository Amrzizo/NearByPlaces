package com.codes.amr.nearbyplaces.ui.venuelist;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.provider.Settings;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codes.amr.nearbyplaces.R;
import com.codes.amr.nearbyplaces.base.BaseFragment;
import com.codes.amr.nearbyplaces.data.location.CurrentLocationModel;
import com.codes.amr.nearbyplaces.data.model.internet.Connection;
import com.codes.amr.nearbyplaces.internet_connection.InternetConnectionLiveData;
import com.codes.amr.nearbyplaces.utils.ViewModelFactory;

import javax.inject.Inject;

import butterknife.BindView;

public class VenueListFragment extends BaseFragment {

    private static int MIN_DISTANCE_TO_UPDATE = 500;
    public static int REQUEST_CODE = 120;

    @BindView(R.id.venue_recyclerView)
    RecyclerView venue_recyclerView;
    @BindView(R.id.venue_error)
    TextView errorTextView;
    @BindView(R.id.loading_view)
    View loadingView;

    @Inject
    ViewModelFactory viewModelFactory;
    private VenueListViewModel venueListViewModel;
    private boolean online;
    Location myLocation = null;

    @Override
    protected int layoutRes() {
        return R.layout.fragment_venue_list;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        venueListViewModel = ViewModelProviders.of(this, viewModelFactory).get(VenueListViewModel.class);
        venueListViewModel.getLocationLiveData().observe(this, this::LocationUpdate);

        InternetConnectionLiveData internetConnectionLiveData = new InternetConnectionLiveData(this, getActivity());
        internetConnectionLiveData.getConnectionType().observe(this,this::ConnectionSate);
        venue_recyclerView.addItemDecoration(new DividerItemDecoration(getBaseActivity(), DividerItemDecoration.VERTICAL));
        venue_recyclerView.setAdapter(new VenueAdapter(venueListViewModel, this));
        venue_recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        observableViewModel();
    }


    private void observableViewModel() {
        venueListViewModel.getVenuesData().observe(this, data -> {
            if (data != null) venue_recyclerView.setVisibility(View.VISIBLE);
        });

        venueListViewModel.getError().observe(this, isError -> {
            if (isError != null) if (isError) {
                errorTextView.setVisibility(View.VISIBLE);
                venue_recyclerView.setVisibility(View.GONE);
                errorTextView.setText("An Error Occurred While Loading Data!");
            } else {
                errorTextView.setVisibility(View.GONE);
                errorTextView.setText(null);
            }
        });

        venueListViewModel.getLoading().observe(this, isLoading -> {
            if (isLoading != null) {
                loadingView.setVisibility(isLoading ? View.VISIBLE : View.GONE);
                if (isLoading) {
                    errorTextView.setVisibility(View.GONE);
                    venue_recyclerView.setVisibility(View.GONE);
                }
            }
        });
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 100: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    venueListViewModel.getLocationLiveData().requestLocationUpdates();

                }
                return;
            }

        }
    }

    private void ConnectionSate(Connection connectionModel) {
        if (!connectionModel.getIsConnected()){

                startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
        }
        else {
            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION},
                    REQUEST_CODE);
            online = true;
            venueListViewModel.getLocationLiveData().requestLocationUpdates();

        }
    }

    private void LocationUpdate(CurrentLocationModel currentLocationModel) {

        if (currentLocationModel.isEnable() && online) {
            if (myLocation == null) {
                myLocation = currentLocationModel.getLocation();
                venueListViewModel.getNearLocations(myLocation.getLatitude() + "," + myLocation.getLongitude());

            } else {
                if (myLocation.distanceTo(currentLocationModel.getLocation()) >= MIN_DISTANCE_TO_UPDATE) {
                    myLocation = currentLocationModel.getLocation();
                    venueListViewModel.getNearLocations(myLocation.getLatitude() + "," + myLocation.getLongitude());

                }
            }

        } else {
            if (online)
                startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
            else
                online = false;

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.real_time:
                venueListViewModel.getLocationLiveData().requestLocationUpdates();

            case R.id.single_update:
                venueListViewModel.getLocationLiveData().stopLocationUpdates();
        }
        return super.onOptionsItemSelected(item);
    }


}
