package com.went.user_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ViewMemberInfo extends AppCompatActivity {
     TextView fullname2,username2,emails2,password2,mobile2,sex2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_member_info);

        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        ModelT modelT=(ModelT)bundle.get("user");
        fullname2=findViewById(R.id.fullname2);
        fullname2.setText(modelT.getFname());
        username2=findViewById(R.id.username2);
        username2.setText(modelT.getUsername());
        emails2=findViewById(R.id.email2);
        emails2.setText(modelT.getMail());
        password2=findViewById(R.id.password2);
        password2.setText(modelT.getPassword());
        mobile2=findViewById(R.id.mobile2);
        mobile2.setText(modelT.getPhone());
        sex2=findViewById(R.id.sex2);
        sex2.setText(modelT.getSex());


    }
}
