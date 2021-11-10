package nl.koenm.chiefcount.service;

import nl.koenm.chiefcount.dto.request.CreateAppUserRequest;
import nl.koenm.chiefcount.model.ApplicationUser;
import nl.koenm.chiefcount.repository.AdminRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImp implements AdminService{

    private final AdminRepository adminRepository;
    PasswordEncoder passwordEncoder;

    public AdminServiceImp(AdminRepository adminRepository, PasswordEncoder passwordEncoder) {
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String createAdmin(CreateAppUserRequest createAdmin) {

        if(adminRepository.existsByEmail(createAdmin.getEmail())){
            throw new RuntimeException(createAdmin.getEmail() + " Already in use!");
        }

        if (adminRepository.existsById(createAdmin.getUsername())){
            throw new RuntimeException(createAdmin.getUsername() + " Already in use!");
        }

        if(isValidPassword(createAdmin.getPassword())){
            throw new RuntimeException("Geen sterk wachtwoord");
        }

        try {
            String encryptedPassword = passwordEncoder.encode(createAdmin.getPassword());

            ApplicationUser user = new ApplicationUser();
            user.setUsername(createAdmin.getUsername());
            user.setPassword(encryptedPassword);
            user.setEmail(createAdmin.getEmail());
            user.setEnabled(true);
            user.addAuthority("ROLE_ADMIN");

            ApplicationUser newUser = adminRepository.save(user);
            return newUser.getUsername();

        }
        catch (Exception ex) {
            throw new RuntimeException("Cannot create Admin.");
        }
    }

    @Override
    public String createTeacher(CreateAppUserRequest createTeacher) {

        if(adminRepository.existsByEmail(createTeacher.getEmail())){
            throw new RuntimeException(createTeacher.getEmail() + " Already in use!");
        }

        if (adminRepository.existsById(createTeacher.getUsername())){
            throw new RuntimeException(createTeacher.getUsername() + " Already in use!");
        }

        if(isValidPassword(createTeacher.getPassword())){
            throw new RuntimeException("Geen sterk wachtwoord");
        }

        try {
            String encryptedPassword = passwordEncoder.encode(createTeacher.getPassword());

            ApplicationUser user = new ApplicationUser();
            user.setUsername(createTeacher.getUsername());
            user.setPassword(encryptedPassword);
            user.setEmail(createTeacher.getEmail());
            user.setEnabled(true);
            user.addAuthority("ROLE_TEACHER");

            ApplicationUser newUser = adminRepository.save(user);
            return newUser.getUsername();
        }
        catch (Exception ex) {
            throw new RuntimeException("Cannot create Teacher.");
        }
    }

    @Override
    public String createStudent(CreateAppUserRequest createStudent) {
        try {
            String encryptedPassword = passwordEncoder.encode(createStudent.getPassword());

            ApplicationUser user = new ApplicationUser();
            user.setUsername(createStudent.getUsername());
            user.setPassword(encryptedPassword);
            user.setEmail(createStudent.getEmail());
            user.setEnabled(true);
            user.addAuthority("ROLE_STUDENT");

            ApplicationUser newUser = adminRepository.save(user);
            return newUser.getUsername();
        }
        catch (Exception ex) {
            throw new RuntimeException("Cannot create Student.");
        }
    }

    @Override
    public List<ApplicationUser> getAllUsers() {
        try {
            return adminRepository.findAll();
        }
        catch (Exception ex) {
            throw new RuntimeException("Cannot create list.");
        }
    }

    private boolean isValidPassword(String password) {
        final int MIN_LENGTH = 8;
        final int MIN_DIGITS = 1;
        final int MIN_LOWER = 1;
        final int MIN_UPPER = 1;
        final int MIN_SPECIAL = 1;
        final String SPECIAL_CHARS = "@#$%&*!()+=-_";

        long countDigit = password.chars().filter(ch -> ch >= '0' && ch <= '9').count();
        long countLower = password.chars().filter(ch -> ch >= 'a' && ch <= 'z').count();
        long countUpper = password.chars().filter(ch -> ch >= 'A' && ch <= 'Z').count();
        long countSpecial = password.chars().filter(ch -> SPECIAL_CHARS.indexOf(ch) >= 0).count();

        boolean validPassword = true;
        if (password.length() < MIN_LENGTH) validPassword = false;
        if (countLower < MIN_LOWER) validPassword = false;
        if (countUpper < MIN_UPPER) validPassword = false;
        if (countDigit < MIN_DIGITS) validPassword = false;
        if (countSpecial < MIN_SPECIAL) validPassword = false;

        return !validPassword;
    }
}
