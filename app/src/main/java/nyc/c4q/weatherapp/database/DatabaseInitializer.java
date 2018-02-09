package nyc.c4q.weatherapp.database;

import android.os.AsyncTask;
import android.support.annotation.NonNull;

import java.util.List;

import nyc.c4q.weatherapp.model.Response;

/**
 * Created by c4q on 2/7/18.
 */

public class DatabaseInitializer {

    public static void populateAsync(@NonNull final WeatherDatabase database, @NonNull final List<Response> responseList) {
        PopulateAsync task = new PopulateAsync();
        task.execute();
    }

    private static class PopulateAsync extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }
    }
}
