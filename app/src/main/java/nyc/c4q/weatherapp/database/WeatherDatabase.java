package nyc.c4q.weatherapp.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by C4Q on 2/6/18.
 */

@Database(entities = {Weather.class}, version = 1, exportSchema = false)
public abstract class WeatherDatabase extends RoomDatabase{

    private static WeatherDatabase INSTANCE;

    public static synchronized WeatherDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), WeatherDatabase.class, "Weather-database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }
}
