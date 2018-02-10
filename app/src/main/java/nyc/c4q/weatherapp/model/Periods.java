package nyc.c4q.weatherapp.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "WeatherData")
public class Periods {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "sunsetiso")
    private String sunsetiso;

    @ColumnInfo(name = "sunset")
    private int sunset;

    @ColumnInfo(name = "sunriseiso")
    private String sunriseiso;

    @ColumnInfo(name = "sunrise")
    private int sunrise;

    @ColumnInfo(name = "isday")
    private boolean isday;

    @ColumnInfo(name = "icon")
    private String icon;

    @ColumnInfo(name = "cloudscoded")
    private String cloudscoded;

    @ColumnInfo(name = "weatherprimarycoded")
    private String weatherprimarycoded;

    @ColumnInfo(name = "weatherprimary")
    private String weatherprimary;

//    private List<Weathercoded> weatherCoded;

    @ColumnInfo(name = "weather")
    private String weather;

    @ColumnInfo(name = "feelslikef")
    private int feelslikef;

    @ColumnInfo(name = "feelslikec")
    private int feelslikec;

    @ColumnInfo(name = "snowin")
    private int snowin;

    @ColumnInfo(name = "snowcm")
    private int snowcm;

    @ColumnInfo(name = "sky")
    private int sky;

    @ColumnInfo(name = "uvi")
    private int uvi;

    @ColumnInfo(name = "humidity")
    private int humidity;

    @ColumnInfo(name = "pop")
    private int pop;

    @ColumnInfo(name = "avgtempf")
    private int avgtempf;

    @ColumnInfo(name = "avgtempc")
    private int avgtempc;

    @ColumnInfo(name = "mintempf")
    private int mintempf;

    @ColumnInfo(name = "mintempc")
    private int mintempc;

    @ColumnInfo(name = "maxtempf")
    private int maxtempf;

    @ColumnInfo(name = "maxtempc")
    private int maxtempc;

    @ColumnInfo(name = "datetimeiso")
    private String datetimeiso;

    @ColumnInfo(name = "validtime")
    private String validtime;

    @ColumnInfo(name = "timestamp")
    private int timestamp;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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



    public void setSunsetiso(String sunsetiso) {
        this.sunsetiso = sunsetiso;
    }

    public void setSunset(int sunset) {
        this.sunset = sunset;
    }

    public void setSunriseiso(String sunriseiso) {
        this.sunriseiso = sunriseiso;
    }

    public void setSunrise(int sunrise) {
        this.sunrise = sunrise;
    }

    public void setIsday(boolean isday) {
        this.isday = isday;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setCloudscoded(String cloudscoded) {
        this.cloudscoded = cloudscoded;
    }

    public void setWeatherprimarycoded(String weatherprimarycoded) {
        this.weatherprimarycoded = weatherprimarycoded;
    }

    public void setWeatherprimary(String weatherprimary) {
        this.weatherprimary = weatherprimary;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public void setFeelslikef(int feelslikef) {
        this.feelslikef = feelslikef;
    }

    public void setFeelslikec(int feelslikec) {
        this.feelslikec = feelslikec;
    }

    public void setSnowin(int snowin) {
        this.snowin = snowin;
    }

    public void setSnowcm(int snowcm) {
        this.snowcm = snowcm;
    }

    public void setSky(int sky) {
        this.sky = sky;
    }

    public void setUvi(int uvi) {
        this.uvi = uvi;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public void setPop(int pop) {
        this.pop = pop;
    }

    public void setAvgtempf(int avgtempf) {
        this.avgtempf = avgtempf;
    }

    public void setAvgtempc(int avgtempc) {
        this.avgtempc = avgtempc;
    }

    public void setMintempf(int mintempf) {
        this.mintempf = mintempf;
    }

    public void setMintempc(int mintempc) {
        this.mintempc = mintempc;
    }

    public void setMaxtempf(int maxtempf) {
        this.maxtempf = maxtempf;
    }

    public void setMaxtempc(int maxtempc) {
        this.maxtempc = maxtempc;
    }

    public void setDatetimeiso(String datetimeiso) {
        this.datetimeiso = datetimeiso;
    }

    public void setValidtime(String validtime) {
        this.validtime = validtime;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }
}
