package nyc.c4q.weatherapp.database.migration;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.migration.Migration;
import android.support.annotation.NonNull;

import nyc.c4q.weatherapp.App;

/**
 * Created by C4Q on 2/9/18.
 */

public class WeatherDBMigration {

    static final Migration MIGRATION_1_2 = new Migration(1,2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL(" :)");
            App.get().setForceUpdate(true);
        }
    };
}
