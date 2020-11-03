package com.bla.laa.model.mysql;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource( collectionResourceRel = "address_geo_point", path = "address_geo_point" )
public interface AddressGeoPointSqlRepository extends CrudRepository<AddressGeoPoint, Integer>  {

    Optional<AddressGeoPoint> findById(Integer id);

}
