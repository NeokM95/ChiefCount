package nl.koenm.chiefcount.controller;

import nl.koenm.chiefcount.model.ApplicationUser;
import nl.koenm.chiefcount.service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }


    @GetMapping("/greet")
    public ResponseEntity<Object> greetTeacher() {
        return ResponseEntity.ok("Hi Teacher");
    }

    @GetMapping("/view/students")
    public List<ApplicationUser> getAllStudents() {
        return teacherService.getAllStudents();
    }

}



