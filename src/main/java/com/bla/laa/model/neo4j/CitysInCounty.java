package com.bla.laa.model.neo4j;

import org.neo4j.ogm.annotation.*;

import static com.bla.laa.model.neo4j.BuildingsInCity.BUILDINGS_IN_CITY;
import static com.bla.laa.model.neo4j.CitysInCounty.CITYS_IN_COUNTY;


@RelationshipEntity(type = CITYS_IN_COUNTY)
public class CitysInCounty {

    static final String  CITYS_IN_COUNTY = "citys_in_county";

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @StartNode
    private City city;

    @EndNode
    private County county;

    public CitysInCounty(City c, County cc) {
        this.city = c;
        this.county = cc;
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

    public County getCounty() {
        return county;
    }

    public void setCounty(County county) {
        this.county = county;
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
        sb.append(", county=" + county.getName() );
        sb.append("}");
        return sb.toString();
    }
}
