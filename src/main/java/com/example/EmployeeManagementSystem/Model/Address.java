
package com.example.EmployeeManagementSystem.Model;

import jakarta.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressId;

    @Column
    private String street;

    @Column
    private String city;

    @Column
    private String state;

    @Column
    private int zip;

    // Constructors
    public Address() {}

    public Address(int addressId, String street, String city, String state, int zip) {
        this.addressId = addressId;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    // Getters and Setters
    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }
}
