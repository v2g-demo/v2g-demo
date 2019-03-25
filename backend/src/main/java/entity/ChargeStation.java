package com.v2gdemo.googlemap.entity;

public class ChargeStation {
    private String name;
    private String location;
    private String descriprtion;

    public ChargeStation() {
    }

    public ChargeStation(String name, String location, String descriprtion) {
        this.name = name;
        this.location = location;
        this.descriprtion = descriprtion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescriprtion() {
        return descriprtion;
    }

    public void setDescriprtion(String descriprtion) {
        this.descriprtion = descriprtion;
    }
}
