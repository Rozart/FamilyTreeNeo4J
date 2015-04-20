package pl.rozart.familytree.controllers;

import org.neo4j.helpers.collection.IteratorUtil;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import pl.rozart.familytree.dao.PersonRepository;
import pl.rozart.familytree.models.Person;
import pl.rozart.familytree.services.FamilyTreeService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by rozar_000 on 2015-04-19.
 */
@RestController
public class HomeController {

    @Resource
    private FamilyTreeService familyTreeService;

    @RequestMapping("/")
    public ModelAndView index() {
        List<Person> persons = getFamilyTreeService().getPersons();
        return new ModelAndView("index", "persons", persons);
    }

    @RequestMapping(value = "/addPerson", method = RequestMethod.POST)
    public ModelAndView addPerson(@ModelAttribute Person person){
        getFamilyTreeService().addPerson(person);
        List<Person> persons = getFamilyTreeService().getPersons();
        return new ModelAndView("index", "persons", persons);
    }

    public FamilyTreeService getFamilyTreeService() {
        return familyTreeService;
    }



}
