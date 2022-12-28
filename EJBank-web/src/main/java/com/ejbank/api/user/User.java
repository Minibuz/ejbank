package com.ejbank.api.user;


import com.ejbank.api.user.payload.UserPayload;
import com.ejbank.service.user.UserServiceLocal;
import com.ejbank.test.TestBeanLocal;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class User {

    @EJB
    private UserServiceLocal userService;

    @GET
    @Path("/{user_id}")
    public UserPayload UserPayloadReponse(@PathParam("user_id") Integer id) {
        var userInfo = userService.getUser(id);
        return new UserPayload(userInfo.getFirstName(), userInfo.getLastName());
    }

}
