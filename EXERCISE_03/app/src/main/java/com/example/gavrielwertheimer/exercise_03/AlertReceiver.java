package com.example.gavrielwertheimer.exercise_03;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;


public class AlertReceiver extends BroadcastReceiver {
    private static final String TAG = "AlarmReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {

        Log.i(TAG, "on receive");
        NotificationService.startActionNotify(context);
        Log.i(TAG,"startActionsSent");
    }
}
