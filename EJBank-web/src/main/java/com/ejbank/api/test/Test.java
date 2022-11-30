package com.ejbank.api.test;

import com.ejbank.api.test.payload.PeoplePayload;
import com.ejbank.service.user.UserServiceLocal;
import com.ejbank.test.TestBeanLocal;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/test")
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class Test {

    @EJB
    private TestBeanLocal testBean;

    @EJB
    private UserServiceLocal userService;
    
    @GET
    @Path("/ejb")
    public String testEJB() {
        return "Work";
    }

    @GET
    @Path("/people/{age}")
    public PeoplePayload testPayloadResponse(@PathParam("age") Integer age) {
        return new PeoplePayload("Jean", "Dupont", age);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/post")
    public String testPostRequest(PeoplePayload payload) {
        return String.format("%s - %s", payload.getFirstname(), payload.getLastname());
    }
}
