package com.bla.laa.model.neo4j;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.neo4j.ogm.annotation.*;

import java.util.List;

import static com.bla.laa.model.neo4j.BuildingsInCity.BUILDINGS_IN_CITY;
import static com.bla.laa.model.neo4j.BuildingsInPostCode.BUILDINGS_IN_POSTCODE;
import static com.bla.laa.model.neo4j.BuildingsInVillage.BUILDINGS_IN_VILLAGE;
import static com.bla.laa.model.neo4j.BuildingsOnStreet.BUILDINGS_ON_STREET;
import static com.bla.laa.model.neo4j.Country.POSTCODES_IN_COUNTRY;
import static com.bla.laa.model.neo4j.FlatsInBuilding.FLATS_IN_BUILDING;
import static org.neo4j.ogm.annotation.Relationship.INCOMING;
import static org.neo4j.ogm.annotation.Relationship.OUTGOING;

@NodeEntity(label = "post_code")
public class PostCode {

    @Id
    @GeneratedValue
    private Long id;

    private String postCode;

    @Relationship(type = BUILDINGS_IN_POSTCODE, direction = INCOMING)
    private List<BuildingsInPostCode> buildings ;

    @Relationship(type = POSTCODES_IN_COUNTRY, direction = OUTGOING)
    private Country country ;

    public PostCode() { }

    public PostCode(String postCode) {
        this.postCode = postCode;
    }

    public List<BuildingsInPostCode> getBuildings() {
        return buildings;
    }

    public void setBuildings(List<BuildingsInPostCode> buildings) {
        this.buildings = buildings;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Building{");
        sb.append("id=" + id );
        sb.append(", postCode='" + postCode + "'" );
        if (buildings != null){
            for (BuildingsInPostCode b : buildings){
                sb.append(b.getBuilding().getName() + " , ");
            }
            sb.append("]");
        }
        sb.append("}");


        return sb.toString();
    }
}
