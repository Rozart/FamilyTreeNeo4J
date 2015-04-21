package pl.rozart.familytree.controllers;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import pl.rozart.familytree.forms.PersonForm;
import pl.rozart.familytree.models.Person;
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
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping("/")
    public String index(Model model) {
        List<Person> persons = getFamilyTreeService().getPersons();
        model.addAttribute("persons", persons);
        model.addAttribute("personForm", new PersonForm());
        return "index";
    }

    @RequestMapping(value = "/addPerson", method = RequestMethod.POST)
    public String addPerson(@ModelAttribute(value = "personForm") PersonForm personForm, Model model){
        Person person = new Person(personForm);
        getFamilyTreeService().addPerson(person);
        return "redirect:/";
    }

    public FamilyTreeService getFamilyTreeService() {
        return familyTreeService;
    }



}
