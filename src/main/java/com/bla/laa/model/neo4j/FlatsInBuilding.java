package com.bla.laa.model.neo4j;

import org.neo4j.ogm.annotation.*;

import static com.bla.laa.model.neo4j.FlatsInBuilding.FLATS_IN_BUILDING;


@RelationshipEntity(type = FLATS_IN_BUILDING )
public class FlatsInBuilding {

    public static final String FLATS_IN_BUILDING = "flats_in_building";

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @StartNode
    private Flat flat;

    @EndNode
    private Building building;

    public FlatsInBuilding(Flat f, Building b) {
        this.flat = f;
        this.building = b;
    }

    public Long getId() {
        return id;
    }

    public Flat getFlat() {
        return flat;
    }

    public void setFlat(Flat flat) {
        this.flat = flat;
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
        sb.append(", flat=" + flat.getName() );
        sb.append(", building=" + building.getName() );
        sb.append("}");
        return sb.toString();
    }
}
