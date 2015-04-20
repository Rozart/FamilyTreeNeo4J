package pl.rozart.familytree.dao;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;
import pl.rozart.familytree.models.Person;

/**
 * Created by rozar_000 on 2015-04-19.
 */
@Repository
public interface PersonRepository extends GraphRepository<Person> {

    Iterable<Person> findByName(String name);

}