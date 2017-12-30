package com.akhilpatoliya.androidvideoplayer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by akhil.patoliya on 12/30/2017.
 */

public class NetworkReceiver extends BroadcastReceiver {

    public interface NetworkListener {
        void onNetworkAvailable();
        void onNetworkUnavailable();
    }

    private NetworkListener networkListener;

    public NetworkReceiver(NetworkListener networkListener) {
        this.networkListener = networkListener;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if(Utils.isOnline(context))
            networkListener.onNetworkAvailable();
        else
            networkListener.onNetworkUnavailable();
    }
}
