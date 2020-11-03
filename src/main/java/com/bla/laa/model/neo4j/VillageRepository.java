package com.bla.laa.model.neo4j;

import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface VillageRepository extends Neo4jRepository<Village, Long> {
    Village findFirstByformattedAdr(String formattedAdr);
}
