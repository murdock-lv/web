package com.bla.laa.controller;

import com.bla.laa.model.neo4j.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

import static com.bla.laa.model.neo4j.Building.BUILDING;
import static com.bla.laa.model.neo4j.City.CITY;
import static com.bla.laa.model.neo4j.Country.COUNTRY;
import static com.bla.laa.model.neo4j.County.COUNTY;
import static com.bla.laa.model.neo4j.Flat.FLAT;
import static com.bla.laa.model.neo4j.Parish.PARISH;
import static com.bla.laa.model.neo4j.Street.STREET;
import static com.bla.laa.model.neo4j.Village.VILLAGE;

@Controller
@RequestMapping(path = "/adr")
public class AddressController {

    @Autowired
    FlatRepository flatRepository;

    @Autowired
    BuildingRepository buildingRepository;

    @Autowired
    StreetRepository streetRepository;

    @Autowired
    CityRepository cityRepository;

    @Autowired
    VillageRepository villageRepository;

    @Autowired
    ParishRepository parishRepository;

    @Autowired
    CountyRepository countyRepository;

    @Autowired
    CountryRepository countryRepository;


    static final Logger logger = LoggerFactory.getLogger(AddressController.class);


    // Dienvidu iela 4, Dzidriņas, Stopiņu nov., LV-2130" -> "Dienvidu%20iela%204,%20Dzidri%C5%86as,%20Stopi%C5%86u%20nov.,%20LV-2130";
    @GetMapping("/{adr}")
    public ModelAndView getAdr(HttpServletRequest request , @PathVariable String adr) {
        ModelAndView modelAndView = new ModelAndView("adr");

        Map<String, Object> attributes = new HashMap<>();

        Flat flat = flatRepository.findFirstByformattedAdr(adr);
        if (flat != null) {
            logger.info("Found {} : {}", FLAT ,flat);
            modelAndView.addAllObjects( getFlat(attributes, flat.getVzdId()));
            modelAndView.addObject("found_"+ FLAT, true);
        }

        if (attributes.isEmpty()) {
            Building building = buildingRepository.findFirstByformattedAdr(adr);
            if (building != null) {
                logger.info("Found {} : {}", BUILDING ,building);
                modelAndView.addAllObjects(getBuilding(attributes, building.getVzdId()));
                modelAndView.addObject("found_"+ BUILDING, true);
            }
        }

        if (attributes.isEmpty()) {
            Street street = streetRepository.findFirstByformattedAdr(adr);
            if ( street != null) {
                logger.info("Found {} : {}", STREET ,street);
                modelAndView.addAllObjects(getStreet(attributes, street.getVzdId()));
                modelAndView.addObject("found_" + STREET, true);
            }
        }

        if (attributes.isEmpty()) {
            City city = cityRepository.findFirstByformattedAdr(adr);
            if ( city != null) {
                logger.info("Found {} : {}", CITY , city);
                modelAndView.addAllObjects(getCity(attributes, city.getVzdId()));
                modelAndView.addObject("found_" + CITY, true);
            }
        }

        if (attributes.isEmpty()) {
            Village village = villageRepository.findFirstByformattedAdr(adr);
            if ( village != null) {
                logger.info("Found {} : {}", VILLAGE , village);
                modelAndView.addAllObjects(getVillage(attributes, village.getVzdId()));
                modelAndView.addObject("found_" + VILLAGE, true);
            }
        }

        if (attributes.isEmpty()) {
            Parish parish = parishRepository.findFirstByformattedAdr(adr);
            if ( parish != null) {
                logger.info("Found {} : {}", PARISH , parish);
                modelAndView.addAllObjects(getCounty(attributes, parish.getVzdId()));
                modelAndView.addObject("found_" + PARISH, true);
            }
        }

        if (attributes.isEmpty()) {
            County county = countyRepository.findFirstByName(adr);
            if ( county != null) {
                logger.info("Found {} : {}", COUNTY , county);
                modelAndView.addAllObjects(getCounty(attributes, county.getVzdId()));
                modelAndView.addObject("found_" + COUNTY, true);
            }
        }
        if (attributes.isEmpty()) {
            Country country = countryRepository.findFirstByName(adr).get();
            if (country != null){
                logger.info("Found {} : {}", COUNTRY , country);
                modelAndView.addObject(COUNTRY, country);
                modelAndView.addObject("found_" + COUNTRY, true);
            }
        }


        return modelAndView;
    }


    public Map<String, Object> getFlat( Map<String, Object> attributes, Long id) {
        Flat flat = flatRepository.findById(id).get();
        logger.info("Found {} : {}", FLAT , flat);

        attributes.put(FLAT, flat);
        if (flat.getBuilding() != null)
            attributes = getBuilding(attributes, flat.getBuilding().getBuilding().getVzdId());

        return attributes;
    }

    public Map<String, Object> getBuilding( Map<String, Object> attributes, Long id) {
        Building building = buildingRepository.findById(id).get();
        logger.info("Found {} : {}", BUILDING , building);

        attributes.put(BUILDING, building);

        if (building.getCounty() != null)
            attributes = getCounty(attributes, building.getCounty().getCounty().getVzdId());

        if (building.getParish() != null)
            attributes = getParish(attributes, building.getParish().getParish().getVzdId());

        if (building.getCity() != null)
            attributes = getCity(attributes, building.getCity().getCity().getVzdId());

        if (building.getVillage() != null)
            attributes = getVillage(attributes, building.getVillage().getVillage().getVzdId());

        if (building.getStreet() != null)
            attributes = getStreet(attributes, building.getStreet().getStreet().getVzdId());

        return attributes;
    }

    public Map<String, Object> getStreet( Map<String, Object> attributes, Long id){
        Street street = streetRepository.findById(id).get();
        logger.info("Found {} : {}", STREET , street);

        attributes.put(STREET, street);

        if (street.getVillage() != null)
            attributes = getVillage(attributes, street.getVillage().getVillage().getVzdId());

        if (street.getCity() != null)
            attributes = getCity(attributes, street.getCity().getCity().getVzdId());

        return attributes;
    }

    private Map<String, Object> getVillage(Map<String, Object> attributes, Long id) {
        Village village = villageRepository.findById(id).get();
        logger.info("Found {} : {}", VILLAGE , village);
        attributes.put(VILLAGE, village);

        if (village.getParish() != null)
            attributes = getParish(attributes, village.getParish().getParish().getVzdId());

        if (village.getCounty() != null)
            attributes = getCounty(attributes, village.getCounty().getCounty().getVzdId());

        return  attributes;
    }

    private Map<String, Object> getCity(Map<String, Object> attributes, Long id) {
        City city = cityRepository.findById(id).get();
        logger.info("Found {} : {}", CITY , city);
        attributes.put(CITY, city);

        if (city.getCounty() != null)
            attributes = getCounty(attributes, city.getCounty().getCounty().getVzdId());

        if (city.getCountry() != null)
            attributes = getCountry(attributes, city.getCountry().getVzdId());

        return  attributes;

    }

    private Map<String, Object> getParish(Map<String, Object> attributes, Long id){
        Parish parish = parishRepository.findById(id).get();
        logger.info("Found {} : {}", PARISH , parish);
        attributes.put( PARISH, parish);
        return attributes;
    }

    private Map<String, Object> getCounty(Map<String, Object> attributes, Long id){
        County county = countyRepository.findById(id).get();
        logger.info("Found {} : {}", COUNTY , county);
        attributes.put( COUNTY, county);

        if (county.getCountry() != null)
            attributes = getCountry(attributes, county.getCountry().getVzdId());

        return attributes;
    }

    private Map<String, Object> getCountry(Map<String, Object> attributes, Long id) {
        Country country = countryRepository.findById(id).get();
        logger.info("Found {} : {}", COUNTRY, country);
        attributes.put(COUNTRY, country);
        return attributes;
    }

}

