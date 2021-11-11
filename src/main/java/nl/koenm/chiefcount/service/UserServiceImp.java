package nl.koenm.chiefcount.service;

import nl.koenm.chiefcount.model.ApplicationUser;
import nl.koenm.chiefcount.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImp implements UserService{

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public Optional<ApplicationUser> getOwnUserData(String username) {

        // Get name of the requester
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        // Compare name of the requester with the name given in the url.
        if (currentPrincipalName.equals(username)){
            return userRepository.findById(username);
        } else {
            throw new RuntimeException("Your are not requesting your own data!");
        }

    }
}
