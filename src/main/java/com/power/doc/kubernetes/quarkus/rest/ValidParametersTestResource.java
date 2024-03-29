package com.power.doc.kubernetes.quarkus.rest;

import com.power.doc.kubernetes.quarkus.model.CreateUserRequest;
import com.power.doc.kubernetes.quarkus.model.Person;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Pattern;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * Valid Parameters
 * @author yu 2021/7/14.
 */
@Path("/valid/test")
public class ValidParametersTestResource {

    /**
     * Restful create
     * @param request
     * @return
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Person create(@Valid CreateUserRequest request) {
        return null;
    }

    /**
     * valid param in query
     * @param id id
     * @return
     */
    @GET
    @Path("/rest-end-point-generic-method-validation/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Integer testRestEndpointGenericMethodValidation(@Digits(integer = 5, fraction = 0) @PathParam("id") Integer id) {
        return id;
    }


    /**
     * valid
     * @param id id
     * @return
     */
    @GET
    @Path("/no-produces/{id}/")
    public Response noProduces(@Digits(integer = 5, fraction = 0) @PathParam("id") String id) {
        return Response.accepted().build();
    }

    /**
     * validation message locale
     * @param id id
     * @return
     */
    @GET
    @Path("/test-validation-message-locale/{id}/")
    @Produces(MediaType.TEXT_PLAIN)
    public Response testValidationMessageLocale(
            @Pattern(regexp = "A.*", message = "{pattern.message}") @PathParam("id") String id) {
        return Response.accepted().build();
    }
}
