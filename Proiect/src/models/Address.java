package models;

import java.util.Objects;

public class Address {
    private static int idCounter = 0;
    private int id;
    protected String country;
    protected String city;
    protected String street;
    protected String number;
    protected String postalCode;

    public Address() {}
    public Address(String country, String city, String street, String number, String postalCode) {
        this.id = ++idCounter;
        this.country = country;
        this.city = city;
        this.street = street;
        this.number = number;
        this.postalCode = postalCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getpostalCode() {
        return postalCode;
    }

    public void setpostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "{" + "country=" + country + ", city=" + city + ", street=" + street + ", number=" + number + ", postalCode=" + postalCode + '}';
    }
}
