package nyc.c4q.weatherapp.controller;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.weatherapp.R;
import nyc.c4q.weatherapp.database.Weather;
import nyc.c4q.weatherapp.model.WeatherPOJO;

/**
 * Created by C4Q on 2/9/18.
 */

public class WeatherRVAdapter extends RecyclerView.Adapter<WeatherRVAdapter.WeatherRVViewHolder> {

    private final List<Weather> weatherList;

    public WeatherRVAdapter(List<Weather> weatherList) {
        this.weatherList = weatherList;
    }

    @Override
    public WeatherRVAdapter.WeatherRVViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.forecast_itemview, parent, false);
        return new WeatherRVViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WeatherRVAdapter.WeatherRVViewHolder holder, int position) {
        holder.bind(weatherList.get(position));
    }

    @Override
    public int getItemCount() {
        return weatherList.size();
    }

    // !!!!!!!********* ATTENTION JOANNE **********!!!!!!!

    public class WeatherRVViewHolder extends RecyclerView.ViewHolder{

        //Joanne please set the data you want in the forecast.
        //I'm just seeing if the DB is actually working the way it should. Also please see db test!
        //Not sure what they're referencing in the json.

        public WeatherRVViewHolder(View itemView) {
            super(itemView);
        }

        public void bind(Weather weather) {
        }
    }
}
