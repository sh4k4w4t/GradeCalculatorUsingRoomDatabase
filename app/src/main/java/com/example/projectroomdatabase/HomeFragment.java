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
import androidx.navigation.fragment.NavHostFragment;

import com.example.projectroomdatabase.databinding.FragmentHomeBinding;
import com.google.android.material.snackbar.Snackbar;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

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
                            dialog.dismiss();
                        }
                    }
                });
                dialog.show();
            }
        });

//        binding.buttonFirst.setOnClickListener(view1 -> NavHostFragment.findNavController(HomeFragment.this)
//                .navigate(R.id.action_HomeFragment_to_SecondFragment));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}