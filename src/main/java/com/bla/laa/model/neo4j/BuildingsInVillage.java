package com.bla.laa.model.neo4j;

import org.neo4j.ogm.annotation.*;

import static com.bla.laa.model.neo4j.BuildingsInCity.BUILDINGS_IN_CITY;
import static com.bla.laa.model.neo4j.BuildingsInVillage.BUILDINGS_IN_VILLAGE;


@RelationshipEntity(type = BUILDINGS_IN_VILLAGE)
public class BuildingsInVillage {

    static final String  BUILDINGS_IN_VILLAGE = "buildings_in_village";

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @StartNode
    private Building building;

    @EndNode
    private Village village;

    public BuildingsInVillage(Building b, Village v) {
        this.building = b;
        this.village = v;
    }

    public Village getVillage() {
        return village;
    }

    public void setVillage(Village village) {
        this.village = village;
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
        sb.append(", village=" + village.getName() );
        sb.append(", building=" + building.getName() );
        sb.append("}");
        return sb.toString();
    }
}
