package com.bla.laa.model.neo4j;

import org.neo4j.ogm.annotation.*;

import static com.bla.laa.model.neo4j.BuildingsOnStreet.BUILDINGS_ON_STREET;


@RelationshipEntity(type = BUILDINGS_ON_STREET)
public class BuildingsOnStreet {

    static final String  BUILDINGS_ON_STREET = "buildings_on_street";

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @EndNode
    private Street street;

    @StartNode
    private Building building;

    public BuildingsOnStreet(Building b, Street s) {
        this.building = b;
        this.street = s;
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
        sb.append(", street=" + street.getName() );
        sb.append(", building=" + building.getName() );
        sb.append("}");
        return sb.toString();
    }
}
