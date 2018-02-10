package nyc.c4q.weatherapp.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import java.util.List;

import nyc.c4q.weatherapp.model.Periods;

/**
 * Created by C4Q on 2/6/18.
 */

@Dao
public interface WeatherDao {

    @Query("SELECT * FROM weatherdata")
    List<Periods> getForecast();

    @Query("SELECT * FROM weatherdata WHERE id LIKE :id LIMIT 1")
    Periods findById(int id);

    @Insert
    void insertAll(List<Periods> forecast);

    @Update
    void update(Periods periods);

    @Delete
    void delete(Periods periods);

}
