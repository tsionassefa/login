package com.went.user_login;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedpreferanceDB {
         Context context;
        SharedPreferences sharedPreferences;

        public SharedpreferanceDB(Context context) {
            this.context = context;
            this.sharedPreferences = context.getSharedPreferences("SP_NAME",Context.MODE_PRIVATE);
        }


        public void writeToPreference(boolean status){

            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putBoolean("LOGIN_STATUS",status);
            //editor.putString("LOGED_IN_USER",user);
            editor.commit();
        }

        public boolean readFromPreference(){

            boolean status;
            status=sharedPreferences.getBoolean("LOGIN_STATUS",false);
            return status;
        }

        public String readUserFromPreference(){
            return sharedPreferences.getString("LOGED_IN_USER","");
        }


}
