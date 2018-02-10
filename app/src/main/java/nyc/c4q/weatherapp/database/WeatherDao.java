package nyc.c4q.weatherapp.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import java.util.List;


/**
 * Created by C4Q on 2/6/18.
 */

@Dao
public interface WeatherDao {

    @Query("SELECT * FROM weatherdata")
    List<WeatherEntity> getForecast();

    @Query("SELECT * FROM weatherdata WHERE id IN (:id)")
    List<WeatherEntity> loadALLByIds(int[] id);

    @Query("SELECT * FROM weatherdata WHERE id LIKE :id LIMIT 1")
    WeatherEntity findByID(int id);

    @Insert
    void insertAll(WeatherEntity...weatherEntities);

    @Update
    void updatWeather(WeatherEntity...weatherEntities);

    @Delete
    void delete(WeatherEntity weatherEntity);

}
