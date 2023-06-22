package org.example.model;


import org.example.utilities.LocalDateAdapter;
import org.example.utilities.LocalDateTimeAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.io.Serializable;


@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class User implements Serializable {
    @XmlElement(name = "user_id")
    private int userId;
    @XmlElement
    private String username;
    @XmlElement
    private String email;
    @XmlElement
    private String password;
    @XmlElement(name= "first_name")
    private String firstName;
    @XmlElement(name="last_name")
    private String lastName;
    @XmlElement(name="date_of_birth")
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate dateOfBirth;
    @XmlElement(name="registration_date")
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    private LocalDateTime registrationDate;
    @XmlElement(name="last_login")
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    private LocalDateTime lastLogin;

    //Constructor
    //Constructors
    public User() {
        //Default constructor
    }
    public User(String username, String email, String password, String firstName,
                String lastName, LocalDate dateOfBirth, LocalDateTime registrationDate,
                LocalDateTime lastLogin) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.registrationDate = registrationDate;
        this.lastLogin = lastLogin;
    }

    public User(int userId, String username, String email, String password, String firstName,
                String lastName, LocalDate dateOfBirth, LocalDateTime registrationDate,
                LocalDateTime lastLogin) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.registrationDate = registrationDate;
        this.lastLogin = lastLogin;
    }

    //Getters and Setters

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername () {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }



    @Override
    public String toString() {
        return "User{" +
                "id=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
