package com.temp.resource;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jigar on 4/9/2016.
 */
public class BikeService {
    List<Bike> bikeList = new ArrayList<Bike>();

    public BikeService() {

        bikeList.add(0, new Bike(0, "jigar's 0 bike ", "No defects"));
        bikeList.add(1, new Bike(1, "jigar's 1 bike ", "No defects"));
        bikeList.add(2, new Bike(2, "jigar's 2 bike ", "No defects"));
        System.out.println("Bike Service class called");
    }

    public List<Bike> getBikes() {
        return bikeList;
    }

    public Bike getBike(int id) {

        return (bikeList.get(id));
    }


    public Bike addBike(Bike newBike) {
        int newSize = bikeList.size();
        newBike.setId(newSize);
        System.out.println(newSize);
        bikeList.add(newSize, newBike);
        return bikeList.get(newSize);
    }

    public Bike updateBike(Bike updatedBike) {
        bikeList.add(updatedBike.getId(), updatedBike);
        return bikeList.get(updatedBike.getId());
    }

    public void deleteBike(int deleteBikeId) {
        System.out.println(bikeList.size());
        bikeList.remove(deleteBikeId);
        System.out.println(bikeList.size());
    }
}
