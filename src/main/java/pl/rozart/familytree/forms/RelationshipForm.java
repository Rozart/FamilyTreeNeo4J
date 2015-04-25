package pl.rozart.familytree.forms;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rozar_000 on 2015-04-25.
 */
public class RelationshipForm {

    private Long personId;
    private Long partnerId;

    public RelationshipForm(){

    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Long getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }
}
