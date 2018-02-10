package nyc.c4q.weatherapp;


import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.arch.persistence.room.Room;
import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import nyc.c4q.weatherapp.Fragments.ForeCastFragment;
import nyc.c4q.weatherapp.Fragments.MapFragment;
import nyc.c4q.weatherapp.Fragments.NOWFragment;
import nyc.c4q.weatherapp.JobSchedulerStuff.WeatherJobService;
import nyc.c4q.weatherapp.database.DatabaseInitializer;
import nyc.c4q.weatherapp.database.WeatherDao;
import nyc.c4q.weatherapp.database.WeatherDatabase;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.weatherapp.model.Periods;
import nyc.c4q.weatherapp.model.Weathercoded;
import nyc.c4q.weatherapp.network.API;
import nyc.c4q.weatherapp.model.Weather;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {
    private static final int JOB_ID = 1;
    private RecyclerView recyclerView;

    String id = "Mbfz6KHEyqiIF93hy5XRj";
    String secret = "I7jQI5udlLdLO6N9XQ9mPzRRBppwaN8XznscuLNs";

    private static final int NOTIFICATION_ID = 555;
    String NOTIFICATION_CHANNEL = "C4Q Notifications";
    SQLiteDatabase dq;


    private static final String TAG = "MainActivity";

    private ViewPager mViewPager;
    private Retrofit retrofit;

    // This is the date picker used to select the date for our notification
    private TimePicker picker;
    private FusedLocationProviderClient mFusedLocationClient;
    double lat;
    double lng;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        getLocation();
        context = getApplicationContext();
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
//        sendNotification();
//        jobScheduler();
        setup();
//        WeatherDatabase wdb = Room.databaseBuilder(getApplicationContext(), WeatherDatabase.class,
//                "WeatherDatabase").build();
//        setupViews();
//        networkCall();

        DatabaseInitializer.populateAsync(WeatherDatabase.getDatabase(context));
        List<Periods> test= DatabaseInitializer.getall(WeatherDatabase.getDatabase(context));


        Log.e("Test",test.size()+"");
    }

    private void retrieveWeather() {
        setup();
    }

    private void jobScheduler() {
        JobScheduler jobScheduler = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);
        JobInfo.Builder networkJobScheduler = new JobInfo
                .Builder(JOB_ID, new ComponentName(getApplicationContext(), WeatherJobService.class))
                .setMinimumLatency(1000)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED);
        jobScheduler.schedule(networkJobScheduler.build());
    }

    public void setupViews() {
        mViewPager = findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

    public void setup() {
        getLocation();
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.aerisapi.com/forecasts/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        API api = retrofit.create(API.class);
        Call<Weather> call = api.getForcast(lat + "," + lng, id, secret);
        call.enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {
                if (response.isSuccessful()) {
                    List<Periods> forecast = response.body().getResponse().get(0).getPeriods();

                    DatabaseInitializer.populateAsync(WeatherDatabase.getDatabase(context));

                    Log.e("Logging size:", forecast.size() + "");

                }
            }

            @Override
            public void onFailure(Call<Weather> call, Throwable t) {
                Log.e("Failed", t.getMessage());
            }
        });
    }
    private void setupViewPager(ViewPager viewPager) {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new NOWFragment(), "Now");
        adapter.addFragment(new ForeCastFragment(), "ForeCast");
        adapter.addFragment(new MapFragment(), "Map");
        viewPager.setAdapter(adapter);

    }
    public void getLocation() {
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ||
                ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION}, 1020);
        } else {
            mFusedLocationClient.getLastLocation()
                    .addOnSuccessListener(this, location -> {
                        if (location != null) {
                            lat = location.getLatitude();
                            lng = location.getLongitude();
                            Log.e("My Location", lat + "," + lng);
                        }
                    });
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tabb, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.refresh:

                break;
            case R.id.add:

                break;
            case R.id.settings:

                break;
        }
        Toast.makeText(getApplicationContext(), "You Just Clicked:" + item.getTitle(), Toast.LENGTH_SHORT).show();

        return super.onOptionsItemSelected(item);
    }
    public void sendNotification() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), NOTIFICATION_ID, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), NOTIFICATION_CHANNEL)
                .setSmallIcon(R.mipmap.sun_round)
                .setContentTitle("You've been notified!")
                .setContentIntent(pendingIntent)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentText("This is your notification text.");
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }


    public void networkCall() {
        getLocation();
        List<Periods> forcast = new ArrayList<>();
        API api = retrofit.create(API.class);
        Call<Weather> call = api.getForcast(lat + "," + lng, id, secret);
        call.enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {
                if (response.isSuccessful()) {
                    List<Periods> forcast = response.body().getResponse().get(0).getPeriods();
                    Log.e("Logging size:", forcast.size() + "");
                }
            }

            @Override
            public void onFailure(Call<Weather> call, Throwable t) {
                Log.e("Failed", t.getMessage());
            }
        });
//        WeatherDatabase wdb = Room.databaseBuilder(getApplicationContext(), WeatherDatabase.class,
//                "WeatherDatabase").build();
    }

    private class SectionsPageAdapter extends FragmentPagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        public SectionsPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }
    }

}

