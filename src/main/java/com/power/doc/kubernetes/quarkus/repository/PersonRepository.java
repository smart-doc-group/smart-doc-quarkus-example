package com.power.doc.kubernetes.quarkus.repository;

import com.power.doc.kubernetes.quarkus.model.Legume;
import com.power.doc.kubernetes.quarkus.model.Person;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @author yu 2021/7/13.
 */
@ApplicationScoped
public class PersonRepository {

    private static Map<Long, Person> persons = new ConcurrentHashMap<>();

    static {
        Person person = new Person();
        person.setEmail("xx@gmail.com");
        person.setFirstName("Carrot");
        person.setLastName("Zucchini");
        person.setId(1);
        persons.put(person.getId(), person);
    }


    public Optional<Person> findById(long id) {
        return Optional.ofNullable(persons.get(id));
    }

    public void add(Person person) {
        persons.put(person.getId(), person);
    }

    public List<Person> findAll() {
        return persons.values().stream().collect(Collectors.toList());
    }

    public boolean delete(Person person) {
        return persons.remove(person.getId(),person);
    }
}
