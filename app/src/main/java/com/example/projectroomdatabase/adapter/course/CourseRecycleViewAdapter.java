package com.example.projectroomdatabase.adapter.course;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectroomdatabase.R;
import com.example.projectroomdatabase.model.Course;

import java.util.List;

public class CourseRecycleViewAdapter extends RecyclerView.Adapter<CourseRecycleViewAdapter.viewHolder> {
    List<Course> allCourse;

    public CourseRecycleViewAdapter(List<Course> allCourse) {
        this.allCourse = allCourse;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.course_item_layout,parent,false);
        return new viewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Course course= allCourse.get(position);
        holder.courseName.setText("Course "+(position+1));
        holder.courseCredit.setText(course.getCourseCredit()+"");
        holder.courseGpa.setText(course.getCourseGpa()+"");
    }

    @Override
    public int getItemCount() {
        if (allCourse.isEmpty()){
            return 0;
        } else {
            allCourse.size();
        }
        return allCourse.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        TextView courseName, courseCredit, courseGpa;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            courseName= itemView.findViewById(R.id.textView4);
            courseCredit= itemView.findViewById(R.id.textView5);
            courseGpa= itemView.findViewById(R.id.textView6);
        }
    }
}
