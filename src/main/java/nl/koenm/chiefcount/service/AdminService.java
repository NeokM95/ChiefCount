package nl.koenm.chiefcount.service;

import nl.koenm.chiefcount.dto.request.CreateAppUserRequest;

public interface AdminService {


    String createAdmin(CreateAppUserRequest createAdmin);

    String createTeacher(CreateAppUserRequest createTeacher);

    String createStudent(CreateAppUserRequest createStudent);
}
