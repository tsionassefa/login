package com.went.user_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class Main2Activity extends AppCompatActivity {
  private Button creatAccount,loginButton;
    TsionDB db;
  EditText username;
  EditText password;
    SharedpreferanceDB sharedpreferanceDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        creatAccount=findViewById(R.id.creat_account);
        loginButton=findViewById(R.id.login);
        username = findViewById(R.id.user_nameedit);
        password = findViewById(R.id.user_passedit);
        db=new TsionDB(this);

        sharedpreferanceDB =new SharedpreferanceDB ( getApplicationContext ());

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=username.getText().toString();
                String pass=password.getText().toString();
                if(!name.isEmpty() && !pass.isEmpty()){
                    if(db.check(name,pass)){
                        Toast.makeText(getApplicationContext(),"successfully logined",Toast.LENGTH_SHORT).show();
                sharedpreferanceDB.writeToPreference(true);
                Intent intent=new Intent(Main2Activity.this,RecyclerClass.class);
                startActivity(intent);
                username.setText("");
                password.setText("");
                finish();
                    }else{
                        Toast.makeText(getApplicationContext(), "invalid username and password!", Toast.LENGTH_SHORT).show();
                        username.setText("");
                        password.setText("");
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "please enter username and password", Toast.LENGTH_SHORT).show();
                }
            }
        });
        if(sharedpreferanceDB.readFromPreference()){
            Intent intent=new Intent(Main2Activity.this,RecyclerClass.class);
            startActivity(intent);
            finish();
        }else {
            Toast.makeText(this,"you can logged by entering username and password",Toast.LENGTH_SHORT).show();
        }
        creatAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
        Intent intent = new Intent(Main2Activity.this, UserDetail.class);
        startActivity(intent);
            }
        });
    }

}
