package com.ws;

import com.core.Bike;
import com.core.BikeService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
    public Response getBikes() {
        List<Bike> bikes = bs.getBikes();
        return Response.ok().entity(bikes).build();
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
