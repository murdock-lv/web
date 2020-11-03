package com.bla.laa.model.neo4j;

import org.neo4j.ogm.annotation.*;

import static com.bla.laa.model.neo4j.BuildingsInCity.BUILDINGS_IN_CITY;


@RelationshipEntity(type = BUILDINGS_IN_CITY)
public class BuildingsInCity {

    static final String  BUILDINGS_IN_CITY = "buildings_in_city";

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @StartNode
    private Building building;

    @EndNode
    private City city;

    public BuildingsInCity(Building b, City c) {
        this.building = b;
        this.city = c;

    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
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
        sb.append("BuildingsOnStreet{");
        sb.append("id=" + id  );
        sb.append(", name='" + name + '\'' );
        sb.append(", city=" + city.getName() );
        sb.append(", building=" + building.getName() );
        sb.append("}");
        return sb.toString();
    }
}
