package nyc.c4q.weatherapp;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import java.util.List;

import nyc.c4q.weatherapp.database.WeatherDatabase;
import nyc.c4q.weatherapp.database.WeatherEntity;
import nyc.c4q.weatherapp.model.Periods;
import nyc.c4q.weatherapp.model.Weather;

/**
 * Created by C4Q on 2/8/18.
 */

public class WeatherDataBaseViewModel extends AndroidViewModel {

    private final List<WeatherEntity> weatherEntityList;

    public WeatherDataBaseViewModel(@NonNull Application application) {
        super(application);

        weatherEntityList = WeatherDatabase
                .getDatabase(getApplication())
                .weatherDao()
                .getForecast();
    }

    public List<WeatherEntity> getWeather(){
        return weatherEntityList;
    }
}
