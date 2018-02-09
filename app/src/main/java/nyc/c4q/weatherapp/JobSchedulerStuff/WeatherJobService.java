package nyc.c4q.weatherapp.JobSchedulerStuff;

import android.annotation.SuppressLint;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import nyc.c4q.weatherapp.MainActivity;

/**
 * Created by c4q on 2/7/18.
 */

public class WeatherJobService extends JobService {
   private static final String TAG=WeatherJobService.class.getSimpleName();

   private WeatherJobExecutor weatherJobExecutor= new WeatherJobExecutor();
   private Handler handle = new Handler(new Handler.Callback() {
       @Override
       public boolean handleMessage(Message msg) {
           Toast.makeText(getApplicationContext(),"Running toast service class",Toast.LENGTH_LONG).show();
           jobFinished((JobParameters) msg.obj,true);
           return true;
       }
   });
    @Override

    public boolean onStartJob(JobParameters params) {
//        weatherJobExecutor.execute();
        Toast.makeText(getApplicationContext(),"Running toast service class",Toast.LENGTH_LONG).show();
        Log.e("Running","ONcreat");
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return true;
    }
}
