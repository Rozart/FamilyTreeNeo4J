package pl.rozart.familytree.services.impl;

import org.neo4j.helpers.collection.IteratorUtil;
import org.springframework.stereotype.Service;
import pl.rozart.familytree.dao.PersonRepository;
import pl.rozart.familytree.dao.RelationshipRepository;
import pl.rozart.familytree.dto.PersonDTO;
import pl.rozart.familytree.dto.RelationshipDTO;
import pl.rozart.familytree.forms.PersonForm;
import pl.rozart.familytree.forms.RelationshipForm;
import pl.rozart.familytree.models.Person;
import pl.rozart.familytree.models.Relationship;
import pl.rozart.familytree.services.FamilyTreeService;

import javax.annotation.Resource;
import javax.management.relation.Relation;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by rozar_000 on 2015-04-20.
 */
@Service
public class FamilyTreeServiceImpl implements FamilyTreeService {

    @Resource
    private PersonRepository personRepository;

    @Resource
    private RelationshipRepository relationshipRepository;

    @Override
    public PersonDTO getPersonDTOById(Long idPerson){
        return new PersonDTO(personRepository.findOne(idPerson));
    }

    @Override
    public List<PersonDTO> getPersonDTOs(){
        List<PersonDTO> personDTOs = new ArrayList<>();
        List<Person> persons = IteratorUtil.asList(getPersonRepository().findAll());
        for(Person person : persons){
            personDTOs.add(new PersonDTO(person));
        }
        return personDTOs;
    }

    @Override
    public List<RelationshipDTO> getRelationshipDTOs() {
        List<RelationshipDTO> relationshipDTOs = new ArrayList<>();
        List<Relationship> relationships = IteratorUtil.asList(getRelationshipRepository().findAll());
        for(Relationship relationship : relationships){
            relationshipDTOs.add(new RelationshipDTO(relationship));
        }
        return relationshipDTOs;
    }

    @Override
    public void addPerson(PersonForm personForm) {
        Person person = new Person();
        person.setName(personForm.getName());
        person.setSex(personForm.getSex());
        person.setBirthDate(personForm.getBirthDate());
        person.setDeathDate(personForm.getDeathDate());

        if(personForm.getParentsRelationshipId() != null) {
            Relationship parentsRelationship = getRelationshipRepository().findOne(personForm.getParentsRelationshipId());
            person.setChildOf(parentsRelationship);
            for(Person partner : parentsRelationship.getPartners()){
                partner.getChildren().add(person);
            }
        }

        getPersonRepository().save(person);
    }

    @Override
    public void addRelationship(RelationshipForm relationshipForm) {
        Person person = getPersonRepository().findOne(relationshipForm.getPersonId());
        Person partner = getPersonRepository().findOne(relationshipForm.getPartnerId());

        Relationship relationship = new Relationship();
        if (person != null && person.getRelationships() != null) {
            relationship.getPartners().add(person);
            person.getRelationships().add(relationship);
        }
        if (partner != null && partner.getRelationships() != null) {
            relationship.getPartners().add(partner);
            partner.getRelationships().add(relationship);
        }
        getRelationshipRepository().save(relationship);
        getPersonRepository().save(person);
        getPersonRepository().save(partner);
    }



    public PersonRepository getPersonRepository() {
        return personRepository;
    }

    public RelationshipRepository getRelationshipRepository() {
        return relationshipRepository;
    }

}
