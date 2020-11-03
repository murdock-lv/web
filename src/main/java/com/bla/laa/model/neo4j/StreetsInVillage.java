package com.bla.laa.model.neo4j;

import org.neo4j.ogm.annotation.*;

import static com.bla.laa.model.neo4j.BuildingsOnStreet.BUILDINGS_ON_STREET;


@RelationshipEntity(type = StreetsInVillage.STREETS_IN_VILLAGE)
public class StreetsInVillage {

    static final String  STREETS_IN_VILLAGE = "streets_in_village";

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @EndNode
    private Village village;

    @StartNode
    private Street street;

    public StreetsInVillage(Street s, Village v) {
        this.street = s;
        this.village = v;
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

    public Village getVillage() {
        return village;
    }

    public void setVillage(Village village) {
        this.village = village;
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
        sb.append(", building=" + village.getName() );
        sb.append("}");
        return sb.toString();
    }
}
