package com.went.user_login;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerClass extends AppCompatActivity {
    private RecyclerView recy;
    private RecyclerView.LayoutManager layoutManager;
    TsionDB db;
    private Button logoutBtn;
    private RecyclerAdapter adapter;
    SharedpreferanceDB sharedpreferanceDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_class);
        recy = findViewById(R.id.recyclerview);
        logoutBtn = findViewById(R.id.logout);
        //contact=getall();
        TsionDB db = new TsionDB(getApplicationContext());
        layoutManager = new LinearLayoutManager(this);
        recy.setLayoutManager(layoutManager);
        List<ModelT> contact = db.getAllUsers();
        adapter = new RecyclerAdapter(getApplicationContext(), contact);
        //recy.setHasFixedSize(true);
        recy.setAdapter(adapter);
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedpreferanceDB=new SharedpreferanceDB(getApplicationContext());
                sharedpreferanceDB.writeToPreference(false);
                Intent intent = new Intent(RecyclerClass.this, Main2Activity.class);
                startActivity(intent);
            }
        });
    }
}
