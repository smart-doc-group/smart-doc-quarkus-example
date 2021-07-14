package com.power.doc.kubernetes.quarkus.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * JAX-RS path param example
 * @author yu 2021/7/14.
 */
@Path("testPath")
public class PathParamTestResource {


    /**
     * Single Path Param
     * @param id id
     */
    @GET
    @Path("{id}")
    public void SinglePathParameter(@PathParam("id") String id){

    }

    /**
     * Multiple path parameters
     * @param year year
     * @param month month
     * @param day day
     */
    @GET
    @Path("{year}/{month}/{day}")
    public void multiplePathParameters(@PathParam("year") int year,
                                        @PathParam("month") int month,
                                        @PathParam("day") int day){

    }
}
