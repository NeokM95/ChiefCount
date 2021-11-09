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
        try {
            String encryptedPassword = passwordEncoder.encode(createAdmin.getPassword());

            ApplicationUser user = new ApplicationUser();
            user.setUsername(createAdmin.getUsername());
            user.setPassword(encryptedPassword);
            user.setEmail(createAdmin.getEmail());
            user.setEnabled(true);
//            user.addAuthority("ROLE_STUDENT");
//            user.addAuthority("ROLE_TEACHER");
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
        try {
            String encryptedPassword = passwordEncoder.encode(createTeacher.getPassword());

            ApplicationUser user = new ApplicationUser();
            user.setUsername(createTeacher.getUsername());
            user.setPassword(encryptedPassword);
            user.setEmail(createTeacher.getEmail());
            user.setEnabled(true);
//            user.addAuthority("ROLE_STUDENT");
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
}
