package com.petapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Endereco {

    @JsonProperty("country")
    private String country;

    @JsonProperty("region")
    private String region;

    @JsonProperty("locality")
    private String city;

    @JsonProperty("neighbourhood")
    private String bairro;

    @JsonProperty("label")
    private String label;

    public Endereco() {}

    public Endereco(String country, String region, String city, String bairro, String label) {
        this.country = country;
        this.region = region;
        this.city = city;
        this.bairro = bairro;
        this.label = label;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}

