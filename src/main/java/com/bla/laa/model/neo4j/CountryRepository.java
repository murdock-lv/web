package com.bla.laa.model.neo4j;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;
import java.util.Optional;

public interface CountryRepository extends Neo4jRepository<Country, Long> {

    Optional<Country> findByName(String name);

    boolean existsByName(String street);

    Optional<Country> findFirstByName(String name);
}
