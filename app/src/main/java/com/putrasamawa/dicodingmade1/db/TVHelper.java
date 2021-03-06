package com.putrasamawa.dicodingmade1.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

//* Satria Junanda *//

public class TVHelper {

    private static String DATABASE_TABLE = TVContract.MovieColumns.TABLE_MOVIE;
    private Context context;
    private DatabaseHelper databaseHelper;

    private SQLiteDatabase sqliteDatabase;

    public TVHelper(Context context) {
        this.context = context;
    }

    public TVHelper open() throws SQLException {
        databaseHelper = new DatabaseHelper(context);
        sqliteDatabase = databaseHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        sqliteDatabase.close();
    }

    public Cursor queryProvider() {
        return sqliteDatabase.query(
                DATABASE_TABLE,
                null,
                null,
                null,
                null,
                null,
                TVContract.MovieColumns._ID + " DESC"
        );
    }

    public Cursor queryByIdProvider(String id) {
        return sqliteDatabase.query(DATABASE_TABLE, null
                , TVContract.MovieColumns.MOVIE_ID + " = ?"
                , new String[]{id}
                , null
                , null
                , null
                , null);
    }

    public long insertProvider(ContentValues values) {
        return sqliteDatabase.insert(DATABASE_TABLE, null, values);
    }

    public int updateProvider(String id, ContentValues values) {
        return sqliteDatabase.update(DATABASE_TABLE, values,
                TVContract.MovieColumns.MOVIE_ID + " = ?", new String[]{id});
    }

    public int deleteProvider(String id) {
        return sqliteDatabase.delete(DATABASE_TABLE,
                TVContract.MovieColumns.MOVIE_ID + " = ?", new String[]{id});
    }
}

//* Satria Junanda *//
