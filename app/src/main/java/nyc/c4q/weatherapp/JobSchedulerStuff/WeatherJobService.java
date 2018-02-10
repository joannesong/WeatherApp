package nyc.c4q.weatherapp.JobSchedulerStuff;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;

import android.util.Log;
import android.widget.Toast;

import java.util.List;

import nyc.c4q.weatherapp.MainActivity;
import nyc.c4q.weatherapp.database.DatabaseInitializer;
import nyc.c4q.weatherapp.database.WeatherDatabase;
import nyc.c4q.weatherapp.model.Periods;
import nyc.c4q.weatherapp.model.Weather;
import nyc.c4q.weatherapp.network.API;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by c4q on 2/7/18.
 */

public class WeatherJobService extends JobService {
   private static final String TAG = WeatherJobService.class.getSimpleName();
   private Retrofit retrofit;
   private Context context;
   //private WeatherJobExecutor weatherJobExecutor= new WeatherJobExecutor();
    @Override
    public boolean onStartJob(JobParameters params) {
        //weatherJobExecutor.execute();
        Log.e("Running","ONcreat");
        Toast.makeText(getApplicationContext(),"Running toast service class",Toast.LENGTH_LONG).show();
        DatabaseInitializer.populateAsync(WeatherDatabase.getDatabase(context));
        return true;
    }
    @Override
    public boolean onStopJob(JobParameters params) {
        return true;
    }


}