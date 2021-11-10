package nl.koenm.chiefcount.controller;

import nl.koenm.chiefcount.dto.request.AuthenticationRequest;
import nl.koenm.chiefcount.dto.response.AuthenticationResponse;
import nl.koenm.chiefcount.model.ApplicationUser;
import nl.koenm.chiefcount.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthenticationController {

    AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) {

        AuthenticationResponse authenticationResponse = authenticationService.authenticateUser(authenticationRequest);

        return ResponseEntity.ok(authenticationResponse);
    }

    @GetMapping("/user-role/{username}")
    public ResponseEntity<Object> getAttemptedLoginUserRole(@PathVariable String username){

        ApplicationUser user = authenticationService.findUserById(username);

        return ResponseEntity.ok(user);

    }
}
