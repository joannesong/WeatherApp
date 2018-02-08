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

//    private static final String TAG = DatabaseInitializer.class.getName();

//    public static void populateAsync(@NonNull final AppDatabase db) {
//        PopulateDbAsync task = new PopulateDbAsync(db);
//        task.execute();
//    }
//
//    public static void populateSync(@NonNull final AppDatabase db) {
//        populateWithTestData(db);
//    }
//
//    private static User addUser(final AppDatabase db, User user) {
//        db.userDao().insertAll(user);
//        return user;
//    }
//
//    private static void populateWithTestData(AppDatabase db) {
//        User user = new User();
//        user.setFirstName("Ajay");
//        user.setLastName("Saini");
//        user.setAge(25);
//        addUser(db, user);
//
//        List<User> userList = db.userDao().getAll();
//        Log.d(DatabaseInitializer.TAG, "Rows Count: " + userList.size());
//    }
//
//    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {
//
//        private final AppDatabase mDb;
//
//        PopulateDbAsync(AppDatabase db) {
//            mDb = db;
//        }
//
//        @Override
//        protected Void doInBackground(final Void... params) {
//            populateWithTestData(mDb);
//            return null;
//        }
//
//    }

}
