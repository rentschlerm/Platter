package com.example.platter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper{
    // Define constants for the database name and version
    private static final String DATABASE_NAME = "Platter_DB";
    private static final int DATABASE_VERSION = 1;



//    public static final String ADMIN_TABLE = "Admin";
//    public static final String COLUMN_ADMIN_NAME = "name";
//    public static final String COLUMN_ADMIN_PASSWORD = "name";
//    public static final String COLUMN_AGE = "age";

    // Define the SQL statement to create the database table
    private static final String CREATE_ADMIN_TABLE = (
            "Create Table If Not Exists Admin(Admin_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " Admin_UserName TEXT, Admin_Password TEXT, Role_ID INTEGER, " +
                    "FOREIGN KEY(Role_ID) REFERENCES Role(Role_ID));");

    private static final String CREATE_DINER_TABLE = (
            "Create Table If Not Exists Diner(Diner_ID	INTEGER PRIMARY KEY AUTOINCREMENT,"+
            "Diner_FirstName	TEXT,"+
            "Diner_LastName	TEXT,"+
            "Diner_Email	TEXT,"+
            "Diner_ContactNumber	NUMERIC,"+
            "Role_ID	INTEGER,"+
    "FOREIGN KEY(Role_ID) REFERENCES Role(Role_ID))");

    private static final String CREATE_MenuList_TABLE = (
            "Create Table If Not Exists MenuList (Food_ID INTEGER PRIMARY KEY AUTOINCREMENT,"+
            "Food_Name	TEXT,"+
            "Food_Image	BLOB,"+
            "Food_Price	INTEGER,"+
            "Food_Quantity	INTEGER,"+
            "Category_ID	INTEGER,"+
    "FOREIGN KEY(Category_ID) REFERENCES Food_Category(Category_ID))");

    private static final String CREATE_FoodCategory_TABLE = (
            "Create Table If Not Exists Food_Category(Category_ID INTEGER PRIMARY KEY," +
                    "Category_Name TEXT)");
    private static final String CREATE_Role_TABLE = (
            "Create Table If Not Exists Role(Role_ID INTEGER PRIMARY KEY," +
                    "Role_Name TEXT)");

    // Implement the constructor to create the database
    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Implement the onCreate method to create the database table
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_ADMIN_TABLE);
        db.execSQL(CREATE_DINER_TABLE);
        db.execSQL(CREATE_MenuList_TABLE);
        db.execSQL(CREATE_FoodCategory_TABLE);
        db.execSQL(CREATE_Role_TABLE);

    }

    // Implement the onUpgrade method to upgrade the database schema
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // For simplicity, we'll just drop the old table and create a new one
//        db.execSQL("DROP TABLE IF EXISTS " + "Admin");
//        db.execSQL("DROP TABLE IF EXISTS " + "DINER");
//        db.execSQL("DROP TABLE IF EXISTS " + "MenuList");
//        db.execSQL("DROP TABLE IF EXISTS " + "FoodCategory");
//        db.execSQL("DROP TABLE IF EXISTS " + "Role");
//        onCreate(db);
    }

    public void queryData(String sql)
    {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }

    // Define methods to insert, update, and delete data from the database
    public boolean insertDataAdmin(String Admin_UserName, String Admin_Password) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Admin_UserName", Admin_UserName);
        values.put("Admin_Password", Admin_Password);

        long rowId = db.insert("Admin", null, values);
        if (rowId != -1) {
            Log.d("MainActivity", "New record inserted with row ID: " + rowId);
            return true;
        } else {
            Log.d("MainActivity", "Failed to insert new record.");
            return false;
        }
//        db.close();
//        return rowId;
    }

//public void insertData(String name, String price, byte[] image)
//{
//    SQLiteDatabase db = getWritableDatabase();
//    String sql =
//}

    public boolean checkusername(String Admin_UserName)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from Admin where Admin_UserName = ?", new String[] {Admin_UserName});
        if(cursor.getCount()>0)
        {
            return true;
        }
        else
            return false;
    }
    public boolean checkusernamepassword(String Admin_UserName, String Admin_Password)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from Admin where Admin_UserName = ? and Admin_Password = ?", new String[] {Admin_UserName,Admin_Password});
        if(cursor.getCount()>0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }


//    public int updateData(long id, String name, int age) {
//        SQLiteDatabase db = getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_NAME, name);
//        values.put(COLUMN_AGE, age);
//        String selection = COLUMN_ID + " = ?";
//        String[] selectionArgs = { String.valueOf(id) };
//        int count = db.update(TABLE_NAME, values, selection, selectionArgs);
//        db.close();
//        return count;
//    }
//
//    public int deleteData(long id) {
//        SQLiteDatabase db = getWritableDatabase();
//        String selection = COLUMN_ID + " = ?";
//        String[] selectionArgs = { String.valueOf(id) };
//        int count = db.delete(TABLE_NAME, selection, selectionArgs);
//        db.close();
//        return count;
//    }
//
//    // Define a method to query the database and return a cursor
//    public Cursor getData() {
//        SQLiteDatabase db = getReadableDatabase();
//        String[] projection = { COLUMN_ID, COLUMN_NAME, COLUMN_AGE };
//        String sortOrder = COLUMN_NAME + " ASC";
//        Cursor cursor = db.query(TABLE_NAME, projection, null, null, null, null, sortOrder);
//        return cursor;
//    }
//
//    public void deleteAllData() {
//        SQLiteDatabase db = getReadableDatabase();
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
//        onCreate(db);
//        db.close();
//    }
}
