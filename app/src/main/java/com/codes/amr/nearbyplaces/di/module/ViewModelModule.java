package com.codes.amr.nearbyplaces.di.module;


import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.codes.amr.nearbyplaces.di.utils.ViewModelKey;
import com.codes.amr.nearbyplaces.ui.venuelist.VenueListViewModel;
import com.codes.amr.nearbyplaces.utils.ViewModelFactory;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(VenueListViewModel.class)
    abstract ViewModel bindListViewModel(VenueListViewModel venueListViewModel);



    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);
}
