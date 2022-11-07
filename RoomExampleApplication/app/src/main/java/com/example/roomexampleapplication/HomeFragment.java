package com.example.roomexampleapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    private Button addButton;
    private Button readButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        addButton = view.findViewById(R.id.addUserButton);
        addButton.setOnClickListener(this);

        readButton = view.findViewById(R.id.viewUserButton);
        readButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.addUserButton:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragmentContainer, new AddUserFragment()).addToBackStack(null).commit();
                break;
            case R.id.viewUserButton:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragmentContainer, new ReadUserFragment()).addToBackStack(null).commit();
        }
    }

}