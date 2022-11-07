package com.example.roomexampleapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class AddUserFragment extends Fragment {

    private EditText userIdEditText, userNameEditText, userEmailEditText;
    private Button saveUserButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_user, container, false);

        userIdEditText = view.findViewById(R.id.userIdEditText);
        userNameEditText = view.findViewById(R.id.userNameEditText);
        userEmailEditText = view.findViewById(R.id.userEmailEditText);
        saveUserButton = view.findViewById(R.id.saveUserButton);

        saveUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int userId = Integer.parseInt(userIdEditText.getText().toString());
                String username = userNameEditText.getText().toString();
                String useremail = userEmailEditText.getText().toString();

                User newUser = new User();
                newUser.setId(userId);
                newUser.setName(username);
                newUser.setEmail(useremail);

                MainActivity.myAppDataBase.myDataAccessObject().addUser(newUser);

                Toast.makeText(getActivity(), "User is added successfully!", Toast.LENGTH_SHORT).show();

                userIdEditText.setText("");
                userNameEditText.setText("");
                userEmailEditText.setText("");
            }
        });

        return view;
    }
}