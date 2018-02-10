package nyc.c4q.weatherapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by joannesong on 2/7/18.
 */

public class WeatherViewHolder extends RecyclerView.ViewHolder{
    private TextView forcastDay;
    private TextView forcastDate;
    private ImageView forecastImage;
    private TextView forecastWeatherText;
    private TextView maxTemp;
    private TextView minTemp;

    public WeatherViewHolder(View itemView) {
        super(itemView);

        forcastDay = itemView.findViewById(R.id.day_forecast_iv);
        forcastDate = itemView.findViewById(R.id.date_forecast_iv);
        forecastImage = itemView.findViewById(R.id.image_forecast_iv);
        forecastWeatherText = itemView.findViewById(R.id.text_forecast_iv);
        maxTemp = itemView.findViewById(R.id.maxTemp_forecast_iv);
        minTemp = itemView.findViewById(R.id.minTemp_forecast_iv);
    }

}
