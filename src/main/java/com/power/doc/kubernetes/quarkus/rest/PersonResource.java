package com.power.doc.kubernetes.quarkus.rest;

import com.power.doc.kubernetes.quarkus.exception.PersonNotFoundException;
import com.power.doc.kubernetes.quarkus.model.MyResponse;
import com.power.doc.kubernetes.quarkus.model.Person;
import com.power.doc.kubernetes.quarkus.repository.PersonRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * The type person controller.
 *
 * @author yu 2021/7/13.
 */
@Path("/people")
@Produces(MediaType.APPLICATION_JSON)
public class PersonResource {

    @Inject
    private PersonRepository personRepository;


    /**
     * Get all persons list.
     *
     * @return the list
     */
    @GET
    public List<Person> all() {
        return personRepository.findAll();
    }

    /**
     * Gets persons by id.
     *
     * @param id the person id|1
     * @return the persons by id
     */
    @GET
    @Path("/{id}")
    public Person get(@PathParam("id") Long id) {
        Person person = personRepository.findById(id).
                orElseThrow(() -> new PersonNotFoundException(id));
        return person;
    }

    /**
     * Create person.
     *
     * @param person the person
     * @return the person
     */
    @POST
    @Path("save")
    public Person post(Person person) {
        personRepository.add(person);
        return person;
    }

    /**
     * Update person response entity.
     *
     * @param id            the person id|1
     * @param personDetails the person details
     * @return the response entity
     */
    @PUT
    @Path("/{id}")
    public MyResponse<Person> put(Person personDetails) {
        Person person = personRepository.findById(personDetails.getId()).
                orElseThrow(() -> new PersonNotFoundException(personDetails.getId()));
        person.setEmail(personDetails.getEmail());
        person.setLastName(personDetails.getLastName());
        person.setFirstName(personDetails.getFirstName());
        personRepository.add(person);
        return MyResponse.ok(person);
    }

    /**
     * Delete person.
     *
     * @param id the person id|1
     * @return the map
     */
    @DELETE
    @Path("/{id}")
    public MyResponse delete(@PathParam("id") Long id) {
        Person person = personRepository.findById(id).
                orElseThrow(() -> new PersonNotFoundException(id));
        personRepository.delete(person);
        return MyResponse.ok();
    }
}