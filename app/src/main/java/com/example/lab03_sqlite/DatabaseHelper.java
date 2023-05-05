package com.example.lab03_sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_CREATE = "create table Person (id integer primary key autoincrement, "
            + "name text not null," +
            "phone text not null);";


    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(DATABASE_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int NewVersion) {

        db.execSQL("DROP TABLE IF EXISTS users");
        onCreate(db);

    }
}
