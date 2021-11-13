package nl.koenm.chiefcount.controller;

import nl.koenm.chiefcount.model.ApplicationUser;
import nl.koenm.chiefcount.service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/increase/plus-minus/{username}")
    public ResponseEntity<Object> increasePlusMinusByUsername(@PathVariable String username){
        teacherService.increasePlusMinusByUsername(username);

        return ResponseEntity.ok("Succes!");
    }

    @PostMapping("/increase/multiply/{username}")
    public ResponseEntity<Object> increaseMultiplyByUsername(@PathVariable String username){
        teacherService.increaseMultiplyByUsername(username);

        return ResponseEntity.ok("Succes!");
    }

    @PostMapping("/increase/divide/{username}")
    public ResponseEntity<Object> increaseDivideByUsername(@PathVariable String username){
        teacherService.increaseDivideByUsername(username);

        return ResponseEntity.ok("Succes!");
    }

    @PostMapping("/decrease/plus-minus/{username}")
    public ResponseEntity<Object> decreasePlusMinusByUsername(@PathVariable String username){
        teacherService.decreasePlusMinusByUsername(username);

        return ResponseEntity.ok("Succes!");
    }

    @PostMapping("/decrease/multiply/{username}")
    public ResponseEntity<Object> decreaseMultiplyByUsername(@PathVariable String username){
        teacherService.decreaseMultiplyByUsername(username);

        return ResponseEntity.ok("Succes!");
    }

    @PostMapping("/decrease/divide/{username}")
    public ResponseEntity<Object> decreaseDivideByUsername(@PathVariable String username){
        teacherService.decreaseDivideByUsername(username);

        return ResponseEntity.ok("Succes!");
    }

}



