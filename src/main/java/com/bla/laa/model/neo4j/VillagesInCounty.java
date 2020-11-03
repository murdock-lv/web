package com.bla.laa.model.neo4j;

import org.neo4j.ogm.annotation.*;

import static com.bla.laa.model.neo4j.BuildingsInCity.BUILDINGS_IN_CITY;
import static com.bla.laa.model.neo4j.VillagesInCounty.VILLAGES_IN_COUNTY;


@RelationshipEntity(type = VILLAGES_IN_COUNTY)
public class VillagesInCounty {

    static final String  VILLAGES_IN_COUNTY = "villages_in_county";

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @StartNode
    private Village village;

    @EndNode
    private County county;

    public VillagesInCounty(Village v, County c) {
        this.village = v;
        this.county = c;

    }

    public Village getVillage() {
        return village;
    }

    public void setVillage(Village village) {
        this.village = village;
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
        sb.append(", county=" + county.getName() );
        sb.append("}");
        return sb.toString();
    }
}
