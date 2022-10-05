package com.example.exercise2;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.ListFragment;

public class UserActivityFragment extends ListFragment {


    Class[] userActivityClass = new Class[] {
        AI_Activity.class,
        VR_Activity.class
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.user_activity_fragment, container, false);
        //ArrayAdapter creates a view for each array item
        // by calling toString() on each item and placing
        // the contents in a TextView.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.user_activities, android.R.layout.simple_list_item_1);

        //bind the list view with array adapter
        setListAdapter(adapter);

        return view;

    }
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Intent intent = new Intent(getActivity(), userActivityClass[position]);
        startActivity(intent);

    }
}
