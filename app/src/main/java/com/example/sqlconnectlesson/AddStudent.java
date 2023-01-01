package com.example.sqlconnectlesson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class AddStudent extends AppCompatActivity {

    EditText etStudentName, etStudentGrade, etStudentRoomNo,etStudentFather;
    RadioButton rbFemale,rbMale;
    Button btAddStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        initView();
        StudentDBHelper myDB = new StudentDBHelper(AddStudent.this);

        btAddStudent.setOnClickListener(view -> {

            if (myDB.addNewStudent(etStudentName.getText().toString(),
                    etStudentGrade.getText().toString(),
                    etStudentRoomNo.getText().toString(),
                    etStudentFather.getText().toString())) {
                Utils.showToast(this,"Added Student");
                finish();

            } else {
                Utils.showToast(this,"please Try Again");
            }
        });
    }

    private void initView(){
        etStudentName = findViewById(R.id.etStudentName);
        etStudentFather = findViewById(R.id.etStudentFather);
        etStudentGrade = findViewById(R.id.etStudentGrade);
        etStudentRoomNo = findViewById(R.id.etStudentRoomNo);
        rbFemale = findViewById(R.id.rbFemale);
        rbMale = findViewById(R.id.rbMale);
        btAddStudent=findViewById(R.id.btAddStudent);

    }
    }