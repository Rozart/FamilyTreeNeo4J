package pl.rozart.familytree.config;

import org.neo4j.graphdb.GraphDatabaseService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.rest.SpringRestGraphDatabase;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by rozar_000 on 2015-04-20.
 */
@Configuration
@EnableTransactionManagement
@EnableNeo4jRepositories(basePackages = "pl.rozart.familytree.dao")
public class FamilyTreeDbConfiguration extends Neo4jConfiguration {


    @Bean
    GraphDatabaseService graphDatabaseService() {
        SpringRestGraphDatabase x = null;

        return new SpringRestGraphDatabase("http://localhost:7474/db/data/","neo4j","admin");
    }

}
