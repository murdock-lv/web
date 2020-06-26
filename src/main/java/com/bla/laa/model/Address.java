package com.bla.laa.model;

import javax.persistence.*;

/*
DROP TABLE milda3.`ADDRESS`

CREATE TABLE milda3.`ADDRESS` (
  `id` int(11) NOT NULL,
  `level` varchar(10) DEFAULT '',
  `parent` int(11) NOT NULL,
  `flat` varchar(32) DEFAULT '',
  `building` varchar(32) DEFAULT '',
  `street` varchar(32) DEFAULT '',
  `village` varchar(32) DEFAULT '',
  `city` varchar(32) DEFAULT '',
  `parish` varchar(32) DEFAULT '',
  `county` varchar(32) DEFAULT '',
  `post_code` char(7) DEFAULT '',
  `formatted_adr` varchar(255) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE INDEX milda3.`ADDRESS_parent_IDX` USING BTREE ON milda3.ADDRESS (parent);


 */

@Entity
@Table(name="ADDRESS")
public class Address {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "level")
    @Enumerated(EnumType.STRING)
    private VkurTips.TipsEnum level = VkurTips.TipsEnum.NOTSET;

    @Column(name = "parent")
    private Integer parent = 0;

    @Column(name = "flat", length = 32)
    private String flat = "";

    @Column(name = "building", length = 64)
    private String building = "";

    @Column(name = "street", length = 64)
    private String street = "";

    @Column(name = "village", length = 32)
    private String village = "";

    @Column(name = "city", length = 32)
    private String city = "";

    //Pagasts
    @Column(name = "parish" , length = 32)
    private String parish = "";

    //Novads region-county
    @Column(name = "county" , length = 32)
    private String county = "";

    @Column(name = "post_code", columnDefinition = "char(7)")
    private String postCode = "";

    @Column(name = "formatted_adr")
    private String formattedAdr = "";

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", level=" + level +
                ", parent=" + parent +
                ", flat='" + flat + '\'' +
                ", building='" + building + '\'' +
                ", street='" + street + '\'' +
                ", village='" + village + '\'' +
                ", city='" + city + '\'' +
                ", parish='" + parish + '\'' +
                ", county='" + county + '\'' +
                ", postCode='" + postCode + '\'' +
                ", formattedAdr='" + formattedAdr + '\'' +
                '}';
    }

    public VkurTips.TipsEnum getLevel() {
        return level;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getParish() {
        return parish;
    }

    public void setParish(String parish) {
        this.parish = parish;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getFormattedAdr() {
        return formattedAdr;
    }

    public void setFormattedAdr(String formattedAdr) {
        this.formattedAdr = formattedAdr;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public void setLevel(VkurTips.TipsEnum level) {
        this.level = level;
    }
}
