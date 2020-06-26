package com.bla.laa.model;

import org.locationtech.jts.geom.MultiPolygon;

import javax.persistence.*;

/*
DROP TABLE milda3.`ADDRESS_GEO_POLYGON`

CREATE TABLE milda3.`ADDRESS_GEO_POLYGON` (
  `id` integer NOT NULL,
  `level` varchar(10) DEFAULT '',
  `parent` integer NOT NULL,
  `polygon` multipolygon,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

 */

@Entity
@Table(name="ADDRESS_GEO_POLYGON")
public class AddressGeoPolygon {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "level")
    @Enumerated(EnumType.STRING)
    private VkurTips.TipsEnum level = VkurTips.TipsEnum.NOTSET;

    @Column(name = "parent", nullable = false)
    private Integer parent = 0;

    @Column(name = "polygon", columnDefinition = "multipolygon")
    private MultiPolygon polygon;

    @Override
    public String toString() {
        return "AddressGeoPolygon{" +
                "id=" + this.getId() +
                ", level='" + level + '\'' +
                ", parent=" + parent +
                ", polygon.centroid=" + polygon.getCentroid() +
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

    public MultiPolygon getPolygon() {
        return polygon;
    }

    public void setPolygon(MultiPolygon polygon) {
        this.polygon = polygon;
    }
}
