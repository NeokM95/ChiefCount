package nl.koenm.chiefcount.service;

import nl.koenm.chiefcount.model.ApplicationUser;

import java.util.List;

public interface TeacherService {

    List<ApplicationUser> getAllStudents();

    void increasePlusMinusByUsername(String username);

    void increaseMultiplyByUsername(String username);

    void increaseDivideByUsername(String username);

    void decreasePlusMinusByUsername(String username);

    void decreaseMultiplyByUsername(String username);

    void decreaseDivideByUsername(String username);


}
