package com.power.doc.kubernetes.quarkus.model;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * @author yu 2021/7/14.
 */
public class CreateUserRequest {

    @Email
    @NotBlank(message = "email may not be blank")
    private String email;

    @Size(min = 4, max = 15, message = "username should have size [{min},{max}]")
    @NotBlank(message = "username may not be blank")
    @Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9]+$", message = "\"username\" should start with a letter and should only accept letters and numbers")
    private String username;

    @NotBlank(message = "firstName may not be blank")
    private String firstName;

    @NotBlank(message = "lastName may not be blank")
    private String lastName;

    private boolean admin;

    @NotBlank(message = "hashedPassword may not be blank")
    private String hashedPassword;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }
}
