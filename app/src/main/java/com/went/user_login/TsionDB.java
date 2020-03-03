package com.went.user_login;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.security.cert.Extension;
import java.util.ArrayList;
import java.util.List;

public class TsionDB extends SQLiteOpenHelper {
  Context context;
     public static String DBName = "UserDB";
     public static String tables = "userTable";
     public static String id="_id";
    public static int version = 1;
    private static final String con_1 = "fullnames";
    private static final String con_2 = "usernames";
    private static final String con_3 = "emails";
    private static final String con_4 = "passwords";
    private static final String con_5 = "mobiles";
    private static final String con_6 = "sex";

    public TsionDB(Context context) {
        super(context, "UserDB", null, 1);

this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
            sqLiteDatabase.execSQL("create table usertable (_id text, fullnames text,usernames text,emails text,passwords text,mobiles text,sexs text )");
        } catch (Exception ex) {
            Log.e("EngidaDB", "Table creation Erro", ex);
        }

    }
    public void addMember(ModelT regionModel) {
            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("fullname", regionModel.getFname ());
            values.put("usernames", regionModel.getUsername());
            values.put("emails",regionModel.getMail());
            values.put("passwords", regionModel.getPassword());
            values.put("mobiles", regionModel.getPhone());
            values.put("sexs", regionModel.getSex());
            long r=sqLiteDatabase.insert("usertable", null, values);
            if(r==-1)
            Toast.makeText(context,"not successfully inserteded",Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(context,"successfully inserteded",Toast.LENGTH_SHORT).show();
    }
    public List<ModelT> getAllUsers() {
        List<ModelT> userList = new ArrayList<ModelT>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT  * FROM usertable", null);
        if (cursor.moveToFirst()) {
            do {
                ModelT users = new ModelT();
                users.setFname(cursor.getString(0));
                users.setUsername(cursor.getString(1));
                users.setMail(cursor.getString(2));
                users.setPassword(cursor.getString(3));
                users.setPhone(cursor.getString(4));
                users.setSex(cursor.getString(5));
                userList.add(users);
            } while (cursor.moveToNext());
        }
        return userList;

    }

    public boolean check(String username,String password){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from usertable",null);
        boolean valid=false;
        while(cursor.moveToNext()){
            String n=cursor.getString(1);
            String p=cursor.getString(3);
            if(username.equals(n) && password.equals(p)){
                valid=true;
                break;
            }
        }
      return valid;
    }

    @Override
    //updated
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists usertable");
        onCreate(sqLiteDatabase);
    }

    public int delete(int p){
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor=getAll();
        cursor.moveToPosition(p);
        // cursor.getString(1);
        return db.delete("usertable","usernames=?",new String[]{cursor.getString(1)});
    }


    public Cursor getAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT *FROM usertable", null);
    }
}
