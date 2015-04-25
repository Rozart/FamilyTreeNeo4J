package pl.rozart.familytree.dto;

import pl.rozart.familytree.models.Person;

import java.util.Date;

/**
 * Created by rozar_000 on 2015-04-25.
 */
public class PersonDTO {

    private Long id;
    private String name;
    private String sex;
    private Date birthDate;
    private Date deathDate;

    public PersonDTO() {
    }

    public PersonDTO(Person person){
        this.id = person.getId();
        this.name = person.getName();
        this.sex = person.getSex();
        this.birthDate = person.getBirthDate();
        this.deathDate = person.getDeathDate();
    }

    public PersonDTO(Long id, String name, String sex, Date birthDate, Date deathDate) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
    }

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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
}
