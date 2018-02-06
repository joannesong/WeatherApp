package nyc.c4q.weatherapp.network;

import java.util.List;

import nyc.c4q.weatherapp.network.Response;

/**
 * Created by joannesong on 2/5/18.
 */

public class WeatherPOJO {

    private List<Response> response;
    private boolean success;

    public List<Response> getResponse() {
        return response;
    }

    public boolean getSuccess() {
        return success;
    }
}
