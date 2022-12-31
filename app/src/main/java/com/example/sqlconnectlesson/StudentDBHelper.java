package com.example.sqlconnectlesson;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class StudentDBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "student_db";
    private static final int DB_VERSION = 1;
    private final String STUDENT_TABLE = "tbl_student";
    //private final Context context;
    String STUDENT_ID = "student_id";
    String STUDENT_NAME = "student_name";
    String STUDENT_GRADE = "student_grade";
    String STUDENT_ROOM = "student_room";
    String STUDENT_FATHER = "student_father";
    String STUDENT_GENDER = "student_gender";


    public StudentDBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        //this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + STUDENT_TABLE + " ("
                + STUDENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + STUDENT_NAME + " TEXT,"
                + STUDENT_GRADE + " TEXT,"
                + STUDENT_ROOM + " TEXT," +
                STUDENT_FATHER + " TEXT,"
                + STUDENT_GENDER + " TEXT)";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + STUDENT_TABLE);
        onCreate(db);

    }

    boolean addNewStudent(String student_name, String student_grade, String student_room, String student_father) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(STUDENT_NAME, student_name);
        cv.put(STUDENT_GRADE, student_grade);
        cv.put(STUDENT_ROOM, student_room);
        cv.put(STUDENT_FATHER, student_father);

        try {
            db.insert(STUDENT_TABLE, null, cv);
            db.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            db.close();
            return false;
        }

    }
    ArrayList<StudentModal> getAllStudentList(){
    SQLiteDatabase db = this.getReadableDatabase();
    Cursor cursor = db.rawQuery("SELECT * FROM " + STUDENT_TABLE, null);
        ArrayList<StudentModal>  studentModalArrayList = new ArrayList<>();
        if(cursor.moveToFirst()){
        while (!cursor.isAfterLast()){

            @SuppressLint("Range") int student_id = cursor.getInt(cursor.getColumnIndex("student_id"));
            @SuppressLint("Range") String student_name = cursor.getString(cursor.getColumnIndex("student_name"));
            @SuppressLint("Range") String student_grade = cursor.getString(cursor.getColumnIndex("student_grade"));
            @SuppressLint("Range") String student_room = cursor.getString(cursor.getColumnIndex("student_room"));
            @SuppressLint("Range") String student_father = cursor.getString(cursor.getColumnIndex("student_father"));
            StudentModal studentModal = new StudentModal(student_id,student_name,student_grade,student_room,student_father);
            studentModalArrayList.add(studentModal);
            cursor.moveToNext();
        }
    }

    cursor.close();

        return studentModalArrayList;
    }
    boolean deleteStudent(int student_id){
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            db.delete(STUDENT_TABLE,"student_id=" + student_id,null);
            db.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            db.close();
            return false;
        }

    }

}

