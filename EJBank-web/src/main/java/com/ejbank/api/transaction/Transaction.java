package com.ejbank.api.transaction;


import com.ejbank.api.transaction.payload.*;
import com.ejbank.service.account.AccountServiceLocal;
import com.ejbank.service.user.UserServiceLocal;
import com.ejbank.test.TestBeanLocal;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;

@Path("/transaction")
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class Transaction {

    @EJB
    private TestBeanLocal testBean;

    @EJB
    private UserServiceLocal userService;

    @EJB
    private AccountServiceLocal accountService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/preview")
    public TransactionPreviewResponsePayload previewPostRequest(TransactionPreviewRequestPayload payload) {
        //do something with the Bean
        //result
        var previewDto = accountService.checkValidity(payload.getSource(), payload.getDestination(), payload.getAmount());
        return new TransactionPreviewResponsePayload(
                previewDto.result(),
                previewDto.accountSender(),
                previewDto.accountReceiver(),
                previewDto.message()
        );
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/apply")
    public TransactionApplyResponsePayload applyPostRequest(TransactionApplyRequestPayload payload) {
        //do something with the Bean
        //resul
        var transactionApply = accountService.applyTransaction(
                payload.getAuthor(),
                payload.getSource(),
                payload.getDestination(),
                payload.getAmount(),
                payload.getMessage());
        return new TransactionApplyResponsePayload(transactionApply.result(), transactionApply.message());
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/validation")
    public TransactionValidationResponsePayload validationPostRequest(TransactionValidationRequestPayload payload) {
        //do something with the Bean
        //result
        var result = new TransactionValidationResponsePayload(true,"Retour du serveur");
        return result;
    }



    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/validation/notification/{user_id}")
    public int GetAccounts(@PathParam("user_id") int id) {
        return userService.getNotificationCount(id);
    }



    @GET

    @Path("/{account_id}/{offset}/{user_id}")
    public int allTransactionFromUser(@PathParam("account_id") int account_id,@PathParam("offset") int offset ,@PathParam("user_id") int user_id) {
        //get information form Bean --
        //var result = Bean ----
        var result = new TransactionValidationResponsePayload(true,"Retour du serveur");
        return 3;
    }



}
