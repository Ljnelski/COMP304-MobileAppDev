package com.example.liamnelski_comp304_lab2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class CheckoutActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private HouseCheckoutAdapter houseAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        recyclerView = findViewById(R.id.checkoutRecyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        houseAdapter = new HouseCheckoutAdapter(this, HouseDatabase.getHouseData(HouseType.TOWN_HOUSE));
        recyclerView.setAdapter(houseAdapter);
    }
}