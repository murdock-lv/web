package com.bla.laa.model.neo4j;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

import static com.bla.laa.model.neo4j.FlatsInBuilding.FLATS_IN_BUILDING;
import static com.bla.laa.model.neo4j.Parish.PARISH;
import static com.bla.laa.model.neo4j.ParishesInCounty.PARISHES_IN_COUNTY;
import static com.bla.laa.model.neo4j.VillagesInParish.VILLAGES_IN_PARISH;
import static org.neo4j.ogm.annotation.Relationship.INCOMING;
import static org.neo4j.ogm.annotation.Relationship.OUTGOING;

@NodeEntity(label = PARISH)
public class Parish {

    public static final String PARISH = "parish";

    @Id
    private Long vzdId;

    private String name;

    @Property(name = "formatted_adr")
    private String formattedAdr;

    @Relationship(type = VILLAGES_IN_PARISH, direction = INCOMING)
    private List<VillagesInParish> villages;

    @Relationship(type = FLATS_IN_BUILDING, direction = INCOMING)
    private List<BuildingsInParish> buildings;

    @Relationship(type = PARISHES_IN_COUNTY, direction = OUTGOING)
    private ParishesInCounty county;

    public Parish(Long id, String name, String formatted_adr) {
        this.vzdId = id;
        this.name = name;
        this.formattedAdr = formatted_adr;
    }

    public ParishesInCounty getCounty() {
        return county;
    }

    public void setCounty(ParishesInCounty county) {
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

    public List<VillagesInParish> getVillages() {
        return villages;
    }

    public void setVillages(List<VillagesInParish> villages) {
        this.villages = villages;
    }

    public List<BuildingsInParish> getBuildings() {
        return buildings;
    }

    public void setBuildings(List<BuildingsInParish> buildings) {
        this.buildings = buildings;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Flat{");
        sb.append("vzdId=" + vzdId );
        sb.append(", name='" + name  );
        sb.append(", formattedAdr='" + formattedAdr  );
        sb.append("}");

        return sb.toString();
    }
}
