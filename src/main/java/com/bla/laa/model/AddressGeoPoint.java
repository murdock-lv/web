package com.bla.laa.model;

import javax.persistence.*;

import org.locationtech.jts.geom.MultiPoint;

/*
DROP TABLE milda3.`ADDRESS_GEO_POINT`

CREATE TABLE milda3.`ADDRESS_GEO_POINT` (
  `id` integer NOT NULL,
  `level` varchar(10) DEFAULT '',
  `parent` integer NOT NULL,
  `lat_lng` multipoint,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */

@Entity
@Table(name="ADDRESS_GEO_POINT")
public class AddressGeoPoint {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "level")
    @Enumerated(EnumType.STRING)
    private VkurTips.TipsEnum level = VkurTips.TipsEnum.NOTSET;

    @Column(name = "parent", nullable = false)
    private Integer parent = 0;

    @Column(name = "lat_lng", columnDefinition = "multipoint")
    private MultiPoint latLng;

    @Override
    public String toString() {
        return "AddressGeoPoint{" +
                "id=" + this.getId() +
                ", level='" + this.getLevel()  +
                ", parent=" + this.getParent() +
                ", latLng=" + this.getLatLng() +
                '}';
    }

    public VkurTips.TipsEnum getLevel() {
        return level;
    }

    public void setLevel(VkurTips.TipsEnum level) {
        this.level = level;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MultiPoint getLatLng() {
        return latLng;
    }

    public void setLatLng(MultiPoint latLng) {
        this.latLng = latLng;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

}
