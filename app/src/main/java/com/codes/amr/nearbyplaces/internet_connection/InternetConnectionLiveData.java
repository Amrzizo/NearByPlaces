package com.codes.amr.nearbyplaces.internet_connection;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;

import com.codes.amr.nearbyplaces.data.model.internet.Connection;


public class InternetConnectionLiveData implements LifecycleObserver {
    public static final int Mobile = 2;
    public static final int Wifi = 1;
    private Context mContext;
    private MutableLiveData<Connection> connectionLiveData = new MutableLiveData<>();

    public InternetConnectionLiveData(LifecycleOwner lifecycleOwner, Context context) {
        mContext = context;
        lifecycleOwner.getLifecycle().addObserver(this);
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    void registerYourReceiver() {
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        mContext.registerReceiver(networkReceiver, filter);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void unRegisterYourReceiver() {
        mContext.unregisterReceiver(networkReceiver);
    }

     public MutableLiveData<Connection> getConnectionType() {
        return connectionLiveData;
    }

    private BroadcastReceiver networkReceiver = new BroadcastReceiver() {
        @SuppressWarnings("deprecation")
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getExtras()!=null) {
                NetworkInfo activeNetwork = (NetworkInfo) intent.getExtras().get(ConnectivityManager.EXTRA_NETWORK_INFO);

                boolean isConnected = activeNetwork != null &&
                        activeNetwork.isConnected();
                if (isConnected)
                    switch (activeNetwork.getType()){
                        case  ConnectivityManager.TYPE_WIFI:
                             connectionLiveData.postValue(new Connection(Wifi, true));
                             break;
                        case ConnectivityManager.TYPE_MOBILE:
                             connectionLiveData.postValue(new Connection(Mobile, true));
                             break;

                    }
                else
                    connectionLiveData.postValue(new Connection(0, false));

            }
        }

    };
}