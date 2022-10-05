package com.example.fragmentsexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.ListFragment;

public class ConceptsFragment extends ListFragment {
    //
    String[] concepts = new String[]
            {
                    "Android",
                    "ART",
                    "AVD",
                    "Intent",
                    "AOT",
                    "Emulator",
                    "Activity",
                    "Fragment",
                    "Life Cycle events" };
    //
    String[] definition = new String[]
            {"Open source software stack",
            "Android Runtime Environment",
            "Android Virtual Device",
            "An abstract description of an operation to be performed",
            "Ahead of Time compilation",
            "Simulates Android devices on your computer",
            "Application component that provides a screen",
            "A mini activity",
            "These methods are called when ....."};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.concepts_fragment, container, false);
        //ArrayAdapter creates a view for each array item
        // by calling toString() on each item and placing
        // the contents in a TextView.
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, concepts);
        //bind the list view with array adapter
        setListAdapter(adapter);

        return view;

    }
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        DefinitionFragment fragment = (DefinitionFragment)getFragmentManager().findFragmentById(R.id.definition_fragment);
        fragment.display(concepts[position],"Definition : "+definition[position]);
        getListView().setSelector(android.R.color.holo_blue_dark);
    }
}
