package nyc.c4q.weatherapp;

import android.content.Context;
import android.content.Intent;

import static android.support.v4.content.WakefulBroadcastReceiver.startWakefulService;

/**
 * Created by jervon.arnoldd on 2/7/18.
 */

public class BroadcastReceiver extends android.content.BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent startServiceIntent = new Intent(context, NotificationService.class);
        startWakefulService(context, startServiceIntent);
    }
}
