package nyc.c4q.weatherapp;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.SharedPreferences;

import nyc.c4q.weatherapp.database.WeatherDatabase;

/**
 * Created by C4Q on 2/9/18.
 */

public class App extends Application {

    public static App INSTANCE;
    private static final String DATABASE_NAME = "WeatherDatabase";
    private static final String PREFERENCES = "Room.preferences";
    private static final String KEY_FORCE_UPDATE = "force_update";

    private WeatherDatabase weatherDatabase;

    public static App get(){
        return INSTANCE;
    }

    @Override
    public void onCreate(){
        super.onCreate();

        weatherDatabase = Room.databaseBuilder(getApplicationContext(), WeatherDatabase.class, DATABASE_NAME)
                .addMigrations(weatherDatabase.MIGRATION_1_2)
                .build();

        INSTANCE = this;

    }

    public WeatherDatabase getWeatherDatabase(){
        return weatherDatabase;
    }

    public boolean isForceUpdate() {
        return getSP().getBoolean(KEY_FORCE_UPDATE, true);
    }

    public void setForceUpdate(boolean force) {
        SharedPreferences.Editor edit = getSP().edit();
        edit.putBoolean(KEY_FORCE_UPDATE, force);
        edit.apply();
    }

    private SharedPreferences getSP() {
        return getSharedPreferences(PREFERENCES, MODE_PRIVATE);
    }

}
