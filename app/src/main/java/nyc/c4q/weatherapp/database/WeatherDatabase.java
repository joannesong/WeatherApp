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

@Database(entities = {WeatherEntity.class}, version = 6, exportSchema = false)
public abstract class WeatherDatabase extends RoomDatabase{
    public static String DATABASE_NAME = "WeatherData";
    public final static String COLUMN_ITEMS = "weatherdata";

    private static WeatherDatabase INSTANCE;

    public static WeatherDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context, WeatherDatabase.class, DATABASE_NAME)
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
