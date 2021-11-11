package nl.koenm.chiefcount.service;

import nl.koenm.chiefcount.model.ApplicationUser;

import java.util.Optional;

public interface UserService {

    Optional<ApplicationUser> getOwnUserData(String username);

}
