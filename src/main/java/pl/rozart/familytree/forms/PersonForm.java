package pl.rozart.familytree.forms;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by rozar_000 on 2015-04-21.
 */
public class PersonForm {

    private String name;

    private String sex;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date deathDate;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
