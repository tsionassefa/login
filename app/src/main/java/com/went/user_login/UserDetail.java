package com.went.user_login;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class UserDetail extends AppCompatActivity {
    private Button Create;
    ModelT regional;
    TsionDB db;
    private EditText fullnameedit, usernameedit, emailedit, passwordedit, mobileedit, genderedite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        fullnameedit = findViewById(R.id.fullnameedit);
        usernameedit = findViewById(R.id.usernameedit);
        emailedit = findViewById(R.id.emailedit);
        passwordedit = findViewById(R.id.passwordedit);
        mobileedit = findViewById(R.id.mobileedit);
        genderedite = findViewById(R.id.genderedit);
        Create = findViewById(R.id.create);
        Create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId()==Create.getId()) {
                    ModelT regional = new ModelT ();
                    regional.setFname(fullnameedit.getText().toString());
                    regional.setUsername(usernameedit.getText().toString());
                    regional.setMail(emailedit.getText().toString());
                    regional.setPassword(passwordedit.getText().toString());
                    regional.setPhone(mobileedit.getText().toString());
                    regional.setSex(genderedite.getText().toString());
                    TsionDB db = new  TsionDB(getApplicationContext());
                    db.addMember(regional);
                    fullnameedit.setText("");
                    usernameedit.setText("");
                    emailedit.setText("");
                    passwordedit.setText("");
                    mobileedit.setText("");
                    genderedite.setText("");
                    Toast.makeText(getApplicationContext(),"you are successfully registered",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(getApplicationContext(),Main2Activity.class);
                    startActivity(intent);


                }
            }
        });
        // displayMembers();


    }

}