package com.power.doc.kubernetes.quarkus.rest;

import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import java.util.List;

/**
 * JAX-RS query param example
 * @author yu 2021/7/14.
 */
@Path("/queryParam")
public class QueryParamTestResource {

    /**
     * query param
     * @param from
     * @param to
     * @param orderBy
     * @return
     */
    @GET
    @Path("/query")
    public Response queryParam(
            @QueryParam("from") int from,
            @QueryParam("to") int to,
            @QueryParam("orderBy") List<String> orderBy) {

        return Response
                .status(200)
                .entity("from : " + from + ", to : " + to
                        + ", orderBy" + orderBy.toString()).build();

    }

    /**
     * Param with default value
     * @param from from
     * @param to to
     * @param orderBy orderBy
     * @return
     */
    @GET
    @Path("/query")
    public Response defaultValue(
            @DefaultValue("1000") @QueryParam("from") int from,
            @DefaultValue("999") @QueryParam("to") int to,
            @DefaultValue("name") @QueryParam("orderBy") List<String> orderBy) {

        return Response
                .status(200)
                .entity("from : " + from + ", to : " + to
                        + ", orderBy" + orderBy.toString()).build();

    }
}
