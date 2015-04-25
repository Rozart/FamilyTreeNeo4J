package pl.rozart.familytree.dto;

import pl.rozart.familytree.models.Person;
import pl.rozart.familytree.models.Relationship;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by rozar_000 on 2015-04-25.
 */
public class RelationshipDTO {

    private Long id;

    private Set<PersonDTO> partners = new HashSet<>();

    public RelationshipDTO() {
    }

    public RelationshipDTO(Relationship relationship) {
        this.id = relationship.getId();
        for(Person person : relationship.getPartners()){
            this.partners.add(new PersonDTO(person));
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<PersonDTO> getPartners() {
        return partners;
    }

    public void setPartners(Set<PersonDTO> partners) {
        this.partners = partners;
    }
}
