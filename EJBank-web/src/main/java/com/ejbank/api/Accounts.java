package com.ejbank.api;

import com.ejbank.api.payload.*;
import com.ejbank.test.TestBeanLocal;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;
import java.util.List;

@Path("/accounts")
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class Accounts {

    @EJB
    private TestBeanLocal testBean;

    @GET
    @Path("/{user_id}")
    public AccountsPayload GetAccounts(@PathParam("user_id") Long id) {
        //get information form Bean User
        //var result = AccountsBean.findAll(id);
        var test = new AccountPayload(1_524L, "courant",new BigDecimal(350));
        var test2 = new AccountPayload(1_784L,"Livret A",new BigDecimal(-1352));
        var result = new AccountsPayload(List.of(test,test2));
        return result;
    }

    @GET
    @Path("/attached/{user_id}")
    public AccountsWithUserPayload GetAttachedAccounts(@PathParam("user_id") Long id) {
        //get information form Bean User
        //var result = AccountsBean.findAll(id);
        var user = new UserPayload("Max","Dum");
        var test = new AccountPayload(1_524L, "courant",new BigDecimal(350));
        var test2 = new AccountPayload(1_784L,"Livret A",new BigDecimal(-1352));
        var account1 = new AccountWithUserPayload(test,user);
        var account2 = new AccountWithUserPayload(test2,user);
        var result = new AccountsWithUserPayload(List.of(account1,account2));
        return result;
    }

}
