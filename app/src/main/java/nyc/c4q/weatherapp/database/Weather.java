package nyc.c4q.weatherapp.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import nyc.c4q.weatherapp.model.WeatherPOJO;

/**
 * Created by C4Q on 2/6/18.
 */

@Entity(tableName = "weather")
public class Weather {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "icon")
    private String icon;

    @ColumnInfo
    private int mintempf;

    @ColumnInfo
    private int maxtempf;

    @ColumnInfo
    private String datetimeiso;

    public Weather(){
        //room will need a no-args constructor for default.
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getMintempf() {
        return mintempf;
    }

    public void setMintempf(int mintempf) {
        this.mintempf = mintempf;
    }

    public int getMaxtempf() {
        return maxtempf;
    }

    public void setMaxtempf(int maxtempf) {
        this.maxtempf = maxtempf;
    }

    public String getDatetimeiso() {
        return datetimeiso;
    }

    public void setDatetimeiso(String datetimeiso) {
        this.datetimeiso = datetimeiso;
    }

}
