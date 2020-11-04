package com.bla.laa.model.neo4j;

import org.neo4j.ogm.annotation.*;

import static com.bla.laa.model.neo4j.ParishesInCounty.PARISHES_IN_COUNTY;


@RelationshipEntity(type = PARISHES_IN_COUNTY)
public class ParishesInCounty {

    static final String  PARISHES_IN_COUNTY = "parishes_in_county";

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @StartNode
    private Parish parish;

    @EndNode
    private County county;

    public ParishesInCounty(Parish p, County c) {
        this.parish = p;
        this.county = c;

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
        sb.append("ParishesInCounty{");
        sb.append("id=" + id  );
        sb.append(", name='" + name + '\'' );
        sb.append(", parish=" + parish.getName() );
        sb.append(", county=" + county.getName() );
        sb.append("}");
        return sb.toString();
    }
}
