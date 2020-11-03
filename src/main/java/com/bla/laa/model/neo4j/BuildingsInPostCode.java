package com.bla.laa.model.neo4j;

import org.neo4j.ogm.annotation.*;

import static com.bla.laa.model.neo4j.BuildingsInCity.BUILDINGS_IN_CITY;
import static com.bla.laa.model.neo4j.BuildingsInPostCode.BUILDINGS_IN_POSTCODE;


@RelationshipEntity(type = BUILDINGS_IN_POSTCODE)
public class BuildingsInPostCode {

    static final String  BUILDINGS_IN_POSTCODE = "buildings_in_postcode";

    @Id
    @GeneratedValue
    private Long id;

    @StartNode
    private Building building;

    @EndNode
    private PostCode postCode;

    public BuildingsInPostCode(Building b, PostCode pc) {
        this.building = b;
        this.postCode = pc;
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

    public PostCode getPostCode() {
        return postCode;
    }

    public void setPostCode(PostCode postCode) {
        this.postCode = postCode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BuildingsInPostCode{");
        sb.append("id=" + id  );
        sb.append(", building=" + building.getName() );
        sb.append(", postCode=" + postCode.getPostCode() );
        sb.append("}");
        return sb.toString();
    }
}
