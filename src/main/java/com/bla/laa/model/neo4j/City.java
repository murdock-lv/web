package com.bla.laa.model.neo4j;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

import static com.bla.laa.model.neo4j.BuildingsInCity.BUILDINGS_IN_CITY;
import static com.bla.laa.model.neo4j.City.CITY;
import static com.bla.laa.model.neo4j.CitysInCounty.CITYS_IN_COUNTY;
import static com.bla.laa.model.neo4j.Country.CITYS_IN_COUNTRY;
import static com.bla.laa.model.neo4j.StreetsInCity.STREETS_IN_CITY;
import static org.neo4j.ogm.annotation.Relationship.INCOMING;
import static org.neo4j.ogm.annotation.Relationship.OUTGOING;

@NodeEntity(label = CITY)
public class City {

    public static final String CITY = "city";

    @Id
    private Long vzdId;

    private String name;

    @Property(name = "formatted_adr")
    private String formattedAdr;

    @Relationship(type = BUILDINGS_IN_CITY, direction = INCOMING)
    private List<BuildingsInCity> buildings;

    @Relationship(type = STREETS_IN_CITY, direction = INCOMING)
    private List<StreetsInCity> streets;

    @Relationship(type = CITYS_IN_COUNTY, direction = OUTGOING)
    private CitysInCounty county;

    @Relationship(type = CITYS_IN_COUNTRY, direction = OUTGOING)
    private Country country;

    public City() {
    }

    public City(Long id, String name, String formattedAdr) {
        this.name = name;
        this.vzdId = id;
        this.formattedAdr = formattedAdr;
    }

    public City(Long id, String name) {
        this.name = name;
        this.vzdId = id;
    }

    public CitysInCounty getCounty() {
        return county;
    }

    public void setCounty(CitysInCounty county) {
        this.county = county;
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

    public List<BuildingsInCity> getBuildings() {
        return buildings;
    }

    public void setBuildings(List<BuildingsInCity> buildings) {
        this.buildings = buildings;
    }

    public List<StreetsInCity> getStreets() {
        return streets;
    }

    public void setStreets(List<StreetsInCity> streets) {
        this.streets = streets;
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
        sb.append("City{");
        sb.append("vzdId=" + vzdId );
        sb.append(", name='" + name + "'" );
        sb.append(", formattedAdr='" + formattedAdr  + "'" );
        sb.append(", country='" + country.getName()  + "'" );
        if (buildings != null){
            for (BuildingsInCity b : buildings){
                sb.append(b.getBuilding().getName() + " , ");
            }
            sb.append("]");
        }
        if (streets != null){
            for (StreetsInCity b : streets){
                sb.append(b.getStreet().getName() + " , ");
            }
            sb.append("]");
        }
        if (county != null)
            sb.append(", county='" + county  + "'" );
        sb.append("}");

        return sb.toString();
    }
}
