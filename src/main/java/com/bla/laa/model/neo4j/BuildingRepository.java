package com.bla.laa.model.neo4j;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;
import java.util.Optional;

public interface BuildingRepository extends Neo4jRepository<Building, Long> {

    List<Building> findByName(String name);

    Building findFirstByformattedAdr(String formattedAdr);

    boolean existsByName(String street);
}
