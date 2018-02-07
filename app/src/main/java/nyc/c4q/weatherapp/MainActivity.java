package nyc.c4q.weatherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;

import nyc.c4q.weatherapp.model.Forcast;
import nyc.c4q.weatherapp.network.API;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String id="Mbfz6KHEyqiIF93hy5XRj";
        String secret="I7jQI5udlLdLO6N9XQ9mPzRRBppwaN8XznscuLNs";

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://api.aerisapi.com/forecasts/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        API api =retrofit.create(API.class);
        Call<Forcast> call = api.getForcast(id,secret);
        call.enqueue(new Callback<Forcast>() {
            @Override
            public void onResponse(Call<Forcast> call, Response<Forcast> response) {
               if (response.isSuccessful()){
                   Forcast forcast =response.body();
//                       Log.e("Successessful", forcast.getResponse().get(0).getPeriods()[0].getAvgTempF());
               }


            }

            @Override
            public void onFailure(Call<Forcast> call, Throwable t) {
                Log.e("Failed",t.getMessage());
            }
        });

    }
}
