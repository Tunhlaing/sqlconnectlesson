package com.example.sqlconnectlesson;

public class StudentModal {
    private int student_id;
    private String student_name;
    private String student_grade;
    private String student_room;
    private String student_father;

    public StudentModal(int student_id, String student_name, String student_grade, String student_room, String student_father) {
        this.student_id = student_id;
        this.student_name = student_name;
        this.student_grade = student_grade;
        this.student_room = student_room;
        this.student_father = student_father;
    }

    public int getStudent_id() {
        return student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public String getStudent_grade() {
        return student_grade;
    }

    public String getStudent_room() {
        return student_room;
    }

    public String getStudent_father() {
        return student_father;
    }
}






