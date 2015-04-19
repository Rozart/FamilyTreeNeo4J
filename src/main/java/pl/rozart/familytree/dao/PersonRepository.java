package pl.rozart.familytree.dao;

import org.springframework.data.neo4j.repository.GraphRepository;
import pl.rozart.familytree.models.Person;

/**
 * Created by rozar_000 on 2015-04-19.
 */
interface PersonRepository extends GraphRepository<Person> {

    Iterable<Person> findByName(String name);

}