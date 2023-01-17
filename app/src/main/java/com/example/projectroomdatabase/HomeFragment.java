package com.example.projectroomdatabase;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.projectroomdatabase.adapter.DataController;
import com.example.projectroomdatabase.adapter.HomeFragmentInterface;
import com.example.projectroomdatabase.adapter.HomeRecyclerAdapter;
import com.example.projectroomdatabase.repository.GradeRepository;
import com.example.projectroomdatabase.databinding.FragmentHomeBinding;
import com.example.projectroomdatabase.model.Semister;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import kotlin.collections.ArrayDeque;

public class HomeFragment extends Fragment implements HomeFragmentInterface {

    private FragmentHomeBinding binding;
    GradeRepository gradeRepository;
    HomeRecyclerAdapter adapter;
    List<Semister> semisterList= new ArrayList<>();
    DataController dataController;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);

        gradeRepository= new GradeRepository(getActivity().getApplication());

        binding.homeRecyclerview.setHasFixedSize(true);
        binding.homeRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        semisterList= gradeRepository.GetAllSemisters();
        adapter= new HomeRecyclerAdapter(semisterList);
        binding.homeRecyclerview.setAdapter(adapter);

        dataController= DataController.getInstance();
        dataController.setHomeFragmentInterface(this);


        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog= new Dialog(getActivity());
                dialog.setContentView(R.layout.custom_user_input_dialogue);
                EditText editText= dialog.findViewById(R.id.dialog_semister_name_edittext);
                Button button= dialog.findViewById(R.id.dialog_create_semister_button);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (editText.getText().toString().equals("")){
                            Toast.makeText(getActivity(), "insert a semister", Toast.LENGTH_SHORT).show();
                        }else {
                            String semisterName= editText.getText().toString().trim();
                            Toast.makeText(getActivity(), ""+semisterName, Toast.LENGTH_SHORT).show();
                            InsertSemister(semisterName);
                            dialog.dismiss();
                        }
                    }
                });
                dialog.show();
            }
        });
        return binding.getRoot();
    }

    public void InsertSemister(String semisterName){
        Semister semister= new Semister(semisterName, 0.00);
        semisterList.add(semister);
        adapter.notifyDataSetChanged();
        gradeRepository.InsertSemister(semister);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onSemisterItemClick(Semister semister) {
        Toast.makeText(getActivity(), ""+semister.getSemisterName(), Toast.LENGTH_SHORT).show();
    }
}