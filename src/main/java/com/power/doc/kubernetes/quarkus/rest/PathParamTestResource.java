package com.power.doc.kubernetes.quarkus.rest;

import com.power.doc.kubernetes.quarkus.model.MyResponse;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;

/**
 * JAX-RS path param example
 *
 * @author yu 2021/7/14.
 */
@Path("testPath")
public class PathParamTestResource {


    /**
     * Single Path Param
     *
     * @param id id
     */
    @GET
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public MyResponse<String> SinglePathParameter(@PathParam("id") String id) {
        String msg = "id=" + id;
        return MyResponse.ok().setData(msg);
    }

    /**
     * Multiple path parameters
     *
     * @param year  year
     * @param month month
     * @param day   day
     */
    @GET
    @Path("{year}/{month}/{day}")
    public MyResponse<String> multiplePathParameters(@PathParam("year") int year,
                                                     @PathParam("month") int month,
                                                     @PathParam("day") int day) {
        String msg = "year=" + year + " month=" + month + " day=" + day;
        return MyResponse.ok().setData(msg);
    }
}
