package nyc.c4q.weatherapp.model;

import java.util.List;

/**
 * Created by joannesong on 2/5/18.
 */

public class Weather {

    private List<Response> response;
    private boolean success;

    public List<Response> getResponse() {
        return response;
    }

    public boolean getSuccess() {
        return success;
    }
}
