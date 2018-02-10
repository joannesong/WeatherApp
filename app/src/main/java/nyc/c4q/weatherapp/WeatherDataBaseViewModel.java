package nyc.c4q.weatherapp;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import java.util.List;

import nyc.c4q.weatherapp.database.Weather;
import nyc.c4q.weatherapp.database.WeatherDatabase;

/**
 * Created by C4Q on 2/8/18.
 */

public class WeatherDataBaseViewModel extends AndroidViewModel {

    private final List<Weather> weather;

    public WeatherDataBaseViewModel(@NonNull Application application) {
        super(application);

        weather = WeatherDatabase
                .getDatabase(getApplication())
                .weatherDao()
                .getWeather();
    }

    public List<Weather> getWeather(){
        return weather;
    }
}
