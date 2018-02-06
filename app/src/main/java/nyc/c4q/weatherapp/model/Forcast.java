package nyc.c4q.weatherapp.model;

/**
 * Created by jervon.arnoldd on 2/5/18.
 */

public class Forcast {
    private Response[] response;

    private String success;

    public Response[] getResponse ()
    {
        return response;
    }

    public void setResponse (Response[] response)
    {
        this.response = response;
    }

    public String getSuccess ()
    {
        return success;
    }

    public void setSuccess (String success)
    {
        this.success = success;
    }

//    @Override
//    public String toString()
//    {
//        return "ClassPojo [response = "+response+", success = "+success+"]";
//    }
}
