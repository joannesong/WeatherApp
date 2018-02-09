package nyc.c4q.weatherapp.network;

import nyc.c4q.weatherapp.model.WeatherPOJO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by jervon.arnoldd on 2/4/18.
 */

public interface API {

    @GET("/forecasts/{longlat}")
    Call<WeatherPOJO> getForcast(@Path( "longlat")String longlat,@Query("client_id") String client_id, @Query("client_secret") String secret);

//    42.25,-95.25?
}
