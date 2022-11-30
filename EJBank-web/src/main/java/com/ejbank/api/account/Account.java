package com.ejbank.api.account;


import com.ejbank.api.account.payload.AccountInfoPayload;
import com.ejbank.api.user.payload.UserPayload;
import com.ejbank.test.TestBeanLocal;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;

@Path("/account")
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class Account {

    @EJB
    private TestBeanLocal testBean;

    @GET
    @Path("/{account_id}/{user_id}")
    public AccountInfoPayload GetAccounts(@PathParam("account_id") int account_id, @PathParam("user_id") int user_id) {
        //get information form Bean --
        //var result = Bean ----
        var owner = new UserPayload("Max", "Dum");
        var adviser = new UserPayload("Rem", "For");
        var result = new AccountInfoPayload(owner, adviser, new BigDecimal(15), new BigDecimal(56), new BigDecimal(350));
        return result;
    }
}
