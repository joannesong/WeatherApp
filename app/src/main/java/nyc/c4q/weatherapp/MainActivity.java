package nyc.c4q.weatherapp;



import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.arch.persistence.room.Room;
import android.content.ComponentName;
import android.database.sqlite.SQLiteDatabase;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.arch.persistence.room.Room;
import android.icu.util.Calendar;
import android.icu.util.GregorianCalendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import nl.qbusict.cupboard.QueryResultIterable;
import nyc.c4q.weatherapp.JobSchedulerStuff.WeatherJobService;
import nyc.c4q.weatherapp.Fragments.ForeCastFragment;
import nyc.c4q.weatherapp.Fragments.MapFragment;
import nyc.c4q.weatherapp.Fragments.NOWFragment;
import nyc.c4q.weatherapp.database.WeatherDatabase;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

import nyc.c4q.weatherapp.model.Periods;

import nyc.c4q.weatherapp.network.API;
import nyc.c4q.weatherapp.model.WeatherPOJO;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


import static nl.qbusict.cupboard.CupboardFactory.cupboard;

public class MainActivity extends AppCompatActivity {
    private static final int JOB_ID = 1;
    Retrofit retrofit;

import static android.app.AlarmManager.INTERVAL_DAY;

public class MainActivity extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Help help = new Help(this);
        dq = help.getWritableDatabase();
//        setUP();


        JobScheduler jobScheduler = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);
        JobInfo.Builder networkJobScheduler = new JobInfo
                .Builder(JOB_ID, new ComponentName(getApplicationContext(), WeatherJobService.class))
                .setMinimumLatency(1000)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED);
        jobScheduler.schedule(networkJobScheduler.build());


//        WeatherDatabase wdb = Room.databaseBuilder(getApplicationContext(), WeatherDatabase.class,
//                "WeatherDatabase").build();


        mViewPager = findViewById(R.id.container);
        setupViewPager(mViewPager);

        setUP();
        networkCall();
        scheduleAlarm();
        picker = findViewById(R.id.timePicker);


        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }


        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                sendNotification();
            }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void onDateSelectedButtonClick(View view) {
        int hour = picker.getHour();
        int minute = picker.getMinute();

    }

    public void launchTestService() {
        Intent i = new Intent(this, NotificationService.class);
        startService(i);
    }


    @TargetApi(Build.VERSION_CODES.N)
    public void scheduleAlarm() {

//        Calendar cur_cal = new GregorianCalendar();
//        cur_cal.setTimeInMillis(System.currentTimeMillis());//set the current time and date for this calendar
//
//        Calendar cal = new GregorianCalendar();
//        cal.add(Calendar.DAY_OF_YEAR, cur_cal.get(Calendar.DAY_OF_YEAR));
//        cal.set(Calendar.HOUR_OF_DAY, picker.getHour());
//        cal.set(Calendar.MINUTE, picker.getMinute());
//        cal.set(Calendar.SECOND, 0);
//        cal.set(Calendar.MILLISECOND, 0);
//        cal.set(Calendar.DATE, cur_cal.get(Calendar.DATE));
//        cal.set(Calendar.MONTH, cur_cal.get(Calendar.MONTH));
//        long times = cal.getTimeInMillis();

        Intent intent = new Intent(getApplicationContext(), MyAlarmReceiver.class);
        final PendingIntent pendingIntent = PendingIntent.getBroadcast(this, MyAlarmReceiver.REQUEST_CODE, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarm = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
//        long minuteFromNow = System.currentTimeMillis() + 60 * 1000;
        alarm.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), AlarmManager.INTERVAL_FIFTEEN_MINUTES, pendingIntent);
//        alarm.setInexactRepeating(AlarmManager.RTC_WAKEUP, minuteFromNow, AlarmManager.INTERVAL_FIFTEEN_MINUTES, pendingIntent);
    }

    private void setupViewPager(ViewPager viewPager) {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new NOWFragment(), "Now");
        adapter.addFragment(new ForeCastFragment(), "ForeCast");
        adapter.addFragment(new MapFragment(), "Map");
        viewPager.setAdapter(adapter);

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


//    public void sendNotification() {
//        Intent intent = new Intent(this, MainActivity.class);
////        int requestID = (int) System.currentTimeMillis(); // Unique requestID to differentiate between various notification with same notification ID
////        int flags = PendingIntent.FLAG_CANCEL_CURRENT; // Cancel old intent and create new one
//
//        PendingIntent pendingIntent = PendingIntent.getActivity(this, NOTIFICATION_ID, intent, PendingIntent.FLAG_CANCEL_CURRENT);
//        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL)
//                .setSmallIcon(R.drawable.cloud)
//                .setContentTitle("You've been notified!")
//                .setContentIntent(pendingIntent)
//                .setDefaults(NotificationCompat.DEFAULT_ALL)
//                .setContentText("This is your notification text.");
//        notificationManager.notify(NOTIFICATION_ID, builder.build());
//    }

    public void sendNotification() {
        Intent intent = new Intent(this, MainActivity.class);
//        int requestID = (int) System.currentTimeMillis(); // Unique requestID to differentiate between various notification with same notification ID
//        int flags = PendingIntent.FLAG_CANCEL_CURRENT; // Cancel old intent and create new one
        PendingIntent pendingIntent = PendingIntent.getActivity(this, NOTIFICATION_ID, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL)
                .setSmallIcon(R.mipmap.sun_round)
                .setContentTitle("You've been notified!")
                .setContentIntent(pendingIntent)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentText("This is your notification text.");
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }


    public void setUP() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.aerisapi.com/forecasts/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        networkCall();
    }

    public void networkCall() {
        API api = retrofit.create(API.class);
        Call<WeatherPOJO> call = api.getForcast(id, secret);
        call.enqueue(new Callback<WeatherPOJO>() {
            @Override
            public void onResponse(Call<WeatherPOJO> call, Response<WeatherPOJO> response) {
                if (response.isSuccessful()) {
//                    WeatherPOJO forcast = response.body().getResponse().get(1).getPeriods();
                    List<Periods> forcast = response.body().getResponse().get(0).getPeriods();
//                    int forecastSize = forcast.getResponse().size();
//                    Log.e("Successessful", forcast.getResponse().get(0).getPeriods().get(0).getIcon() + "");
//                    Log.e("Logging size:",forcast.getResponse().size()+"");

                    for (int i = 0; i < forcast.size(); i++) {
                        cupboard().withDatabase(dq).put(forcast.get(i));
                    }

                }
            }

            @Override
            public void onFailure(Call<WeatherPOJO> call, Throwable t) {

                Log.e("Failed", t.getMessage());
            }
        });

//        WeatherDatabase wdb = Room.databaseBuilder(getApplicationContext(), WeatherDatabase.class,
//                "WeatherDatabase").build();

//        Log.e("Failed", t.getMessage());
    }

    public void getPeriod(){
        List<Periods> yolo = new ArrayList<>();

        QueryResultIterable<Periods> test = cupboard().withDatabase(dq).query(Periods.class).query();
        for (Periods p: test) {
             yolo.add(p);
        }
        Log.e("My data baseList is:" ,yolo.size()+"");
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







