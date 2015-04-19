package pl.rozart.familytree.models;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;
import org.springframework.data.neo4j.support.index.IndexType;

import java.util.Date;
import java.util.Set;

/**
 * Created by rozar_000 on 2015-04-19.
 */
@NodeEntity
public class Person {

    @GraphId
    private Long idPerson;

    @Indexed(unique = false, indexType = IndexType.FULLTEXT, indexName = "name")
    private String name;

    private Date birthDate;
    private Date deathDate;

    private String sex;

    @RelatedTo(type = "IS_PART_OF")
    private Set<Relationship> relationships;

    @RelatedTo(type = "IS_PARENT_OF")
    private Set<Person> children;

    @RelatedTo(type = "IS_CHILD_OF")
    private Relationship childOf;

}
