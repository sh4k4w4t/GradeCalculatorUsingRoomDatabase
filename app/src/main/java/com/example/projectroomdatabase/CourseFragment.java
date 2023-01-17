package com.example.projectroomdatabase;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectroomdatabase.adapter.course.CourseRecycleViewAdapter;
import com.example.projectroomdatabase.adapter.home.DataController;
import com.example.projectroomdatabase.databinding.FragmentCourseBinding;
import com.example.projectroomdatabase.model.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseFragment extends Fragment {

    private FragmentCourseBinding binding;
    DataController dataController;

    EditText creditEditText,gpaEditText;
    TextView calculateDataTextView;
    Button saveButton;
    RecyclerView courseRecyclerview;
    CourseRecycleViewAdapter adapter;

    double totalCredit=0;
    double productOfGPAandCredit=0;
    List<Course> allCourses= new ArrayList<>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentCourseBinding.inflate(inflater, container, false);

        dataController= DataController.getInstance();
        Toast.makeText(getActivity(), "Semister: "+dataController.getCurrentSemister().getSemisterName(), Toast.LENGTH_SHORT).show();

        saveButton= binding.button;
        calculateDataTextView = binding.textView3;
        gpaEditText = binding.editTextTextPersonName2;
        creditEditText = binding.editTextTextPersonName;
        courseRecyclerview= binding.courseRecyclerview;

        courseRecyclerview.setHasFixedSize(true);
        courseRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter= new CourseRecycleViewAdapter(allCourses);
        courseRecyclerview.setAdapter(adapter);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (creditEditText.getText().toString().trim().equals("") || gpaEditText.getText().toString().trim().equals("")) {
                    Toast.makeText(getActivity(), "Fillup all in here..", Toast.LENGTH_SHORT).show();
                }
                else {
                    CalculateCGPA(creditEditText.getText().toString().trim(), gpaEditText.getText().toString().trim());
                }
            }
        });

//        binding.buttonSecond.setOnClickListener(view1 -> {
//            NavHostFragment.findNavController(CalculationFragment.this)
//                    .navigate(R.id.action_SecondFragment_to_FirstFragment);
//        });


        return binding.getRoot();
    }

    private void CalculateCGPA(String credit, String gpa){
        double gpaValue= Double.parseDouble(gpa);
        double creditValue= Double.parseDouble(credit);

        productOfGPAandCredit +=(gpaValue+creditValue);
        totalCredit+=creditValue;
        double cgpa= productOfGPAandCredit/totalCredit;
        calculateDataTextView.setText(String.format("CGPA: %.2f",cgpa));

        Course course= new Course(gpaValue,creditValue,dataController.getCurrentSemister().getId());
        allCourses.add(course);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}