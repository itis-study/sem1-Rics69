package org.example.model;

import java.util.UUID;

public class UserPlatform {
    private UUID userId;
    private String login;
    private String firstName;
    private String lastName;
    private String password;
    private String userType;

    public UserPlatform(){}

    public UserPlatform(UUID userId, String login, String firstName, String lastName, String password, String userType) {
        this.userId = userId;
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.userType = userType;
    }


    public UUID getUserId() {
        return userId;
    }

    public String getLogin() {
        return login;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
