package com.bla.laa.model.neo4j;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

import static com.bla.laa.model.neo4j.BuildingsInVillage.BUILDINGS_IN_VILLAGE;
import static com.bla.laa.model.neo4j.StreetsInVillage.STREETS_IN_VILLAGE;
import static com.bla.laa.model.neo4j.Village.VILLAGE;
import static com.bla.laa.model.neo4j.VillagesInCounty.VILLAGES_IN_COUNTY;
import static com.bla.laa.model.neo4j.VillagesInParish.VILLAGES_IN_PARISH;
import static org.neo4j.ogm.annotation.Relationship.INCOMING;
import static org.neo4j.ogm.annotation.Relationship.OUTGOING;

@NodeEntity(label = VILLAGE)
public class Village {

    public static final String VILLAGE = "village";

    @Id
    private Long vzdId;

    private String name;

    @Property(name = "formatted_adr")
    private String formattedAdr;

    @Relationship(type = STREETS_IN_VILLAGE, direction = INCOMING)
    private List<StreetsInVillage> streets ;

    @Relationship(type = BUILDINGS_IN_VILLAGE, direction = INCOMING)
    private List<BuildingsInVillage> buildings ;

    @Relationship(type = VILLAGES_IN_PARISH, direction = OUTGOING)
    private VillagesInParish parish;

    @Relationship(type = VILLAGES_IN_COUNTY, direction = OUTGOING)
    private VillagesInCounty county;

    public Village() { }

    public Village(Long id, String name, String formattedAdr) {
        this.name = name;
        this.vzdId = id;
        this.formattedAdr = formattedAdr;
    }

    public VillagesInParish getParish() {
        return parish;
    }

    public void setParish(VillagesInParish parish) {
        this.parish = parish;
    }

    public VillagesInCounty getCounty() {
        return county;
    }

    public void setCounty(VillagesInCounty county) {
        this.county = county;
    }

    public List<StreetsInVillage> getStreets() {
        return streets;
    }

    public void setStreets(List<StreetsInVillage> streets) {
        this.streets = streets;
    }

    public List<BuildingsInVillage> getBuildings() {
        return buildings;
    }

    public void setBuildings(List<BuildingsInVillage> buildings) {
        this.buildings = buildings;
    }

    public String getFormattedAdr() {
        return formattedAdr;
    }

    public void setFormattedAdr(String formattedAdr) {
        this.formattedAdr = formattedAdr;
    }

    public void setVzdId(Long vzdId) {
        this.vzdId = vzdId;
    }

    public Long getVzdId() {
        return vzdId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {

        StringBuffer sb = new StringBuffer();
        sb.append("Village{");
        sb.append("vzdId=" + vzdId );
        sb.append(", name='" + name + "'" );
        sb.append(", formattedAdr='" + formattedAdr + "'" );
        if (buildings != null){
            sb.append(", building=[");
            for (BuildingsInVillage s : this.buildings){
                sb.append("'"+ s.getBuilding().getName() +"'");
                sb.append(" (" + s.getBuilding().getVzdId() + "), ");
            }
            sb.append("]");
        }
        if (streets != null){
            sb.append(", streets=[");
            for (StreetsInVillage s : this.streets){
                sb.append("'"+ s.getStreet().getName() +"'");
                sb.append("(" + s.getStreet().getVzdId() + "), ");
            }
            sb.append("]");
        }
        if (county != null) {
            sb.append(", county='" + county  + "'" );
        }

        sb.append("}");

        return sb.toString();
    }
}


