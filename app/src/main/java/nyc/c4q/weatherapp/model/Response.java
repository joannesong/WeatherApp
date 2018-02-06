package nyc.c4q.weatherapp.model;

/**
 * Created by jervon.arnoldd on 2/5/18.
 */

public class Response {
    private Periods[] periods;

    private String interval;

    private Profile profile;

    public Periods[] getPeriods ()
    {
        return periods;
    }

    public void setPeriods (Periods[] periods)
    {
        this.periods = periods;
    }

    public String getInterval ()
    {
        return interval;
    }

    public void setInterval (String interval)
    {
        this.interval = interval;
    }



    public Profile getProfile ()
    {
        return profile;
    }

    public void setProfile (Profile profile)
    {
        this.profile = profile;
    }

//    @Override
//    public String toString()
//    {
//        return "ClassPojo [periods = "+periods+", interval = "+interval+", profile = "+profile+"]";
//    }
}
