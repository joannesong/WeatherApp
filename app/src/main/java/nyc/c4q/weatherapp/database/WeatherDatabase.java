package nyc.c4q.weatherapp.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;

import nyc.c4q.weatherapp.model.Periods;

/**
 * Created by C4Q on 2/6/18.
 */

@Database(entities = {Periods.class}, version = 6, exportSchema = false)
public abstract class WeatherDatabase extends RoomDatabase{

    private static WeatherDatabase INSTANCE;

    public static WeatherDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    WeatherDatabase.class, "WeatherDatabase")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance(){
        INSTANCE =  null;
    }

    public abstract WeatherDao weatherDao();

}
