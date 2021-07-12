package com.power.doc.kubernetes.quarkus.exception;

/**
 * @author yu 2020/12/27.
 */
public class PersonNotFoundException extends RuntimeException {

    public PersonNotFoundException() {

    }

    public PersonNotFoundException(String message) {
        super(message);
    }

    public PersonNotFoundException(Long id) {
        super("Person not found on :: " + id);
    }
}
