package com.ejbank.api.accounts;

import com.ejbank.api.accounts.payload.*;
import com.ejbank.service.user.UserServiceLocal;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/accounts")
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class Accounts {

    @EJB
    private UserServiceLocal userService;

    @GET
    @Path("/{user_id}")
    public AccountsPayload GetAccounts(@PathParam("user_id") Integer id) {
        var accountsDto = userService.getAccounts(id);
        return AccountsPayload.AccountsFromDTO(accountsDto.accounts(), accountsDto.error());
    }

    @GET
    @Path("/all/{user_id}")
    public AccountsWithUserPayload GetAllAccounts(@PathParam("user_id") Integer id) {
        var accountsWithUser = userService.getAccountsWithUser(id);
        return AccountsWithUserPayload.AccountsWithUserFromDTO(accountsWithUser.accounts(),accountsWithUser.error());
    }

    @GET
    @Path("/attached/{user_id}")
    public AccountsAttachedPayload GetAttachedAccounts(@PathParam("user_id") Integer id) {
        var accountsWithInfo = userService.getAccountsAttached(id);
        return AccountsAttachedPayload.AccountsFromDTO(accountsWithInfo.accounts(),accountsWithInfo.error());
    }

}
