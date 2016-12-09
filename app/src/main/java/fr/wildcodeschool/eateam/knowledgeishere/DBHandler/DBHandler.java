package fr.wildcodeschool.eateam.knowledgeishere.DBHandler;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.Serializable;
import java.util.ArrayList;

import fr.wildcodeschool.eateam.knowledgeishere.Model.LoginData;

public class DBHandler extends SQLiteOpenHelper implements Serializable {
    private Context mContext;
    private SQLiteDatabase mDatabase;

    /**
     * Class to communicate with database
     */
    public DBHandler(Context context) {
        super(context, "database.sqlite", null, 1);
        this.mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void openDatabase() {
        String dbPath = mContext.getDatabasePath("database.sqlite").getPath();
        if (mDatabase != null && mDatabase.isOpen()) {
            return;
        }
        mDatabase = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READWRITE);

    }

    public void closeDatabase() {
        if (mDatabase != null) {
            mDatabase.close();
        }
    }
    //get complete list of logData
    public ArrayList<LoginData> getLogList() {
        //init model
        LoginData loginData = null;
        ArrayList<LoginData> loginList = new ArrayList<>();
        openDatabase();
        // init rawQuery in cursor
        Cursor cursor = mDatabase.rawQuery("SELECT username, password FROM login ", null);
        // read database with cursor
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            loginData = new LoginData(cursor.getString(0), cursor.getString(1));
            loginList.add(loginData);
            cursor.moveToNext();

        }
        cursor.close();
        closeDatabase();
        return loginList;
    }
}
