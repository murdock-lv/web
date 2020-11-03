package com.bla.laa.model.neo4j;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

import static com.bla.laa.model.neo4j.BuildingsInCounty.BUILDINGS_IN_COUNTY;
import static com.bla.laa.model.neo4j.CitysInCounty.CITYS_IN_COUNTY;
import static com.bla.laa.model.neo4j.Country.COUNTYS_IN_COUNTRY;
import static com.bla.laa.model.neo4j.County.COUNTY;
import static com.bla.laa.model.neo4j.ParishesInCounty.PARISHES_IN_COUNTY;
import static com.bla.laa.model.neo4j.VillagesInCounty.VILLAGES_IN_COUNTY;
import static org.neo4j.ogm.annotation.Relationship.INCOMING;
import static org.neo4j.ogm.annotation.Relationship.OUTGOING;

@NodeEntity(label = COUNTY)
public class County {

    public static final String COUNTY = "county";

    @Id
    private Long vzdId;

    private String name;

    @Relationship(type = COUNTYS_IN_COUNTRY, direction = OUTGOING)
    private Country country;

    @Relationship(type = PARISHES_IN_COUNTY, direction = INCOMING)
    private List<ParishesInCounty> parishs;

    @Relationship(type = CITYS_IN_COUNTY, direction = INCOMING)
    private List<CitysInCounty> citys;

    @Relationship(type = VILLAGES_IN_COUNTY, direction = INCOMING)
    private List<VillagesInCounty> villages;

    @Relationship(type = BUILDINGS_IN_COUNTY, direction = INCOMING)
    private List<BuildingsInCounty> buildings;

    public County() {

    }

    public County(Long id, String name) {
        this.name = name;
        this.vzdId = id;
    }

    public List<ParishesInCounty> getParishs() {
        return parishs;
    }

    public void setParishs(List<ParishesInCounty> parishs) {
        this.parishs = parishs;
    }

    public List<BuildingsInCounty> getBuildings() {
        return buildings;
    }

    public void setBuildings(List<BuildingsInCounty> buildings) {
        this.buildings = buildings;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
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

    public List<CitysInCounty> getCitys() {
        return citys;
    }

    public void setCitys(List<CitysInCounty> citys) {
        this.citys = citys;
    }

    public List<VillagesInCounty> getVillages() {
        return villages;
    }

    public void setVillages(List<VillagesInCounty> villages) {
        this.villages = villages;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("County{");
        sb.append("vzdId=" + vzdId );
        sb.append(", name='" + name + "'" );
        sb.append(", country='" + country.getName()  + "'" );
        if (villages != null){
            sb.append(", villages=[" );
            for (VillagesInCounty b : villages){
                sb.append(b.getVillage().getName() + " , ");
            }
            sb.append("]");
        }
        if (citys != null){
            sb.append(", villages=[" );
            for (CitysInCounty b : citys){
                sb.append(b.getCity().getName() + " , ");
            }
            sb.append("]");
        }
        sb.append("}");

        return sb.toString();
    }
}
