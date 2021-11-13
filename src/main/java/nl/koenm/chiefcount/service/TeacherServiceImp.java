package nl.koenm.chiefcount.service;

import nl.koenm.chiefcount.model.ApplicationUser;
import nl.koenm.chiefcount.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImp implements TeacherService {

    private final TeacherRepository teacherRepository;



    public TeacherServiceImp(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<ApplicationUser> getAllStudents() {

        return teacherRepository.findByisStudentTrue();

    }
}
