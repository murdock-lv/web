package com.bla.laa.model.neo4j;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Optional;

public interface ParishRepository extends Neo4jRepository<Parish, Long> {
    Parish findFirstByformattedAdr(String adr);
}
