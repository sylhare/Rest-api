package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * model.Address class corresponds to the inner object in the root json data.
 * Created by sylhare in 2017.
 */
//@JsonIgnoreProperties({ "id"})
public class Address {

    private int id;
    private String street;
    private String city;
    private int zipcode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public String toString() {
        return getId() + ": " + getStreet() + ", " + getCity() + ", " + getZipcode();
    }
}