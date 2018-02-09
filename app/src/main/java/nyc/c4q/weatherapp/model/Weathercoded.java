package nyc.c4q.weatherapp.model;

/**
 * Created by jervon.arnoldd on 2/8/18.
 */

public class Weathercoded {
    long timestamp;
    String wx;
    String dateTimeISO;

    public long getTimestamp() {
        return timestamp;
    }

    public String getWx() {
        return wx;
    }

    public String getDateTimeISO() {
        return dateTimeISO;
    }
}
