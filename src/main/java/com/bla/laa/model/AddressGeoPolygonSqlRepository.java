package com.bla.laa.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource( collectionResourceRel = "address_geo_polygon", path = "address_geo_polygon" )
public interface AddressGeoPolygonSqlRepository  extends CrudRepository<AddressGeoPolygon, Integer> {

    Optional<AddressGeoPolygon> findById(Integer id);

}
