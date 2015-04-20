package pl.rozart.familytree.models;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by rozar_000 on 2015-04-19.
 */
@NodeEntity
public class Relationship {

    @GraphId
    private Long id;

    @RelatedTo(type = "IS_IN_RELATIONSHIP")
    private Set<Person> partners = new HashSet<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Person> getPartners() {
        return partners;
    }

    public void setPartners(Set<Person> partners) {
        this.partners = partners;
    }
}
