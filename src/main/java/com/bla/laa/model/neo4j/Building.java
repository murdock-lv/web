package com.bla.laa.model.neo4j;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.neo4j.ogm.annotation.*;

import java.util.List;

import static com.bla.laa.model.neo4j.Building.BUILDING;
import static com.bla.laa.model.neo4j.BuildingsInCity.BUILDINGS_IN_CITY;
import static com.bla.laa.model.neo4j.BuildingsInCounty.BUILDINGS_IN_COUNTY;
import static com.bla.laa.model.neo4j.BuildingsInParish.BUILDINGS_IN_PARISH;
import static com.bla.laa.model.neo4j.BuildingsInPostCode.BUILDINGS_IN_POSTCODE;
import static com.bla.laa.model.neo4j.BuildingsInVillage.BUILDINGS_IN_VILLAGE;
import static com.bla.laa.model.neo4j.BuildingsOnStreet.BUILDINGS_ON_STREET;
import static com.bla.laa.model.neo4j.FlatsInBuilding.FLATS_IN_BUILDING;
import static org.neo4j.ogm.annotation.Relationship.INCOMING;
import static org.neo4j.ogm.annotation.Relationship.OUTGOING;

@NodeEntity(label = BUILDING)
public class Building {

    public static final String BUILDING = "building";

    @Id
    private Long vzdId;

    private String name;

    @Property(name = "formatted_adr")
    private String formattedAdr;

    @Relationship(type = BUILDINGS_IN_COUNTY, direction = OUTGOING)
    private BuildingsInCounty county ;

    @Relationship(type = BUILDINGS_IN_PARISH, direction = OUTGOING)
    private BuildingsInParish parish ;

    @Relationship(type = BUILDINGS_IN_VILLAGE, direction = OUTGOING)
    private BuildingsInVillage village ;

    @Relationship(type = BUILDINGS_IN_CITY, direction = OUTGOING)
    private BuildingsInCity city ;

    @Relationship(type = BUILDINGS_ON_STREET, direction = OUTGOING)
    private BuildingsOnStreet street ;

    @Relationship(type = BUILDINGS_IN_POSTCODE, direction = OUTGOING)
    private BuildingsInPostCode postCode ;

    @Relationship(type = FLATS_IN_BUILDING, direction = INCOMING)
    private List<FlatsInBuilding> flats ;

    public Building() {
    }

    public Building(Long id, String name, String formattedAdr) {
        this.name = name;
        this.vzdId = id;
        this.formattedAdr = formattedAdr;
    }


    public BuildingsInCounty getCounty() {
        return county;
    }

    public void setCounty(BuildingsInCounty county) {
        this.county = county;
    }

    public BuildingsInCity getCity() {
        return city;
    }

    public void setCity(BuildingsInCity city) {
        this.city = city;
    }

    public BuildingsOnStreet getStreet() {
        return street;
    }

    public void setStreet(BuildingsOnStreet street) {
        this.street = street;
    }

    public String getFormattedAdr() {
        return formattedAdr;
    }

    public void setFormattedAdr(String formattedAdr) {
        this.formattedAdr = formattedAdr;
    }

    public Long getVzdId() {
        return vzdId;
    }

    public void setVzdId(Long vzdId) {
        this.vzdId = vzdId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FlatsInBuilding> getFlats() {
        return flats;
    }

    public void setFlats(List<FlatsInBuilding> flats) {
        this.flats = flats;
    }

    public BuildingsInVillage getVillage() {
        return village;
    }

    public void setVillage(BuildingsInVillage village) {
        this.village = village;
    }

    public BuildingsInPostCode getPostCode() {
        return postCode;
    }

    public void setPostCode(BuildingsInPostCode postCode) {
        this.postCode = postCode;
    }

    public BuildingsInParish getParish() {
        return parish;
    }

    public void setParish(BuildingsInParish parish) {
        this.parish = parish;
    }



    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Building{");
        sb.append("vzdId=" + vzdId);
        sb.append(", name='" + name + "'");
        sb.append(", formattedAdr='" + formattedAdr + "'");
        if (county != null) {
            sb.append(", county(" + county.getCounty().getVzdId() + ")");
            sb.append(" = '" + county.getCounty().getName() + "'");
        } if (parish != null){
            sb.append(", parish(" + parish.getParish().getVzdId() + ")");
            sb.append(" = '" + parish.getParish().getName() + "'");
        } if (village != null){
            sb.append(", parish(" + village.getVillage().getVzdId() + ")");
            sb.append(" = '" + village.getVillage().getName() + "'");
        }if (city != null){
            sb.append(", city(" + city.getCity().getVzdId() + ")");
            sb.append(" = '" + city.getCity().getName() + "'");
        }
        if (street != null) {
            sb.append(", street(" + street.getStreet().getVzdId() + ")");
            sb.append(" = '" + street.getStreet().getName() + "'");
        }if (flats != null){
            sb.append(", Flats=[");
            for (FlatsInBuilding f : flats){
                sb.append("(" + f.getFlat().getVzdId() + ")");
                sb.append(" = '" + f.getFlat().getName() + "'");
                sb.append(",");
            }
            sb.append("]");
        }
        if (postCode != null) {
            sb.append(", postCode(" + postCode.getPostCode().getId() + ")");
            sb.append(" = '" + postCode.getPostCode().getPostCode() + "'");
        }

        sb.append("}");

        return sb.toString();
    }
}
