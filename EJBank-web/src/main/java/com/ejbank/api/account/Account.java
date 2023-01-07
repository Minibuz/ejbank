package com.ejbank.api.account;


import com.ejbank.api.account.payload.AccountInfoPayload;
import com.ejbank.api.user.payload.UserPayload;
import com.ejbank.service.account.AccountServiceLocal;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/account")
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class Account {

    @EJB
    private AccountServiceLocal userService;

    @GET
    @Path("/{account_id}/{user_id}")
    public AccountInfoPayload GetAccounts(@PathParam("account_id") int account_id, @PathParam("user_id") int user_id) {
        var accountDetailDto = userService.accountDetail(account_id, user_id);
        if(accountDetailDto.getError()!=null){
            return new AccountInfoPayload(null, null, accountDetailDto.getRate(), accountDetailDto.getInterest(), accountDetailDto.getAmount(),accountDetailDto.getError());
        }
        var owner = new UserPayload(accountDetailDto.getOwner().getFirstname(), accountDetailDto.getOwner().getLastname());
        var adviser = new UserPayload(accountDetailDto.getAdvisor().getFirstname(), accountDetailDto.getAdvisor().getLastname());

        return new AccountInfoPayload(owner, adviser, accountDetailDto.getRate(), accountDetailDto.getInterest(), accountDetailDto.getAmount(),accountDetailDto.getError());
    }
}
