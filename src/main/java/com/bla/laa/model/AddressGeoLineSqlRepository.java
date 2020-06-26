package com.bla.laa.model;

//import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

//@RepositoryRestResource( collectionResourceRel = "address_geo_line", path = "address_geo_line" )
public interface AddressGeoLineSqlRepository /* extends CrudRepository<AddressGeoLine, Integer> */ {

    Optional<AddressGeoLine> findById(Integer id);

}
