package nl.koenm.chiefcount.service;

import nl.koenm.chiefcount.dto.request.CreateAppUserRequest;
import nl.koenm.chiefcount.model.ApplicationUser;

import java.util.List;

public interface AdminService {


    String createAdmin(CreateAppUserRequest createAdmin);

    String createTeacher(CreateAppUserRequest createTeacher);

    String createStudent(CreateAppUserRequest createStudent);

    List<ApplicationUser> getAllUsers();
}
