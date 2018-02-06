package nyc.c4q.weatherapp.network;

import nyc.c4q.weatherapp.model.Forcast;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by jervon.arnoldd on 2/4/18.
 */

public interface API {

    @GET("/forecasts/11212")
    Call<Forcast> getForcast(@Query("client_id") String client_id, @Query("client_secret") String secret);
}
