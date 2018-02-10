package nyc.c4q.weatherapp.database;

import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import java.util.List;

import nyc.c4q.weatherapp.MainActivity;
import nyc.c4q.weatherapp.model.Periods;
import nyc.c4q.weatherapp.model.Response;
import nyc.c4q.weatherapp.model.Weather;
import nyc.c4q.weatherapp.network.API;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by c4q on 2/7/18.
 */

public class DatabaseInitializer {
    private static final String TAG = DatabaseInitializer.class.getName();

    private static final String id = "Mbfz6KHEyqiIF93hy5XRj";
    private static final String secret = "I7jQI5udlLdLO6N9XQ9mPzRRBppwaN8XznscuLNs";

    public static void populateAsync(@NonNull final WeatherDatabase db) {
        PopulateDbAsync task = new PopulateDbAsync(db);
        task.execute();
    }

//    public static void populateSync(@NonNull final WeatherDatabase db) {
//        populateWithTestData(db);
//    }

    private void add(final WeatherDatabase db, List<Periods> user) {
        db.weatherDao().insertAll(user);
    }



//    private static void populateWithTestData(WeatherDatabase db) {
//        Periods user = new Periods();
//        user.setFirstName("Ajay");
//        user.setLastName("Saini");
//        user.setAge(25);
//
//
//        List<Periods> userList = db.userDao().getAll();
//        Log.d(DatabaseInitializer.TAG, "Rows Count: " + userList.size());
//    }


    public static List<Periods> getall(final WeatherDatabase db) {
        return db.weatherDao().getForecast();
    }

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final WeatherDatabase mDb;


        PopulateDbAsync(WeatherDatabase db) {
            mDb = db;

        }



        @Override
        protected Void doInBackground(final Void... params) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.aerisapi.com/forecasts/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            API api = retrofit.create(API.class);
            Call<Weather> call = api.getForcast("34.1786998,-86.6154153", id, secret);
            call.enqueue(new Callback<Weather>() {
                @Override
                public void onResponse(Call<Weather> call, retrofit2.Response<Weather> response) {
                    if (response.isSuccessful()) {
                        List<Periods> forecast = response.body().getResponse().get(0).getPeriods();
                        mDb.weatherDao().insertAll(forecast);
                        Log.e("Logging size:", forecast.size() + "");

                    }
                }
                @Override
                public void onFailure(Call<Weather> call, Throwable t) {
                    Log.e("Failed", t.getMessage());
                }
            });
            return null;
        }

    }
}
