package com.power.doc.kubernetes.quarkus.rest;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.concurrent.CompletionStage;

/**
 * JAX-RS form param example
 * @author yu 2021/7/14.
 */
@Path("/formParam")
public class FormParamTestResource {

    /**
     * Bind form param
     * @param name name
     * @param age age
     * @return
     */
    @POST
    @Path("/add")
    public Response addUser(
            @FormParam("name") String name,
            @FormParam("age") int age) {
        return Response.status(200)
                .entity("name : " + name + ", age : " + age)
                .build();

    }
}
