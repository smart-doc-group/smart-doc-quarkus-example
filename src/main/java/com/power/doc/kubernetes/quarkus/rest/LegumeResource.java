package com.power.doc.kubernetes.quarkus.rest;

import com.power.doc.kubernetes.quarkus.model.Legume;
import com.power.doc.kubernetes.quarkus.model.MyResponse;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * LegumeResource
 * @author yu 2021/7/13.
 */
@Path("/legumes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LegumeResource {

    private Set<Legume> legumes = Collections.synchronizedSet(new LinkedHashSet<>());

    public LegumeResource() {
        legumes.add(new Legume("Carrot", "Root vegetable, usually orange"));
        legumes.add(new Legume("Zucchini", "Summer squash"));
    }

    /**
     * List of LegumeResource
     * @return
     */
    @GET
    public MyResponse<Set<Legume>> list() {
        return MyResponse.ok(legumes);
    }
}
