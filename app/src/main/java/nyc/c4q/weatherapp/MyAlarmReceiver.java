package nyc.c4q.weatherapp;

import android.content.Context;
import android.content.Intent;

/**
 * Created by jervon.arnoldd on 2/7/18.
 */

public class MyAlarmReceiver extends BroadcastReceiver {
    public static final int REQUEST_CODE = 12345;
    public static final String ACTION = "nyc.c4q.notificationdemo.alarm";

    // Triggered by the Alarm periodically (starts the notification service)
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i = new Intent(context, NotificationService.class);
        context.startService(i);
    }
}
