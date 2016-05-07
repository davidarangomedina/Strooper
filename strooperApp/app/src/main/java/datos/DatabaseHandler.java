package datos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by openlab on 29/04/2016.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    protected static final String DATABASE_NAME = "strooperjj";


    public DatabaseHandler(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    public void onCreate (SQLiteDatabase db){
        String sql="CREATE TABLE jugador "+
                "( _id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nombre TEXT, " +
                "nick TEXT, "+
                "clave TEXT);";
        db.execSQL(sql);
    }

    public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion){
        String sql = "DROP TABLE IF EXISTS jugador;";
        db.execSQL(sql);
        onCreate(db);
    }
}
