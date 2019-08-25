package com.ppai.timemgr.tasklist.db;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.ppai.timemgr.tasklist.bean.TaskEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * DataVisitor
 */
public class DataVisitor {
    private static String[] columns = new String[]{DatabaseHelper._ID, DatabaseHelper.SUBJECT, DatabaseHelper.DESC};

    private DatabaseHelper dbHelper;

    private Context context;

    private SQLiteDatabase database;

    public DataVisitor(Context c) {
        context = c;
    }

    public DataVisitor open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public void insert(String name, String desc) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(DatabaseHelper.SUBJECT, name);
        contentValue.put(DatabaseHelper.DESC, desc);
        database.insert(DatabaseHelper.TABLE_NAME, null, contentValue);
    }

    public void insert(List<TaskEntity> ts) {
        for (TaskEntity it : ts) {
            insert(it.getTitle(), it.getContent());
        }
    }

    public Cursor fetch() {
        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public List<TaskEntity> getAllTasks() {
        List<TaskEntity> lst = new ArrayList();
        try (Cursor cs = fetch()) {
            while (cs != null && cs.getCount() > 0) {
                TaskEntity t = new TaskEntity(cs.getString(cs.getColumnIndex(columns[0])), cs.getString(cs.getColumnIndex(columns[1])), cs.getString(cs.getColumnIndex(columns[2])));
                lst.add(t);
                if (!cs.moveToNext()) {
                    break;
                }
            }
        } finally {

        }
        return lst;
    }

    public int update(long _id, String name, String desc) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.SUBJECT, name);
        contentValues.put(DatabaseHelper.DESC, desc);
        int i = database.update(DatabaseHelper.TABLE_NAME, contentValues, DatabaseHelper._ID + " = " + _id, null);
        return i;
    }

    public void delete(long _id) {
        database.delete(DatabaseHelper.TABLE_NAME, DatabaseHelper._ID + "=" + _id, null);
    }

}
