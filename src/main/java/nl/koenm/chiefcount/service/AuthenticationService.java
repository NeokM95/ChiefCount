package nl.koenm.chiefcount.service;

import nl.koenm.chiefcount.dto.request.AuthenticationRequest;
import nl.koenm.chiefcount.dto.response.AuthenticationResponse;
import nl.koenm.chiefcount.model.ApplicationUser;
import nl.koenm.chiefcount.repository.AuthenticationRepository;
import nl.koenm.chiefcount.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final AuthenticationRepository authenticationRepository;
    final JwtUtil jwtUtl;

    @Autowired
    public AuthenticationService(AuthenticationManager authenticationManager, UserDetailsService userDetailsService, AuthenticationRepository authenticationRepository, JwtUtil jwtUtl) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.authenticationRepository = authenticationRepository;
        this.jwtUtl = jwtUtl;
    }

    public AuthenticationResponse authenticateUser(AuthenticationRequest authenticationRequest) {

        String username = authenticationRequest.getUsername();
        String password = authenticationRequest.getPassword();

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );
        } catch (BadCredentialsException ex) {
            throw new UsernameNotFoundException("Incorrect username or password");
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        final String jwt = jwtUtl.generateToken(userDetails);

        return new AuthenticationResponse(jwt);
    }

    public ApplicationUser findUserById(String username) {

        if (!authenticationRepository.existsById(username)) {
            throw new RuntimeException("User does not exist");
        }
        return authenticationRepository.findById(username).orElse(null);


    }
}
