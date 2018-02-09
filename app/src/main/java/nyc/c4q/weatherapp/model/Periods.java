package nyc.c4q.weatherapp.model;

import java.util.List;

public class Periods {
    private String sunsetiso;
    private int sunset;
    private String sunriseiso;
    private int sunrise;
    private boolean isday;
    private String icon;
    private String cloudscoded;
    private String weatherprimarycoded;
    private String weatherprimary;
    private List<Weathercoded> weatherCoded;
    private String weather;
    private int feelslikef;
    private int feelslikec;
    private int snowin;
    private int snowcm;
    private int sky;
    private int uvi;
    private int humidity;
    private int pop;
    private int avgtempf;
    private int avgtempc;
    private int mintempf;
    private int mintempc;
    private int maxtempf;
    private int maxtempc;
    private String datetimeiso;
    private String validtime;
    private int timestamp;

    public String getSunsetiso() {
        return sunsetiso;
    }

    public int getSunset() {
        return sunset;
    }

    public String getSunriseiso() {
        return sunriseiso;
    }

    public int getSunrise() {
        return sunrise;
    }

    public boolean getIsday() {
        return isday;
    }

    public String getIcon() {
        return icon;
    }

    public String getCloudscoded() {
        return cloudscoded;
    }

    public String getWeatherprimarycoded() {
        return weatherprimarycoded;
    }

    public String getWeatherprimary() {
        return weatherprimary;
    }

    public List<Weathercoded> getWeathercoded() {
        return weatherCoded;
    }
    public String getWeather() {
        return weather;
    }

    public int getFeelslikef() {
        return feelslikef;
    }

    public int getFeelslikec() {
        return feelslikec;
    }

    public int getSnowin() {
        return snowin;
    }

    public int getSnowcm() {
        return snowcm;
    }

    public int getSky() {
        return sky;
    }

    public int getUvi() {
        return uvi;
    }

    public int getHumidity() {
        return humidity;
    }

    public int getPop() {
        return pop;
    }

    public int getAvgtempf() {
        return avgtempf;
    }

    public int getAvgtempc() {
        return avgtempc;
    }

    public int getMintempf() {
        return mintempf;
    }

    public int getMintempc() {
        return mintempc;
    }

    public int getMaxtempf() {
        return maxtempf;
    }

    public int getMaxtempc() {
        return maxtempc;
    }

    public String getDatetimeiso() {
        return datetimeiso;
    }

    public String getValidtime() {
        return validtime;
    }

    public int getTimestamp() {
        return timestamp;
    }
}
