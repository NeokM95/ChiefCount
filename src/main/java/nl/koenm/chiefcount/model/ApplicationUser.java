package nl.koenm.chiefcount.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ApplicationUser {

    @Id
    private Long id;

    private String firstName;
    private String lastName;

    private String email;

    private String username;
    private String password;

}
