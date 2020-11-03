package com.bla.laa.model.neo4j;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface CountyRepository extends Neo4jRepository<County, Long> {

    List<Building> findByName(String name);

    boolean existsByName(String street);

    County findFirstByName(String name);
}
