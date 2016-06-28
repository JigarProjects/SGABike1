package com.temp;

import com.temp.resource.Bike;
import com.temp.resource.BikeService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


/**
 * Created by Jigar on 4/9/2016.
 */
@Path("bike")
@Produces(MediaType.APPLICATION_JSON)
public class BikeResource {
    BikeService bs = new BikeService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Bike> getBikes() {
        return bs.getBikes();
    }


    @GET
    @Path("/{bikeId}")
    public Bike getBike(@PathParam("bikeId") int bikeId) {
        return bs.getBike(bikeId);
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Bike createBike(Bike newBike) {
        return bs.addBike(newBike);
    }

    @DELETE
    @Path("/{bikeId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteBike(@PathParam("bikeId") int deletedId) {
        bs.deleteBike(deletedId);
    }

    @PUT
    @Path("/{bikeId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Bike updateBike(Bike updatedBike) {
        return bs.updateBike(updatedBike);
    }

}
