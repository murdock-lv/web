package com.bla.laa.model.neo4j;

import org.neo4j.ogm.annotation.*;


@RelationshipEntity(type = StreetsInCity.STREETS_IN_CITY)
public class StreetsInCity {

    static final String  STREETS_IN_CITY = "streets_in_city";

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @EndNode
    private City city;

    @StartNode
    private Street street;

    public StreetsInCity(Street s, City c) {
        this.street = s;
        this.city= c;
    }

    public Long getId() {
        return id;
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }


    public com.bla.laa.model.neo4j.City getCity() {
        return city;
    }

    public void setCity(com.bla.laa.model.neo4j.City city) {
        city = city;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("StreetsInCity{");
        sb.append("id=" + id  );
        sb.append(", name='" + name + '\'' );
        sb.append(", street=" + street.getName() );
        sb.append(", city=" + city.getName() );
        sb.append("}");
        return sb.toString();
    }
}
