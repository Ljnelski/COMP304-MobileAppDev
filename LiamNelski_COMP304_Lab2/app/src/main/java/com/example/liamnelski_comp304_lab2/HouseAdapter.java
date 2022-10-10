package com.example.liamnelski_comp304_lab2;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class HouseAdapter extends BaseAdapter {

    Context context;
    ArrayList<House> houses;
    LayoutInflater inflater;

    public HouseAdapter(Context context, ArrayList<House> houses) {
        this.context = context;
        this.houses = houses;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return houses.size();
    }

    @Override
    public Object getItem(int i) {
        return houses.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View convertView = inflater.inflate(R.layout.activity_house_item, null);

        House currentHouse = houses.get(i);

        SharedPreferences savedHouses = context.getSharedPreferences("savedHouses", Context.MODE_PRIVATE);
        SharedPreferences.Editor savedHousesEdit = savedHouses.edit();


        CheckBox savedCheckBox = convertView.findViewById(R.id.saveCheckBox);
        TextView houseTypeTextView = convertView.findViewById(R.id.houseTypeTextView);
        ImageView houseImage = convertView.findViewById(R.id.houseImageView);

        savedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(context.getApplicationContext(), "The house ID you just checked is " + currentHouse.id, Toast.LENGTH_SHORT).show();
                savedHousesEdit.putBoolean(Integer.toString(currentHouse.id), b);
                savedHousesEdit.apply();
            }
        });


        savedCheckBox.setChecked(savedHouses.getBoolean(Integer.toString(i), false));
        houseTypeTextView.setText(currentHouse.houseTypeAsString());
        houseImage.setImageResource(currentHouse.houseImage);

        return convertView;
    }
}
