package nyc.c4q.weatherapp.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import java.util.List;

/**
 * Created by C4Q on 2/6/18.
 */

@Dao
public interface WeatherDao {

    @Query("SELECT * FROM weather")
    List<Weather> getWeather();

    @Query("SELECT * FROM weather WHERE id LIKE :id LIMIT 1")
    Weather findById(int id);

    @Insert
    void insertAll(List<Weather> weatherList);

    @Update
    void update(Weather weather);

    @Delete
    void delete(Weather weather);

}
