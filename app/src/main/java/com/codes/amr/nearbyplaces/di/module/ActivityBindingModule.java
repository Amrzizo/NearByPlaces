package com.codes.amr.nearbyplaces.di.module;

import com.codes.amr.nearbyplaces.ui.main.MainActivity;
import com.codes.amr.nearbyplaces.ui.main.MainFragmentBindingModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = {MainFragmentBindingModule.class})
    abstract MainActivity bindMainActivity();
}
