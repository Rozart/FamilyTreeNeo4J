package pl.rozart.familytree.dao;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;
import pl.rozart.familytree.models.Person;
import pl.rozart.familytree.models.Relationship;

/**
 * Created by rozar_000 on 2015-04-20.
 */
@Repository
public interface RelationshipRepository extends GraphRepository<Relationship> {

    // Empty for now

}
