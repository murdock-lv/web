package com.bla.laa.model.neo4j;

import org.neo4j.ogm.annotation.*;

import static com.bla.laa.model.neo4j.BuildingsInCity.BUILDINGS_IN_CITY;
import static com.bla.laa.model.neo4j.BuildingsInParish.BUILDINGS_IN_PARISH;


@RelationshipEntity(type = BUILDINGS_IN_PARISH)
public class BuildingsInParish {

    static final String  BUILDINGS_IN_PARISH = "buildings_in_parish";

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @StartNode
    private Building building;

    @EndNode
    private Parish parish;

    public BuildingsInParish(Building b, Parish p) {
        this.building = b;
        this.parish = p;

    }

    public Parish getParish() {
        return parish;
    }

    public void setParish(Parish parish) {
        this.parish = parish;
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
        sb.append("BuildingsInParish{");
        sb.append("id=" + id  );
        sb.append(", name='" + name + '\'' );
        sb.append(", parish=" + parish.getName() );
        sb.append(", building=" + building.getName() );
        sb.append("}");
        return sb.toString();
    }
}
