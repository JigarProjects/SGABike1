package com.temp.resource;

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

        bikeList.add(0, new Bike(0, "jigar's 0 bike ", "No defects"));
        bikeList.add(1, new Bike(1, "jigar's 1 bike ", "No defects"));
        bikeList.add(2, new Bike(2, "jigar's 2 bike ", "No defects"));
        _log.debug("test");
        System.out.println("Bike Service class called");
    }

    public List<Bike> getBikes() {

        _log.debug("test");
        return bikeList;
    }

    public Bike getBike(int id) {

        return (bikeList.get(id));
    }


    public Bike addBike(Bike newBike) {

        BikeDAO bikeDAO = new BikeDAO();
        System.out.println("get hold of bikeDAO");
        bikeDAO.createBike(newBike);
        /*int newSize = bikeList.size();
        newBike.setId(newSize);
        System.out.println(newSize);
        bikeList.add(newSize, newBike);*/
        return bikeList.get(0);
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
