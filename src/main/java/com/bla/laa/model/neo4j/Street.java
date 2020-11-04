package com.bla.laa.model.neo4j;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.neo4j.ogm.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.bla.laa.model.neo4j.BuildingsOnStreet.BUILDINGS_ON_STREET;
import static com.bla.laa.model.neo4j.Street.STREET;
import static com.bla.laa.model.neo4j.StreetsInCity.STREETS_IN_CITY;
import static com.bla.laa.model.neo4j.StreetsInVillage.STREETS_IN_VILLAGE;
import static org.neo4j.ogm.annotation.Relationship.INCOMING;
import static org.neo4j.ogm.annotation.Relationship.OUTGOING;

@NodeEntity(label = STREET)
public class Street {

    public static final String STREET = "street";

    @Id
    private Long vzdId;

    private String name;

    @Property(name = "formatted_adr")
    private String formattedAdr;

    @Relationship(type = BUILDINGS_ON_STREET, direction = INCOMING)
    private List<BuildingsOnStreet> buildings = new ArrayList<>();

    @Relationship(type = STREETS_IN_VILLAGE, direction = OUTGOING)
    private StreetsInVillage village ;

    @Relationship(type = STREETS_IN_CITY, direction = OUTGOING)
    private StreetsInCity city ;

    public Street() {
    }

    public Street(Long id, String name, String formattedAdr) {
        this.name = name;
        this.vzdId = id;
        this.formattedAdr = formattedAdr;
    }

    public List<BuildingsOnStreet> getBuildings() {
        return buildings;
    }

    public void setBuildings(List<BuildingsOnStreet> buildings) {
        this.buildings = buildings;
    }

    public StreetsInVillage getVillage() {
        return village;
    }

    public void setVillage(StreetsInVillage village) {
        this.village = village;
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

    public StreetsInCity getCity() {
        return city;
    }

    public void setCity(StreetsInCity city) {
        this.city = city;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Street{");
        sb.append("vzdId=" + vzdId );
        sb.append(", name=" + name  );
        if (village != null) {
            sb.append(", village(" + village.getStreet().getVzdId() + ")");
            sb.append(" = '" + village.getStreet().getName() + "'");
        } if (city != null) {
            sb.append(", city(" + city.getStreet().getVzdId() + ")");
            sb.append(" = '" + city.getStreet().getName() + "'");
        }
        if (buildings != null){
            sb.append(", buildings=[");
            for (BuildingsOnStreet b : buildings){
                sb.append("'" + b.getBuilding().getName() + "'");
                sb.append("(" + b.getBuilding().getVzdId() + "),");
            }
            sb.append("]");
        }
        sb.append("}");

        return sb.toString();
    }
}
