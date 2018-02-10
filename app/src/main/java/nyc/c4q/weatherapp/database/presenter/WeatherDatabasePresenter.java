package nyc.c4q.weatherapp.database.presenter;

import android.content.Context;

import nyc.c4q.weatherapp.database.WeatherDatabase;
import retrofit2.Retrofit;

/**
 * Created by C4Q on 2/9/18.
 */

public class WeatherDatabasePresenter {

    // a reference to your room database. assume it has a method something like: database.addData(Data data)
    private WeatherDatabase weatherDatabase;

    // a reference to your retrofit api. assume it has a method something like: api.getData()
    private Retrofit retrofit;

    public WeatherDatabasePresenter(WeatherDatabase weatherDatabase, Retrofit retrofit) {
        this.weatherDatabase = weatherDatabase;
        this.retrofit = retrofit;
    }

    public void fetchAndStoreData(Context context) {
        WeatherDatabase weatherDatabase = WeatherDatabase.getDatabase(context);// pretend there is an actual enqueue/whatever call that gets data from the api
        weatherDatabase.weatherDao();
    }
}
