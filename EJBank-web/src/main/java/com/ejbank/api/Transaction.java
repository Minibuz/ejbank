package com.ejbank.api;

import com.ejbank.api.payload.AccountInfoPayload;
import com.ejbank.api.payload.UserPayload;
import com.ejbank.api.payload.transaction.*;
import com.ejbank.api.payloadExample.PeoplePayload;
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

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/preview")
    public TransactionPreviewResponsePayload previewPostRequest(TransactionPreviewRequestPayload payload) {
        //do something with the Bean
        //result
        var result = new TransactionPreviewResponsePayload(true,new BigDecimal(350),new BigDecimal(320),"HELLO API");
        return result;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/apply")
    public TransactionApplyResponsePayload applyPostRequest(TransactionApplyRequestPayload payload) {
        //do something with the Bean
        //result
        var result = new TransactionApplyResponsePayload(true,"Apply is Working !!! NICE");
        return result;
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
        //get information form Bean --
        //var result = Bean ----
        return 3;
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