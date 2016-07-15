package com.core;

import com.SGALogger;
import com.db.BikeDAO;

import java.util.List;

/**
 * Created by Jigar on 4/9/2016.
 */
public class BikeService extends SGALogger {
    /*List<Bike> bikeList = new ArrayList<Bike>();*/

    public BikeService() {
        System.out.println("Bike Service class called");
    }

    public List<Bike> getBikes() {
        BikeDAO bikeDAO = new BikeDAO();
        return (List<Bike>) bikeDAO.listBike();
    }

    public Bike getBike(int id) {

        return (new Bike(0, "empty", "empty"));
    }


    public Bike addBike(Bike newBike) {

        BikeDAO bikeDAO = new BikeDAO();
        bikeDAO.createBike(newBike);
        return (new Bike(0, "empty", "empty"));
    }

    public Bike updateBike(Bike updatedBike) {

        BikeDAO bikeDAO = new BikeDAO();
        bikeDAO.updateBike(updatedBike);
        return (new Bike(0, "empty", "empty"));
    }

    public void deleteBike(int deleteBikeId) {
        System.out.println(deleteBikeId);
        BikeDAO bikeDAO = new BikeDAO();
        bikeDAO.deleteBike(deleteBikeId);
    }
}
