package com.bla.laa.model.neo4j;

import org.neo4j.ogm.annotation.*;

import static com.bla.laa.model.neo4j.BuildingsInCounty.BUILDINGS_IN_COUNTY;
import static com.bla.laa.model.neo4j.BuildingsInVillage.BUILDINGS_IN_VILLAGE;


@RelationshipEntity(type = BUILDINGS_IN_COUNTY)
public class BuildingsInCounty {

    static final String  BUILDINGS_IN_COUNTY = "buildings_in_county";

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @StartNode
    private Building building;

    @EndNode
    private County county;

    public BuildingsInCounty(Building b, County c) {
        this.building = b;
        this.county = c;
    }

    public County getCounty() {
        return county;
    }

    public void setCounty(County county) {
        this.county = county;
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
        sb.append(", county=" + county.getName() );
        sb.append(", building=" + building.getName() );
        sb.append("}");
        return sb.toString();
    }
}
