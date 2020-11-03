package com.bla.laa.model.neo4j;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

import static com.bla.laa.model.neo4j.Flat.FLAT;
import static com.bla.laa.model.neo4j.FlatsInBuilding.FLATS_IN_BUILDING;
import static org.neo4j.ogm.annotation.Relationship.OUTGOING;

@NodeEntity(label = FLAT)
public class Flat {

    public static final String FLAT = "flat";

    @Id
    private Long vzdId;

    private String name;

    @Property(name = "formatted_adr")
    private String formattedAdr;

    @Relationship(type = FLATS_IN_BUILDING, direction = OUTGOING)
    private FlatsInBuilding building;

    public Flat(Long id, String name, String formatted_adr) {
        this.vzdId = id;
        this.name = name;
        this.formattedAdr = formatted_adr;
    }

    public String getFormattedAdr() {
        return formattedAdr;
    }

    public void setFormattedAdr(String formattedAdr) {
        this.formattedAdr = formattedAdr;
    }

    public FlatsInBuilding getBuilding() {
        return building;
    }

    public void setBuilding(FlatsInBuilding building) {
        this.building = building;
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

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Flat{");
        sb.append("vzdId=" + vzdId );
        sb.append(", name='" + name  );
        sb.append(", formattedAdr='" + formattedAdr  );
        if (building != null){
            sb.append(", building(" + building.getBuilding().getVzdId() + ")");
            sb.append(" = '" + building.getBuilding().getName() + "'");
        }
        sb.append("}");

        return sb.toString();
    }
}
