package nyc.c4q.weatherapp.model;

/**
 * Created by jervon.arnoldd on 2/5/18.
 */

public class WeatherCoded {
    private String timestamp;

    private String wx;

    private String dateTimeISO;

    public String getTimestamp ()
    {
        return timestamp;
    }

    public void setTimestamp (String timestamp)
    {
        this.timestamp = timestamp;
    }

    public String getWx ()
    {
        return wx;
    }

    public void setWx (String wx)
    {
        this.wx = wx;
    }

    public String getDateTimeISO ()
    {
        return dateTimeISO;
    }

    public void setDateTimeISO (String dateTimeISO)
    {
        this.dateTimeISO = dateTimeISO;
    }

//    @Override
//    public String toString()
//    {
//        return "ClassPojo [timestamp = "+timestamp+", wx = "+wx+", dateTimeISO = "+dateTimeISO+"]";
//    }
}
