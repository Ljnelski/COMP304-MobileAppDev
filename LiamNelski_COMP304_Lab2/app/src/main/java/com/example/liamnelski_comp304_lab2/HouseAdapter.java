package com.example.liamnelski_comp304_lab2;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HouseAdapter extends RecyclerView.Adapter<HouseAdapter.HouseItemViewHolder> {
    private ArrayList<House> houses;
    private Context context;

    public static class HouseItemViewHolder extends RecyclerView.ViewHolder {

        public TextView houseTypeTextView;
        public TextView houseIdTextView;
        public ImageView houseImage;
        public CheckBox houseSavedCheckBox;

        public HouseItemViewHolder(@NonNull View itemView) {
            super(itemView);
            houseSavedCheckBox = itemView.findViewById(R.id.saveCheckBox);
            houseTypeTextView = itemView.findViewById(R.id.houseTypeTextView);
            houseIdTextView = itemView.findViewById(R.id.houseIdTextView);
            houseImage = itemView.findViewById(R.id.houseImageView);
        }
    }

    public HouseAdapter(Context context, ArrayList<House> houses) {
        this.context = context;
        this.houses = houses;
    }

    public void updateData(ArrayList<House> houses) {
        this.houses = houses;
    }

    @NonNull
    @Override
    public HouseItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_house_item, parent, false);

        HouseItemViewHolder viewHolder = new HouseItemViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HouseItemViewHolder viewHolder, int position) {
        SharedPreferences savedHouses = context.getSharedPreferences("savedHouses", Context.MODE_PRIVATE);
        SharedPreferences.Editor savedHousesEditor = savedHouses.edit();

        House currentHouse = houses.get(position);

        Log.i("HouseAdaptor-onBindViewHolder: ",
                "HouseId: " + currentHouse.id
                        + " Is Selected: " + savedHouses.getBoolean(Integer.toString(currentHouse.id), false));

        viewHolder.houseTypeTextView.setText(currentHouse.houseTypeAsString());
        viewHolder.houseTypeTextView.setText(currentHouse.houseTypeAsString());
        viewHolder.houseIdTextView.setText(Integer.toString(currentHouse.id));
        viewHolder.houseImage.setImageResource(currentHouse.houseImage);
        viewHolder.houseSavedCheckBox.setChecked(savedHouses.getBoolean(Integer.toString(currentHouse.id), false));

        viewHolder.houseSavedCheckBox.setOnCheckedChangeListener(null);
        viewHolder.houseSavedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                savedHousesEditor.putBoolean(Integer.toString(currentHouse.id), b);
                savedHousesEditor.apply();

                Log.i("HouseAdaptor-onBindViewHolder-onCheckChanged: ",
                        "CheckChanged Value: " + b
                                + " After Putting into Preferences houseId(" + currentHouse.id
                                + ") :" + savedHouses.getBoolean(Integer.toString(currentHouse.id), false));
            }
        });
    }

    @Override
    public int getItemCount() {
        return houses.size();
    }
}

//public class HouseAdapter extends BaseAdapter {
//
//    Context context;
//    ArrayList<House> houses;
//    LayoutInflater inflater;
//
//    public HouseAdapter(Context context, ArrayList<House> houses) {
//        this.context = context;
//        this.houses = houses;
//        inflater = LayoutInflater.from(context);
//    }
//
//    @Override
//    public int getCount() {
//        return houses.size();
//    }
//
//    @Override
//    public Object getItem(int i) {
//        return houses.get(i);
//    }
//
//    @Override
//    public long getItemId(int i) {
//        return 0;
//    }
//
//    @Override
//    public View getView(int i, View view, ViewGroup viewGroup) {
//        View convertView = inflater.inflate(R.layout.activity_house_item, null);
//
//        House currentHouse = houses.get(i);
//
//        SharedPreferences savedHouses = context.getSharedPreferences("savedHouses", Context.MODE_PRIVATE);
//        SharedPreferences.Editor savedHousesEdit = savedHouses.edit();
//
//
//        CheckBox savedCheckBox = convertView.findViewById(R.id.saveCheckBox);
//        TextView houseTypeTextView = convertView.findViewById(R.id.houseTypeTextView);
//        TextView houseIdTextView = convertView.findViewById(R.id.houseIdTextView);
//        ImageView houseImage = convertView.findViewById(R.id.houseImageView);
//
//        savedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                Toast.makeText(context.getApplicationContext(), "The house ID you just checked is " + currentHouse.id, Toast.LENGTH_SHORT).show();
//                savedHousesEdit.putBoolean(Integer.toString(currentHouse.id), b);
//                savedHousesEdit.apply();
//            }
//        });
//
//
//        savedCheckBox.setChecked(savedHouses.getBoolean(Integer.toString(i), false));
//        houseTypeTextView.setText(currentHouse.houseTypeAsString());
//        houseIdTextView.setText(Integer.toString(currentHouse.id));
////      houseImage.setImageResource(currentHouse.houseImage);
//
//        return convertView;
//    }
//}
