package com.example.gavrielwertheimer.exercise_03;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.Context;
import android.content.res.Resources;
import android.nfc.Tag;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.util.Log;


public class NotificationService extends IntentService {
    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String ACTION_ALARM = "com.example.gavrielwertheimer.exercise_03.action.ALARM";
    private static final String ACTION_NOTIFY = "com.example.gavrielwertheimer.exercise_03.action.NOTIFY";
    private static String name = "Quote";
    private static int counter =5;
    //private  Resources res = getResources();
     // private  String[] quotes = res.getStringArray(R.array.quotes);
    private static String[] quotes;
    public NotificationService() {
        super("NotificationService");
    }


    // TODO: Customize helper method
    public static void startActionAlarm(Context context) {
        Intent intent = new Intent(context, NotificationService.class);
        intent.setAction(ACTION_ALARM);
        context.startService(intent);

    }

    // TODO: Customize helper method
    public static void startActionNotify(Context context) {
        Intent intent = new Intent(context, NotificationService.class);
        intent.setAction(ACTION_NOTIFY);

        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ALARM.equals(action)) {

                handleActionAlarm();
            } else if (ACTION_NOTIFY.equals(action)) {

                handleActionNotify();
            }
        }
    }
    private static final String TAG = "handle action alarm";

    private void handleActionAlarm() {


        quotes = this.getResources().getStringArray(R.array.quotes);
        Log.i(TAG, "started");
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlertReceiver.class);
        intent.setAction(ACTION_NOTIFY);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this,1,intent,0);

            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,0,3000,pendingIntent);







    }

    private static final String TAG2 = "handle action notify";
    private void handleActionNotify() {
        Log.i(TAG2,"started");
        if(counter>=quotes.length)
            counter=0;
        NotificationHelper notificationHelper = new NotificationHelper(this);
        NotificationCompat.Builder nb = notificationHelper.getChannel1Notification(name,quotes[counter]);
        notificationHelper.getManager().notify(1,nb.build());

       // if(counter>=quotes.length)
        //    counter=0;

       counter++;

    }
}
