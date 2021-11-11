package nl.koenm.chiefcount.controller;

import nl.koenm.chiefcount.model.ApplicationUser;
import nl.koenm.chiefcount.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/view/{username}")
    public Optional<ApplicationUser> getOwnUserData(@PathVariable String username){

        return userService.getOwnUserData(username);

    }


}
