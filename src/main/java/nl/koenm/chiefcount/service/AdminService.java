package nl.koenm.chiefcount.service;

import nl.koenm.chiefcount.dto.request.CreateAppUserRequest;
import nl.koenm.chiefcount.exceptions.AlreadyInUseException;
import nl.koenm.chiefcount.exceptions.WeakPasswordException;
import nl.koenm.chiefcount.model.ApplicationUser;

import java.util.List;

public interface AdminService {


    String createAdmin(CreateAppUserRequest createAdmin) throws AlreadyInUseException, WeakPasswordException;

    String createTeacher(CreateAppUserRequest createTeacher) throws AlreadyInUseException, WeakPasswordException;

    String createStudent(CreateAppUserRequest createStudent);

    List<ApplicationUser> getAllUsers();
}
