package nl.koenm.chiefcount.controller;

import nl.koenm.chiefcount.dto.request.CreateAppUserRequest;
import nl.koenm.chiefcount.exceptions.AlreadyInUseException;
import nl.koenm.chiefcount.exceptions.WeakPasswordException;
import nl.koenm.chiefcount.model.ApplicationUser;
import nl.koenm.chiefcount.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/greet")
    public ResponseEntity<Object> greetAdmin(){
        return ResponseEntity.ok("Hi Admin");
    }

    @GetMapping("/view/all")
    public List<ApplicationUser> getAllUsers() {
        return adminService.getAllUsers();
    }

    @PostMapping("create/admin")
    public ResponseEntity<Object> createAdmin(
            @Valid
            @RequestBody CreateAppUserRequest createAdmin) throws AlreadyInUseException, WeakPasswordException {

        String newUsername = adminService.createAdmin(createAdmin);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{username}")
                .buildAndExpand(newUsername).toUri();

        return ResponseEntity.created(location).build();
    }


    @PostMapping("create/teacher")
    public ResponseEntity<Object> createTeacher(@RequestBody CreateAppUserRequest createTeacher) throws AlreadyInUseException, WeakPasswordException {

        String newUsername = adminService.createTeacher(createTeacher);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{username}")
                .buildAndExpand(newUsername).toUri();

        return ResponseEntity.created(location).build();
    }

    @PostMapping("create/student")
    public ResponseEntity<Object> createStudent(@RequestBody CreateAppUserRequest createStudent){

        String newUsername = adminService.createStudent(createStudent);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{username}")
                .buildAndExpand(newUsername).toUri();

        return ResponseEntity.created(location).build();
    }


}
