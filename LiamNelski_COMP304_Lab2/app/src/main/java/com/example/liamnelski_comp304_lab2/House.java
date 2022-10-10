package com.example.liamnelski_comp304_lab2;

public class House {


    public int id;
    public HouseType houseType;
    public int houseImage;

    private static int generatedId = 0;

    public House(HouseType houseType) {
        id = generatedId++;
        houseImage = R.drawable.house_logo;
        this.houseType = houseType;
    }

    public String houseTypeAsString() {
        switch (houseType) {
            case APARTMENT:
                return "Apartment";
            case TOWN_HOUSE:
                return "Town House";
            case CONDOMINIUM:
                return "Condominium";
            case DETACHED_HOME:
                return "Detached Home";
            case SEMI_DETACHED_HOME:
                return "Semi-Detached Home";
            default:
                return "Apartment";
        }
    }
}

