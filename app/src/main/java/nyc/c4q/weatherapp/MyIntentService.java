package nyc.c4q.weatherapp;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.support.annotation.Nullable;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class MyIntentService extends IntentService {
    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String ACTION_FOO = "nyc.c4q.weatherapp.action.FOO";
    private static final String ACTION_BAZ = "nyc.c4q.weatherapp.action.BAZ";

    // TODO: Rename parameters
    private static final String EXTRA_PARAM1 = "nyc.c4q.weatherapp.extra.PARAM1";
    private static final String EXTRA_PARAM2 = "nyc.c4q.weatherapp.extra.PARAM2";

    private static final String SERVICE_NAME = "notification-service";


    public MyIntentService() {
        super(SERVICE_NAME);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // if you override onCreate(), make sure to call super().
        // If a Context object is needed, call getApplicationContext() here.
    }


    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

    }
}
