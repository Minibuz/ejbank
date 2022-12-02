package com.ejbank.api.accounts;



import com.ejbank.api.accounts.payload.*;
import com.ejbank.api.user.payload.UserPayload;
import com.ejbank.dto.AccountsWithUserDto;
import com.ejbank.service.user.UserServiceLocal;
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

    @EJB
    private UserServiceLocal userService;

    @GET
    @Path("/{user_id}")
    public AccountsPayload GetAccounts(@PathParam("user_id") Integer id) {
        var accountsDto = userService.getAccounts(id);
        // TODO : Clean builder for AccountsPayload from AccountsDto
        return new AccountsPayload(accountsDto.accounts()
                            .stream()
                            .map(accountDto ->
                                    new AccountPayload(accountDto.getId(),
                                            accountDto.getType(),
                                            accountDto.getAmount()))
                            .toList());
        // TODO : Add error to payload
    }

    @GET
    @Path("/all/{user_id}")
    public AccountsWithUserPayload GetAllAccounts(@PathParam("user_id") Integer id) {
        //get information form Bean User
        //var result = AccountsBean.findAll(id);
        // TODO : Clean builder for AccountsWithUserPayload from AccountsDto
        // Look if we need first and last or just first ?
        var accountsWithUser = userService.getAccountsWithUser(id);
        return new AccountsWithUserPayload(accountsWithUser.accounts()
                            .stream()
                            .map(accountWithUser ->
                                    new AccountWithUserPayload(
                                            new AccountPayload(
                                                    accountWithUser.getId(),
                                                    accountWithUser.getType(),
                                                    accountWithUser.getAmount()
                                            ),
                                            new UserPayload(accountWithUser.getFirstName(), "")
                                    )).toList());
        // TODO : Add error to payload
    }

    @GET
    @Path("/attached/{user_id}")
    public AccountsAttachedPayload GetAttachedAccounts(@PathParam("user_id") Long id) {
        //get information form Bean User
        //var result = AccountsBean.findAll(id);
        var user = new UserPayload("Max","Dum");
        var test = new AccountPayload(1_524, "courant",new BigDecimal(350));
        var test2 = new AccountPayload(1_784,"Livret A",new BigDecimal(-1352));
        var account1 = new AccountAttachedPayload(new AccountWithUserPayload(test,user),0);
        var account2 = new AccountAttachedPayload(new AccountWithUserPayload(test2,user),2);
        var result = new AccountsAttachedPayload(List.of(account1,account2));
        return result;
    }

}
