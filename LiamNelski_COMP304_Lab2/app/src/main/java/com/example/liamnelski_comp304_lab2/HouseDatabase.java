package com.example.liamnelski_comp304_lab2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HouseDatabase {
    private static House[] houses = {
            new House(HouseType.TOWN_HOUSE),
            new House(HouseType.TOWN_HOUSE),
            new House(HouseType.TOWN_HOUSE),
            new House(HouseType.TOWN_HOUSE),
            new House(HouseType.APARTMENT),
            new House(HouseType.APARTMENT),
            new House(HouseType.APARTMENT),
            new House(HouseType.APARTMENT),
            new House(HouseType.APARTMENT),
            new House(HouseType.DETACHED_HOME),
            new House(HouseType.DETACHED_HOME),
            new House(HouseType.DETACHED_HOME),
            new House(HouseType.DETACHED_HOME),
            new House(HouseType.DETACHED_HOME),
            new House(HouseType.DETACHED_HOME),
            new House(HouseType.DETACHED_HOME),
            new House(HouseType.DETACHED_HOME),
            new House(HouseType.DETACHED_HOME),
            new House(HouseType.DETACHED_HOME),
            new House(HouseType.CONDOMINIUM),
            new House(HouseType.CONDOMINIUM),
            new House(HouseType.SEMI_DETACHED_HOME),
            new House(HouseType.SEMI_DETACHED_HOME),
            new House(HouseType.SEMI_DETACHED_HOME),
            new House(HouseType.SEMI_DETACHED_HOME),
    };

    static ArrayList<House> getHouseData() {
        return new ArrayList(Arrays.asList(houses));
    }

    static ArrayList<House> getHouseData(HouseType targetType) {
        ArrayList<House> filteredHouses = new ArrayList();
        for (House house : houses) {
            if(house.houseType == targetType) {
                filteredHouses.add(house);
            }
        }
        return filteredHouses;
    }
}
