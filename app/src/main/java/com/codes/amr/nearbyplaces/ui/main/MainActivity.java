package com.codes.amr.nearbyplaces.ui.main;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;

import com.codes.amr.nearbyplaces.R;
import com.codes.amr.nearbyplaces.base.BaseActivity;
import com.codes.amr.nearbyplaces.ui.venuelist.VenueListFragment;

public class MainActivity extends BaseActivity {
    private VenueListFragment venueListFragment;
    private MenuItem searchViewItem;

    @Override
    protected int layoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            venueListFragment = new VenueListFragment();
        }
        getSupportFragmentManager().beginTransaction().add(R.id.screenContainer, venueListFragment).commit();


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        venueListFragment.onOptionsItemSelected(item);
        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        venueListFragment.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
