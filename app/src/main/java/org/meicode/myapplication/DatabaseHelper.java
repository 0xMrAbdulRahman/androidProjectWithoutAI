package org.meicode.myapplication;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="login";
    private static final String COL_USER="username";
    private static final String COL_Email="email";
    private static final String COL_password="password";
    public DatabaseHelper( Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Users(ID INTEGER PRIMARY KEY AUTOINCREMENT , USERNAME TEXT UNIQUE ,EMAIL TEXT ,PASSWORD TEXT )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE  IF EXISTS Users");
        onCreate(db);



    }


    public boolean insertData(String username,String email,String password){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues =new ContentValues();
        contentValues.put(COL_USER,username);
        contentValues.put(COL_Email,email);
        contentValues.put(COL_password,password);
        long result=db.insert("Users",null,contentValues);
        return result!=-1;
    }
    @SuppressLint("Range")
    public String checkData(String username, String password){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor =db.query("Users", null,  COL_USER + "=? AND " + COL_password + "=?",   new String[]{username, password},
 null, null, null );
        String result = null;
        if(cursor!=null&& cursor.moveToFirst()){
            result=cursor.getString(cursor.getColumnIndex(COL_USER));
            cursor.close();
        }
        return result;
    }
}
