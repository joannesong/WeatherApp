package nyc.c4q.weatherapp.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by C4Q on 2/6/18.
 */

@Dao
public interface WeatherDao {

    @Query("SELECT * FROM weather")
    List<Weather> getWeather();

    @Insert
    void insertAll(Weather...weathers);

}
