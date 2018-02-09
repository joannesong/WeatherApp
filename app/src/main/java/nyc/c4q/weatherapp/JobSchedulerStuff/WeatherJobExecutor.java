package nyc.c4q.weatherapp.JobSchedulerStuff;

import android.os.AsyncTask;
import android.util.Log;

import nyc.c4q.weatherapp.MainActivity;

/**
 * Created by c4q on 2/7/18.
 */

public class WeatherJobExecutor extends AsyncTask<Void,Void,Void> {
    MainActivity mainActivity = new MainActivity();

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        mainActivity.setup();
        Log.e("Doing Background","Runninggggggg");
        return null;
    }



}
