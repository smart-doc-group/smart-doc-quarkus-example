package com.power.doc.kubernetes.quarkus.rest;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
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
