package com.bla.laa.model.mysql;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.MultiLineString;

import javax.persistence.*;

/*
DROP TABLE milda3.`ADDRESS_GEO_LINE`

CREATE TABLE milda3.`ADDRESS_GEO_LINE` (
  `id` integer NOT NULL,
  `level` varchar(10) DEFAULT '',
  `parent` integer NOT NULL,
  `line` multilinestring,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

*/

@Entity
@Table(name="ADDRESS_GEO_LINE")
public class    AddressGeoLine {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "level")
    @Enumerated(EnumType.STRING)
    private VkurTips.TipsEnum level = VkurTips.TipsEnum.NOTSET;

    @Column(name = "parent", nullable = false)
    private Integer parent = 0;

    @Column(name = "line", columnDefinition = "multilinestring")
    private MultiLineString line;

    @Override
    public String toString() {


        String lineCord = "";
        if (line != null) {
            Coordinate startCord = line.getCoordinates()[0];
            Coordinate endCord = line.getCoordinates()[line.getCoordinates().length-1];
            lineCord = "start : ( " + startCord.getX() +" , "+ startCord.getY() + " ) end : ( "+ endCord.getX() + " , " + endCord.getY() + " ) ";

       }

        return "AddressGeoLine{" +
                "id=" + this.getId() +
                ", level='" + level  +
                ", parent=" + parent +
                ", line=" + lineCord +
                '}';

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public VkurTips.TipsEnum getLevel() {
        return level;
    }

    public void setLevel(VkurTips.TipsEnum level) {
        this.level = level;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public MultiLineString getLine() {
        return line;
    }

    public void setLine(MultiLineString line) {
        this.line = line;
    }

}
