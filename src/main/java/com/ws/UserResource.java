package com.ws;

import com.core.User;
import com.core.UserService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Jigar on 4/9/2016.
 */
@Path("users")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
    UserService userService = new UserService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsers() {
        return userService.getUsers();
    }


    @GET
    @Path("/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@PathParam("userId") int userId) {
        User userToAttach = userService.getUserById(userId);
        System.out.println(" "+userToAttach);
        return  userToAttach;
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public User createUser(User newUser) {
        return userService.createUser(newUser);
    }

    @DELETE
    @Path("/{userId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteUser(@PathParam("userId") int deletedId) {
        userService.deleteUser(deletedId);
    }

    @PUT
    @Path("/{userId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public User updateUser(User updatedUser) {
        return userService.updateUser(updatedUser);
    }


    @Produces(MediaType.APPLICATION_JSON)
    @Path("/search/{userId}")
    public User getUserById(@PathParam("userId") int foundUserID) {
        User userToAttach = userService.getUserById(foundUserID);
        System.out.println(" "+userToAttach);
        return  userToAttach;
    }
}
