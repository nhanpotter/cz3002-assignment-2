package org.apache.struts.login.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts.login.model.Person;
import org.apache.struts.login.service.LoginService;

/**
 * Controller to handle actions related to login
 */
public class LoginAction extends ActionSupport {
    private Person person;

    public String execute() throws Exception {
        if (person == null) {
            return INPUT;
        }

        try {
            LoginService service = new LoginService();
            if (service.authenticate(person)) {
                return SUCCESS;
            }
        } catch (Exception e) {
            e.printStackTrace();
            addActionError("Cannot connect to database");
            return INPUT;
        }

        addActionError("Wrong username or password");
        return INPUT;
    }

    public void validate() {
        if (person == null) {
            return;
        }
        if (person.getUsername().length() == 0) {
            addFieldError("person.username", "Username is required.");
        }
        if (person.getPassword().length() == 0) {
            addFieldError("person.password", "Password is required.");
        }
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
