package com.power.doc.kubernetes.quarkus.rest;

import com.power.doc.kubernetes.quarkus.model.CreateUserRequest;
import com.power.doc.kubernetes.quarkus.model.Person;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Valid Parameters
 * @author yu 2021/7/14.
 */
@Path("/valid/test")
public class ValidParametersTestResource {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Person create(@Valid CreateUserRequest request) {
        return null;
    }

    @GET
    @Path("/rest-end-point-generic-method-validation/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Integer testRestEndpointGenericMethodValidation(@Digits(integer = 5, fraction = 0) @PathParam("id") Integer id) {
        return id;
    }


    @GET
    @Path("/no-produces/{id}/")
    public Response noProduces(@Digits(integer = 5, fraction = 0) @PathParam("id") String id) {
        return Response.accepted().build();
    }

    @GET
    @Path("/test-validation-message-locale/{id}/")
    @Produces(MediaType.TEXT_PLAIN)
    public Response testValidationMessageLocale(
            @Pattern(regexp = "A.*", message = "{pattern.message}") @PathParam("id") String id) {
        return Response.accepted().build();
    }
}
