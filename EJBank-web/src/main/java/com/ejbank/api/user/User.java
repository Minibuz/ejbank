package com.ejbank.api.user;


import com.ejbank.api.user.payload.UserPayload;
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
    private TestBeanLocal testBean;

    @GET
    @Path("/{user_id}")
    public UserPayload UserPayloadReponse(@PathParam("user_id") Long id) {
        //get information form Bean User
        //var result = UserBean.find(id)
        var result = new UserPayload("Jean", "Dupont");
        return result;
    }

}
