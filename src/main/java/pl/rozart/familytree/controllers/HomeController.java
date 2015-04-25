package pl.rozart.familytree.controllers;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import pl.rozart.familytree.dto.PersonDTO;
import pl.rozart.familytree.dto.RelationshipDTO;
import pl.rozart.familytree.forms.PersonForm;
import pl.rozart.familytree.forms.RelationshipForm;
import pl.rozart.familytree.models.Person;
import pl.rozart.familytree.models.Relationship;
import pl.rozart.familytree.services.FamilyTreeService;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by rozar_000 on 2015-04-19.
 */
@Controller
public class HomeController {

    @Resource
    private FamilyTreeService familyTreeService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setAutoGrowNestedPaths(false);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping("/")
    public String index(Model model) {
        List<PersonDTO> persons = getFamilyTreeService().getPersonDTOs();
        model.addAttribute("persons", persons);
        List<RelationshipDTO> relationships = getFamilyTreeService().getRelationshipDTOs();
        model.addAttribute("relationships", relationships);
        model.addAttribute("personForm", new PersonForm());
        model.addAttribute("relationshipForm", new RelationshipForm());
        return "index";
    }

    @RequestMapping(value = "/addPerson", method = RequestMethod.POST)
    public String addPerson(@ModelAttribute(value = "personForm") PersonForm personForm){
        getFamilyTreeService().addPerson(personForm);
        return "redirect:/";
    }

    @RequestMapping(value = "/addRelationship", method = RequestMethod.POST)
    public String addRelationship(@ModelAttribute(value = "relationshipForm") RelationshipForm relationshipForm){
        getFamilyTreeService().addRelationship(relationshipForm);
        return "redirect:/";
    }

    public FamilyTreeService getFamilyTreeService() {
        return familyTreeService;
    }



}
