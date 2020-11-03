package com.bla.laa.model.neo4j;

import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface FlatRepository extends Neo4jRepository<Flat, Long> {

    Flat findFirstByformattedAdr(String formattedAdr);

}
