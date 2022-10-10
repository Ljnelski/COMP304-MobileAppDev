package com.example.liamnelski_comp304_lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupMenu;

import java.util.ArrayList;

public class HouseTypesActivity extends AppCompatActivity {

    private HouseAdapter houseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house_types);

        Button chooseHouseTypeButton = findViewById(R.id.chooseHouseTypeButton);

        // > Set up Menu
        chooseHouseTypeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(HouseTypesActivity.this, chooseHouseTypeButton);
                MenuInflater houseChoiceInflater = popupMenu.getMenuInflater();
                houseChoiceInflater.inflate(R.menu.house_types, popupMenu.getMenu());
                popupMenu.show();

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.apartment:
                                updateHouseList(HouseType.APARTMENT);
                                break;
                            case R.id.townHouse:
                                updateHouseList(HouseType.TOWN_HOUSE);
                                break;
                            case R.id.condominiun:
                                updateHouseList(HouseType.CONDOMINIUM);
                                break;
                            case R.id.detached:
                                updateHouseList(HouseType.DETACHED_HOME);
                                break;
                            case R.id.semiDetached:
                                updateHouseList(HouseType.SEMI_DETACHED_HOME);
                                break;
                        }
                        return true;
                    }
                });
            }

        });
        // Set up listView
        ListView listView = findViewById(R.id.houseList);
        houseAdapter = new HouseAdapter(HouseTypesActivity.this, HouseDatabase.getHouseData(HouseType.NULL));
        listView.setAdapter(houseAdapter);
    }

    public void updateHouseList(HouseType targetHouse) {
        ArrayList<House> newHouses = HouseDatabase.getHouseData(targetHouse);

        houseAdapter.houses = newHouses;
        houseAdapter.notifyDataSetChanged();
    }
}