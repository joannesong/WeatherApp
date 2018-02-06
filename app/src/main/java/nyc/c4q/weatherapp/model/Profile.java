package nyc.c4q.weatherapp.model;

/**
 * Created by jervon.arnoldd on 2/5/18.
 */

public class Profile {
    private String tz;

    public String getTz ()
    {
        return tz;
    }

    public void setTz (String tz)
    {
        this.tz = tz;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [tz = "+tz+"]";
    }
}
