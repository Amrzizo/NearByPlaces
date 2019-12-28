package com.codes.amr.nearbyplaces.ui.main;

import com.codes.amr.nearbyplaces.ui.venuelist.VenueListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainFragmentBindingModule {

    @ContributesAndroidInjector
    abstract VenueListFragment provideVenueListFragment();

}
