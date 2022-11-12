package com.example.roomexampleapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class ReadUserFragment extends Fragment {
    private TextView infoTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_read_user, container, false);
        infoTextView = view.findViewById(R.id.infoTextView);
        List<User> users = MainActivity.myAppDataBase.myDataAccessObject().getUsers();

        String info = "";

        for (User u : users) {
            int id = u.getId();
            String name = u.getName();
            String email = u.getEmail();

            info = "\n\n Id: " + id + "\nName: " + name + "\nEmail: " + email;
        }

        infoTextView.setText(info);
        return view;
    }
}