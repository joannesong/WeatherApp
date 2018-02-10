package nyc.c4q.weatherapp;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import nyc.c4q.weatherapp.model.Periods;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

/**
 * Created by c4q on 2/7/18.
 */

public class Help extends SQLiteOpenHelper {


    private static final String DATA_BASE = "TEST";
    private static final int DATABASE_VERSION = 1;

    public Help(Context context) {
        super(context, DATA_BASE, null, DATABASE_VERSION);
    }

   static {
     cupboard().register(Periods.class);
   }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        cupboard().withDatabase(db).upgradeTables();
    }
}
