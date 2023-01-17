package com.example.projectroomdatabase.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectroomdatabase.R;
import com.example.projectroomdatabase.model.Semister;

import java.util.List;

public class HomeRecyclerAdapter extends RecyclerView.Adapter<HomeRecyclerAdapter.viewholder> {
    List<Semister> mySemisterList;

    public HomeRecyclerAdapter(List<Semister> mySemisterList) {
        this.mySemisterList = mySemisterList;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.semister_recycler_item, parent,false);
        return new viewholder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        Semister currentSemister= mySemisterList.get(position);
        holder.semisterName.setText(currentSemister.getSemisterName()+"");
        holder.semisterCredit.setText(currentSemister.getSemisterCredit()+"");
    }

    @Override
    public int getItemCount() {
        if (mySemisterList==null || mySemisterList.isEmpty()){
            return 0;
        }
        return mySemisterList.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{
        TextView semisterName, semisterCredit;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            semisterName= itemView.findViewById(R.id.tv_semister_name);
            semisterCredit= itemView.findViewById(R.id.tv_semister_credit);
        }
    }

}
