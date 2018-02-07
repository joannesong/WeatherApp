package nyc.c4q.weatherapp.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by C4Q on 2/6/18.
 */

@Database(entities = {Weather.class}, version = 1, exportSchema = false)
public abstract class WeatherDatabase extends RoomDatabase{
    public abstract WeatherDao weatherDao();
}
