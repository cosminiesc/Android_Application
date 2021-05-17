package com.example.kiai;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.kiai.Login.RegisterFragment;

public class DataBase extends SQLiteOpenHelper {

    public static final String CUSTOMER_TABLE = "CUSTOMER_TABLE";
    public static final String COLUMN_CUSTOMER_FIRST_NAME = "CUSTOMER_FIRST_NAME";
    public static final String COLUMN_CUSTOMER_LAST_NAME = "CUSTOMER_LAST_NAME";
    public static final String COLUMN_CUSTOMER_EMAIL = "CUSTOMER_EMAIL";
    public static final String COLUMN_CUSTOMER_PASS = "CUSTOMER_PASS";
    public static final String COLUMN_ID = "ID";

    public DataBase(@Nullable Context context ) {
        super(context,"customer.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement= "CREATE TABLE " + CUSTOMER_TABLE + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_CUSTOMER_FIRST_NAME + " TXT," + COLUMN_CUSTOMER_LAST_NAME + " TXT," + COLUMN_CUSTOMER_EMAIL + " TXT," + COLUMN_CUSTOMER_PASS + " INT)";

        db.execSQL(createTableStatement);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addOne(CustomerModel customerModel){

        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();

        cv.put(COLUMN_CUSTOMER_FIRST_NAME,customerModel.getFirstName());
        cv.put(COLUMN_CUSTOMER_LAST_NAME,customerModel.getLastName());
        cv.put(COLUMN_CUSTOMER_EMAIL,customerModel.getEmail());
        cv.put(COLUMN_CUSTOMER_PASS,customerModel.getPassword());

        long insert = db.insert(CUSTOMER_TABLE, null, cv);
        if(insert==-1){
            return false;
        }
        else {
            return true;
        }

    }

    public boolean deleteOne(CustomerModel customerModel){

        SQLiteDatabase db= this.getWritableDatabase();
        String queryString="DELETE FROM " + CUSTOMER_TABLE + " WHERE " + COLUMN_ID + " = " + customerModel.getId();

        Cursor cursor = db.rawQuery(queryString, null);

        if(cursor.moveToFirst()){
            return true;
        }
        else{
            return false;
        }

    }

    public boolean hasObject(String email,int password){

        String queryString="SELECT * FROM " + CUSTOMER_TABLE;
        SQLiteDatabase db=this.getReadableDatabase();

        Cursor cursor = db.rawQuery(queryString,null);

        if(cursor.moveToFirst()){
            do{
                String customerEmail=cursor.getString(3);
                int customerPassword=cursor.getInt(4);

                if(email.equals(customerEmail) && password==customerPassword) return true;

            }while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return false;
    }
}
