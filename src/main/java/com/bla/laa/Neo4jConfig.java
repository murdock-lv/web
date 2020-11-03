package com.bla.laa;

import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;

@Configuration
@EnableNeo4jRepositories(basePackages = "com.bla.laa.model.neo4j")
public class Neo4jConfig {

    @Value("${spring.data.neo4j.username}")
    private String username;

    @Value("${spring.data.neo4j.password}")
    private String password;

    @Value("${spring.data.neo4j.uri}")
    private String url;

    @Bean
    public SessionFactory sessionFactory() {
        return new SessionFactory(configuration(), "com.bla.laa.model.neo4j");
    }

    @Bean
    public org.neo4j.ogm.config.Configuration configuration() {
        org.neo4j.ogm.config.Configuration configuration = new org.neo4j.ogm.config.Configuration.Builder()
                .uri(url)
                .credentials(username, password)
                .database("vartus")
                .verifyConnection(true)
                .useNativeTypes()
                .autoIndex("update")
                .build();
        return configuration;
    }

    @Bean
    public Neo4jTransactionManager transactionManager() {
        return new Neo4jTransactionManager(sessionFactory());
    }


}
