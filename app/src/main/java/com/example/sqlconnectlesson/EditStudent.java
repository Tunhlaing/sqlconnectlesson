package com.example.sqlconnectlesson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class EditStudent extends AppCompatActivity {
    EditText etStudentNameEdit,etStudentGradeEdit,etStudentRoomNoEdit,etStudentFatherEdit;
    RadioButton rbFemaleEdit, rbMaleEdit;
    Button btEditStudent;
    StudentDBHelper dbHelper;

    int student_id;
    String student_name;
    String student_grade;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);
        initView();
        dbHelper = new StudentDBHelper(this);
        handleClick();


        student_id = getIntent().getIntExtra("student_id",0);
        student_name = getIntent().getStringExtra("student_name");
        student_grade = getIntent().getStringExtra("student_grade");

        etStudentNameEdit.setText(student_name);
        etStudentGradeEdit.setText(student_grade);
    }
    private void initView() {
        etStudentNameEdit = findViewById(R.id.etStudentNameEdit);
        etStudentGradeEdit = findViewById(R.id.etStudentGradeEdit);
        etStudentRoomNoEdit = findViewById(R.id.etStudentRoomNoEdit);
        etStudentFatherEdit = findViewById(R.id.etStudentFatherEdit);
        rbFemaleEdit = findViewById(R.id.rbFemaleEdit);
        rbMaleEdit = findViewById(R.id.rbMaleEdit);
        btEditStudent = findViewById(R.id.btEditStudent);

    }
    private void handleClick() {
        btEditStudent.setOnClickListener(view -> {
            if (dbHelper.updateStudent(student_id,etStudentNameEdit.getText().toString(),etStudentGradeEdit.getText().toString())) {
                Utils.showToast(this,"Students Update Successfully");
            } else {
                Utils.showToast(this,"something is wrong, please try Again");

            }
            finish();
        });
    }
}