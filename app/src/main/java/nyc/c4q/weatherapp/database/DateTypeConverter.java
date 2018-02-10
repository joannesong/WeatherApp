package nyc.c4q.weatherapp.database;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

/**
 * Created by C4Q on 2/9/18.
 */

public class DateTypeConverter {

    @TypeConverter
    public static Date toDate(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long toLong(Date value) {
        return value == null ? null : value.getTime();
    }


}
