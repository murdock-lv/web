package com.bla.laa.model.neo4j;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Optional;

public interface StreetRepository extends Neo4jRepository<Street, Long> {

    Optional<Street> findByName(String name);

    boolean existsByName(String street);

    Street findFirstByformattedAdr(String formattedAdr);
}
