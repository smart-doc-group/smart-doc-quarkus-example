package com.power.doc.kubernetes.quarkus.rest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

/**
 * JAX-RS header param example
 * @author yu 2021/7/14.
 */
@Path("/header")
public class HeaderParamTestResource {
    /**
     * Get user agent
     * @param userAgent
     */
    @GET
    @Path("agent")
    public Response testHeader(@HeaderParam("user-agent") String userAgent){
        return Response.status(200)
                .entity("userAgent : " + userAgent)
                .build();
    }

    /**
     * Custom header2
     * @param apiKey App Identifier
     * @return
     */
    @GET
    @Path("testHeader2")
    public Response testHeader2(@HeaderParam("authorization") String authHeader,@HeaderParam("apiKey") String apiKey){
        return Response.status(200)
                .entity("apiKey : " + apiKey)
                .build();
    }
}
