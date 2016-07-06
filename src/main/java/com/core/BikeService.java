package com.core;

import com.SGALogger;
import com.db.BikeDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jigar on 4/9/2016.
 */
public class BikeService extends SGALogger{
    List<Bike> bikeList = new ArrayList<Bike>();

    public BikeService() {
        System.out.println("Bike Service class called");
    }

    public List<Bike> getBikes() {
        BikeDAO bikeDAO = new BikeDAO();
        return (List<Bike>) bikeDAO.listBike();
    }

    public Bike getBike(int id) {

        return (bikeList.get(id));
    }


    public Bike addBike(Bike newBike) {

        BikeDAO bikeDAO = new BikeDAO();
        bikeDAO.createBike(newBike);
        return bikeList.get(0);
    }

    public Bike updateBike(Bike updatedBike) {
        bikeList.add(updatedBike.getId(), updatedBike);
        return bikeList.get(updatedBike.getId());
    }

    public void deleteBike(int deleteBikeId) {
        System.out.println(deleteBikeId);
        /*System.out.println(bikeList.size());
        bikeList.remove(deleteBikeId);
        System.out.println(bikeList.size());*/
    }
}
