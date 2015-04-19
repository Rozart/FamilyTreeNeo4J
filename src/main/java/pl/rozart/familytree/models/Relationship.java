package pl.rozart.familytree.models;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;

/**
 * Created by rozar_000 on 2015-04-19.
 */
@NodeEntity
public class Relationship {

    @GraphId
    private Long idRelationship;

}
