package pl.rozart.familytree.services;

import pl.rozart.familytree.dto.PersonDTO;
import pl.rozart.familytree.dto.RelationshipDTO;
import pl.rozart.familytree.forms.PersonForm;
import pl.rozart.familytree.forms.RelationshipForm;
import pl.rozart.familytree.models.Person;
import pl.rozart.familytree.models.Relationship;

import java.util.Date;
import java.util.List;

/**
 * Created by rozar_000 on 2015-04-20.
 */
public interface FamilyTreeService {

    PersonDTO getPersonDTOById(Long idPerson);

    List<PersonDTO> getPersonDTOs();

    List<RelationshipDTO> getRelationshipDTOs();

    void addPerson(PersonForm personForm);

    void addRelationship(RelationshipForm relationshipForm);

}
