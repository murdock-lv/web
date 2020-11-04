package com.bla.laa.model.neo4j;

import org.neo4j.ogm.annotation.*;

import static com.bla.laa.model.neo4j.VillagesInParish.VILLAGES_IN_PARISH;


@RelationshipEntity(type = VILLAGES_IN_PARISH)
public class VillagesInParish {

    static final String VILLAGES_IN_PARISH = "villages_in_parish";

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @StartNode
    private Village village;

    @EndNode
    private Parish parish;

    public VillagesInParish(Village v, Parish p) {
        this.village = v;
        this.parish = p;
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

    public Parish getParish() {
        return parish;
    }

    public void setParish(Parish parish) {
        this.parish = parish;
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
        sb.append("VillagesInParish{");
        sb.append("id=" + id  );
        sb.append(", name='" + name + '\'' );
        sb.append(", village=" + village.getName() );
        sb.append(", parish=" + parish.getName() );
        sb.append("}");
        return sb.toString();
    }
}
