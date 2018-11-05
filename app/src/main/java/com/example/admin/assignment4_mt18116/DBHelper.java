package com.example.admin.assignment4_mt18116;



import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.Toast;

    public class DBHelper extends SQLiteOpenHelper
    {
        private static final int DATABASE_VERSION = 1;
        private static final String DATABASE_NAME = "MySensor";
        private static final String TABLE_SENSOR_ACCELEROMETER = "Accelerometer_Readings";
        private static final String TABLE_SENSOR_GYROSCOPE = "Gyroscope_Readings";
        private static final String TABLE_SENSOR_ORIENTATION = "Orientation_Readings";
        private static final String TABLE_SENSOR_PROXIMITY = "Proximity_Readings";
        private static final String KEY_ID = "id";
        private static final String KEY_Xaxis = "";
        private static final String KEY_Yaxis = "";
        private static final String KEY_Zaxis= "";
        private static final String TIMESTAMP = "";

        private SQLiteDatabase dbase;

        public DBHelper(Context context)
        {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase)
        {
            dbase = sqLiteDatabase;
            String sql1 = "CREATE TABLE IF NOT EXISTS " + TABLE_SENSOR_ACCELEROMETER + " ( "
                    + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_Xaxis
                    + " TEXT1, " + KEY_Yaxis + " TEXT2, " + KEY_Zaxis + "TEXT3, " + TIMESTAMP + "DATETIME)";
            String sql2 = "CREATE TABLE IF NOT EXISTS " + TABLE_SENSOR_GYROSCOPE + " ( "
                    + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_Xaxis
                    + " TEXT1, " + KEY_Yaxis + " TEXT2, " + KEY_Zaxis + "TEXT3, " + TIMESTAMP + "DATETIME)";
            String sql3 = "CREATE TABLE IF NOT EXISTS " + TABLE_SENSOR_ORIENTATION + " ( "
                    + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_Xaxis
                    + " TEXT1, " + KEY_Yaxis + " TEXT2, " + KEY_Zaxis + "TEXT3, " + TIMESTAMP + "DATETIME)";
            String sql4 = "CREATE TABLE IF NOT EXISTS " + TABLE_SENSOR_PROXIMITY + " ( "
                    + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_Xaxis
                    + " TEXT1, " + KEY_Yaxis + " TEXT2, " + KEY_Zaxis + "TEXT3, " + TIMESTAMP + "DATETIME)";
            sqLiteDatabase.execSQL(sql1);
            sqLiteDatabase.execSQL(sql2);
            sqLiteDatabase.execSQL(sql3);
            sqLiteDatabase.execSQL(sql4);
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
        {
            dbase.execSQL("DROP TABLE IF EXISTS " + TABLE_SENSOR_ACCELEROMETER);
            dbase.execSQL("DROP TABLE IF EXISTS " + TABLE_SENSOR_GYROSCOPE);
            dbase.execSQL("DROP TABLE IF EXISTS " + TABLE_SENSOR_ORIENTATION);
            dbase.execSQL("DROP TABLE IF EXISTS " + TABLE_SENSOR_PROXIMITY);
            onCreate(dbase);
        }


        public void updatecolAcc(int id , String x, String y, String z, String time)
        {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues c = new ContentValues();
            c.put(KEY_Xaxis , x);
            c.put(KEY_Yaxis , y);
            c.put(KEY_Zaxis , z);
            c.put(TIMESTAMP , time);
            String s = "" + id ;
            db.insert(TABLE_SENSOR_ACCELEROMETER , s , c);
            db.close();
        }


    }

