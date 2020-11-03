package com.bla.laa.model.neo4j;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

import static com.bla.laa.model.neo4j.CitysInCounty.CITYS_IN_COUNTY;
import static com.bla.laa.model.neo4j.Country.COUNTRY;
import static com.bla.laa.model.neo4j.VillagesInCounty.VILLAGES_IN_COUNTY;
import static org.neo4j.ogm.annotation.Relationship.INCOMING;

@NodeEntity(label = COUNTRY)
public class Country {

    public static final String  COUNTYS_IN_COUNTRY = "countys_in_country";
    public static final String  CITYS_IN_COUNTRY = "citys_in_country";
    public static final String  POSTCODES_IN_COUNTRY = "postcodes_in_country";

    public static final Long ID = 100000000L;
    public static final String NAME = "Latvija";

    public static final String COUNTRY = "country";

    @Id
    private Long vzdId;

    private String name;

    @Relationship(type = COUNTYS_IN_COUNTRY, direction = INCOMING)
    private List<County> countys;

    @Relationship(type = CITYS_IN_COUNTRY, direction = INCOMING)
    private List<City> citys;

    public Country(Long id, String name) {
        this.name = name;
        this.vzdId = id;
    }

    public List<County> getCountys() {
        return countys;
    }

    public void setCountys(List<County> countys) {
        this.countys = countys;
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

    public List<City> getCitys() {
        return citys;
    }

    public void setCitys(List<City> citys) {
        this.citys = citys;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Country{");
        sb.append("vzdId=" + vzdId );
        sb.append(", name='" + name + "'" );
        if (countys != null){
            sb.append(", countys=[" );
            for (County c : countys){
                sb.append(c.getName() + " , ");
            }
            sb.append("]");
        }
        sb.append("}");

        return sb.toString();
    }
}
