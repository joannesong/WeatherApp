package nyc.c4q.weatherapp;

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
import android.view.View;
import android.widget.Button;

import nyc.c4q.weatherapp.network.API;
import nyc.c4q.weatherapp.model.WeatherPOJO;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    Retrofit retrofit;
    String id = "Mbfz6KHEyqiIF93hy5XRj";
    String secret = "I7jQI5udlLdLO6N9XQ9mPzRRBppwaN8XznscuLNs";
    private static final int NOTIFICATION_ID = 555;
    String NOTIFICATION_CHANNEL = "C4Q Notifications";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        setUP();
//        launchTestService();
//        mNotifyManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNotification();
            }
        });


    }

    public void sendNotification() {
        Intent intent = new Intent(this, MainActivity.class);
//        int requestID = (int) System.currentTimeMillis(); // Unique requestID to differentiate between various notification with same notification ID
//        int flags = PendingIntent.FLAG_CANCEL_CURRENT; // Cancel old intent and create new one

        PendingIntent pendingIntent = PendingIntent.getActivity(this, NOTIFICATION_ID, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL)
                .setSmallIcon(R.drawable.cloud)
                .setContentTitle("You've been notified!")
                .setContentIntent(pendingIntent)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
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
                    WeatherPOJO forcast = response.body();
                    Log.e("Successessful", forcast.getResponse().get(0).getPeriods().get(0).getIcon() + "");
                }


            }

            @Override
            public void onFailure(Call<WeatherPOJO> call, Throwable t) {
                Log.e("Failed", t.getMessage());
            }
        });
    }

    public void launchTestService() {
        Intent i = new Intent(this, MyIntentService.class);
        startService(i);
    }
}
