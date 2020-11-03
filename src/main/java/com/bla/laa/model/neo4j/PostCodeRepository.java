package com.bla.laa.model.neo4j;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;
import java.util.Optional;

public interface PostCodeRepository extends Neo4jRepository<PostCode, Long> {

    boolean existsByPostCode(String PostCode);

    //Optional<PostCode> findByPostCode(String postCode);

    List<PostCode> findByPostCode(String postCode);

}
