package com.example.sqlconnectlesson;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {
    final private ArrayList<StudentModel> studentModalArrayList;
    final private StudentDBHelper db;

    public StudentAdapter(ArrayList<StudentModel> studentModalArrayList, StudentDBHelper db) {
        this.studentModalArrayList = studentModalArrayList;
        this.db = db;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_of_student,parent,false);
        return new StudentViewHolder(v);
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        holder.tvName.setText(studentModalArrayList.get(position).getStudent_name());
        holder.tvGrade.setText(studentModalArrayList.get(position).getStudent_grade());

        holder.btDelete.setOnClickListener(view -> {
            db.deleteStudent(studentModalArrayList.get(position).getStudent_id());
            studentModalArrayList.remove(studentModalArrayList.get(position));
            notifyDataSetChanged();
        });

       holder.btEdit.setOnClickListener(view -> {
           //holder.itemView.getContext().startActivity(new Intent(holder.itemView.getContext(),EditStudent.class));
           Intent i = new Intent(holder.btEdit.getContext(),EditStudent.class);
            i.putExtra("student_id",studentModalArrayList.get(position).getStudent_id());
           i.putExtra("student_name",studentModalArrayList.get(position).getStudent_name());
           i.putExtra("student_grade",studentModalArrayList.get(position).getStudent_grade());
            holder.btEdit.getContext().startActivity(i);
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
            btEdit = itemView.findViewById(R.id.btEdit);

        }

    }
}
