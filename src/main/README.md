Intro 
------

This repo contains web app for upcoming real estate search engine


Tech 
------

Build on : 

   * Spring boot 
   * Spring MVC
   * Hibernate
   * Mysql 5.4
   * Gradle 
   * Java JSP   
   
Doc
----
   
   https://docs.spring.io/spring-boot/docs/current/reference/html/appendix-application-properties.html
   https://beginnersbook.com/2013/12/fncontains-jstl-function/
   
Neo4j 
---------

    MATCH (n:building) WHERE n.formatted_adr = "Dienvidu iela 4, Dzidriņas, Stopiņu nov., LV-2130" WITH n RETURN n ,
    [ 
        [ (n)-[r_b1:buildings_in_city]->(c1:city) | [ r_b1, c1 ] ],
        [ (n)<-[r_f1:flats_in_building]-(f1:flat) | [ r_f1, f1 ] ],
        [ (n)-[r_b1:buildings_on_street]->(s1:street) | [ r_b1, s1 ] ],
        [ (n)-[r_b1:buildings_in_parish]->(p1:parish) | [ r_b1, p1 ] ],
        [ (n)-[r_b1:buildings_in_county]->(c1:county) | [ r_b1, c1 ] ],
        [ (n)-[r_b1:buildings_in_postcode]->(p1:post_code) | [ r_b1, p1 ] ],
        [ (n)-[r_b1:buildings_in_village]->(v1:village) | [ r_b1, v1 ] ] 
    ], ID(n) 
