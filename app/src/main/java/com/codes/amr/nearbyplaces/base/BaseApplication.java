package com.codes.amr.nearbyplaces.base;

import com.codes.amr.nearbyplaces.di.component.ApplicationComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class BaseApplication extends DaggerApplication {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
//        ApplicationComponent component =  DaggerApplicationComponent.builder().application(this).build();
//        component.inject(this);

        return null;
    }
}
