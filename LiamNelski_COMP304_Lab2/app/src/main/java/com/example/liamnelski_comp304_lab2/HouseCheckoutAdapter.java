package com.example.liamnelski_comp304_lab2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HouseCheckoutAdapter extends RecyclerView.Adapter<HouseCheckoutAdapter.HouseItemCheckoutViewHolder> {
    private ArrayList<House> houses;
    private Context context;

    public static class HouseItemCheckoutViewHolder extends RecyclerView.ViewHolder {

        public TextView houseTypeTextView;
        public ImageView houseImage;
        public RadioButton houseRadioButton;

        public HouseItemCheckoutViewHolder(@NonNull View itemView) {
            super(itemView);
            houseRadioButton = itemView.findViewById(R.id.selectRadioButton);
            houseTypeTextView = itemView.findViewById(R.id.houseTypeCheckoutTextView);
            houseImage = itemView.findViewById(R.id.houseCheckoutImageView);
        }
    }

    public HouseCheckoutAdapter(Context context, ArrayList<House> houses) {
        this.context = context;
        this.houses = houses;
    }

    public void updateData(ArrayList<House> houses) {
        this.houses = houses;
    }

    @NonNull
    @Override
    public HouseItemCheckoutViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.house_checkout_item, parent, false);

        HouseItemCheckoutViewHolder viewHolder = new HouseItemCheckoutViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HouseItemCheckoutViewHolder viewHolder, int position) {
        SharedPreferences savedHouses = context.getSharedPreferences("savedHouses", Context.MODE_PRIVATE);
        SharedPreferences.Editor savedHousesEditor = savedHouses.edit();

        House currentHouse = houses.get(position);

        viewHolder.houseTypeTextView.setText(currentHouse.houseTypeAsString());
        viewHolder.houseImage.setImageResource(currentHouse.houseImage);

        viewHolder.houseRadioButton.setOnCheckedChangeListener(null);
        viewHolder.houseRadioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Intent intent  = new Intent(context, PayActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return houses.size();
    }
}