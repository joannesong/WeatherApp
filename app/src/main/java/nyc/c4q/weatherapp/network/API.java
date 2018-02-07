package nyc.c4q.weatherapp.network;

import nyc.c4q.weatherapp.model.WeatherPOJO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by jervon.arnoldd on 2/4/18.
 */

public interface API {

    @GET("/forecasts/11212")
    Call<WeatherPOJO> getForcast(@Query("client_id") String client_id, @Query("client_secret") String secret);
}
