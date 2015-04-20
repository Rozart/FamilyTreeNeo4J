package pl.rozart.familytree.models;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;
import org.springframework.data.neo4j.support.index.IndexType;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by rozar_000 on 2015-04-19.
 */
@NodeEntity
public class Person {

    @GraphId
    private Long id;

    @Indexed(unique = false, indexType = IndexType.FULLTEXT, indexName = "name")
    private String name;

    @DateTimeFormat(pattern = "dd-MM-YYYY")
    private Date birthDate;

    @DateTimeFormat(pattern = "dd-MM-YYYY")
    private Date deathDate;

    private String sex;

    @RelatedTo(type = "IS_PART_OF")
    private Set<Relationship> relationships = new HashSet<>();

    @RelatedTo(type = "IS_PARENT_OF")
    private Set<Person> children = new HashSet<>();

    @RelatedTo(type = "IS_CHILD_OF")
    private Relationship childOf;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(Date deathDate) {
        this.deathDate = deathDate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Set<Relationship> getRelationships() {
        return relationships;
    }

    public void setRelationships(Set<Relationship> relationships) {
        this.relationships = relationships;
    }

    public Set<Person> getChildren() {
        return children;
    }

    public void setChildren(Set<Person> children) {
        this.children = children;
    }

    public Relationship getChildOf() {
        return childOf;
    }

    public void setChildOf(Relationship childOf) {
        this.childOf = childOf;
    }
}
