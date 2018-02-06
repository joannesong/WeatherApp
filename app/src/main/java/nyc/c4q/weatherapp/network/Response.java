package nyc.c4q.weatherapp.network;

import java.util.List;

public class Response {
    private Profile profile;
    private List<Periods> periods;
    private String interval;

    public Profile getProfile() {
        return profile;
    }

    public List<Periods> getPeriods() {
        return periods;
    }

    public String getInterval() {
        return interval;
    }

}
