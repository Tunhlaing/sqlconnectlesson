package com.example.sqlconnectlesson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
RecyclerView rvStudent;
TextView tvName, tvGrade;
ImageView btAdd;
StudentDBHelper db;
//ImageView btEdit, btDelete;

StudentAdapter studentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        clickHandler();

        db = new StudentDBHelper(MainActivity.this);
        studentAdapter = new StudentAdapter(db.getAllStudentList(),db);
        DividerItemDecoration dv = new DividerItemDecoration(this,RecyclerView.VERTICAL);
        rvStudent.addItemDecoration(dv);
        rvStudent.setAdapter(studentAdapter);
        rvStudent.setLayoutManager(new LinearLayoutManager(this));


    }

    void initViews(){
        rvStudent = findViewById(R.id.rvStudent);
        btAdd = findViewById(R.id.btAdd);
        tvName = findViewById(R.id.tvName);
        tvGrade = findViewById(R.id.tvGrade);
//        btEdit = findViewById(R.id.btEdit);
//        btDelete = findViewById(R.id.btDelete);

    }

    public void clickHandler(){
    btAdd.setOnClickListener(view -> {
        Intent i = new Intent(MainActivity.this,AddStudent.class);
        startActivity(i);

    });

    }


}