package com.example.sqlconnectlesson;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {
    private ArrayList<StudentModal> studentModalArrayList;
    private StudentDBHelper db;

    public StudentAdapter(ArrayList<StudentModal> studentModalArrayList, StudentDBHelper db) {
        this.studentModalArrayList = studentModalArrayList;
        this.db = db;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_of_student,parent,false);
        return new StudentViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
//        StudentModal modal = studentModalArrayList.get(position);
//        holder.tvName.setText(String.valueOf(modal.getStudent_name()));
//        holder.tvGrade.setText(String.valueOf(modal.getStudent_grade()));
        holder.tvName.setText(studentModalArrayList.get(position).getStudent_name());
        holder.tvGrade.setText(studentModalArrayList.get(position).getStudent_grade());


        holder.btDelete.setOnClickListener(view -> {
            db.deleteStudent(studentModalArrayList.get(position).getStudent_id());
            studentModalArrayList.remove(studentModalArrayList.get(position));
                notifyDataSetChanged();
        });
           }

    @Override
    public int getItemCount() {
        return studentModalArrayList.size();
    }

    public static class StudentViewHolder extends RecyclerView.ViewHolder{
        TextView tvName;
        TextView tvGrade;
        ImageView btDelete, btEdit;


        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvGrade = itemView.findViewById(R.id.tvGrade);
            btDelete = itemView.findViewById(R.id.btDelete);

        }

    }
}
