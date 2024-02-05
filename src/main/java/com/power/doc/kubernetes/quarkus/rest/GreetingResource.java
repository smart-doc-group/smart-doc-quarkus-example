package com.power.doc.kubernetes.quarkus.rest;

import com.power.doc.kubernetes.quarkus.service.GreetingService;
import org.jboss.logging.Logger;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;

/**
 * Greeting
 */
@Path("/hello")
public class GreetingResource {

    private static final Logger LOG = Logger.getLogger(GreetingResource.class);
    @Inject
    GreetingService service;



    /**
     * Test inject
     *
     * @param name name
     * @return
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/greeting/{name}")
    public String greeting(@PathParam("name") String name) {
        return service.greeting(name);
    }

    /**
     * Rest Easy
     * @return
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/restEasy")
    public String hello() {
        LOG.info("Hello RESTEasy");
        return "Hello RESTEasy";
    }
}