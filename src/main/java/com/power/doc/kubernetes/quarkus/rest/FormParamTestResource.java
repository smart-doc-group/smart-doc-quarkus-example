package com.power.doc.kubernetes.quarkus.rest;


import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

/**
 * JAX-RS Form param example
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
