package nl.koenm.chiefcount.service;

import nl.koenm.chiefcount.model.ApplicationUser;
import nl.koenm.chiefcount.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public void increasePlusMinusByUsername(String username) {

        Optional<ApplicationUser> optionalUser = teacherRepository.findById(username);

        if (optionalUser.isPresent()) {
            ApplicationUser currentUser = optionalUser.get();
            int currentLevel = currentUser.getPlusMinus();

            if (currentLevel < 3) {
                currentUser.setPlusMinus(currentLevel + 1);
                teacherRepository.save(currentUser);
            } else {
                throw new RuntimeException("Level can't exceed level 3!");
            }

        } else {
            throw new RuntimeException(username + " does not exist");
        }

    }

    @Override
    public void increaseMultiplyByUsername(String username) {

        Optional<ApplicationUser> optionalUser = teacherRepository.findById(username);

        if (optionalUser.isPresent()) {
            ApplicationUser currentUser = optionalUser.get();
            int currentLevel = currentUser.getMultiply();;

            if (currentLevel < 3) {
                currentUser.setMultiply(currentLevel + 1);
                teacherRepository.save(currentUser);
            } else {
                throw new RuntimeException("Level can't exceed level 3!");
            }

        } else {
            throw new RuntimeException(username + " does not exist");
        }

    }

    @Override
    public void increaseDivideByUsername(String username) {

        Optional<ApplicationUser> optionalUser = teacherRepository.findById(username);

        if (optionalUser.isPresent()) {
            ApplicationUser currentUser = optionalUser.get();
            int currentLevel = currentUser.getDivide();

            if (currentLevel < 3) {
                currentUser.setDivide(currentLevel + 1);
                teacherRepository.save(currentUser);
            } else {
                throw new RuntimeException("Level can't exceed level 3!");
            }

        } else {
            throw new RuntimeException(username + " does not exist");
        }

    }

    @Override
    public void decreasePlusMinusByUsername(String username) {

        Optional<ApplicationUser> optionalUser = teacherRepository.findById(username);

        if (optionalUser.isPresent()) {
            ApplicationUser currentUser = optionalUser.get();
            int currentLevel = currentUser.getPlusMinus();

            if (currentLevel > 1) {
                currentUser.setPlusMinus(currentLevel - 1);
                teacherRepository.save(currentUser);
            } else {
                throw new RuntimeException("Level can't lower level 1!");
            }

        } else {
            throw new RuntimeException(username + " does not exist");
        }

    }

    @Override
    public void decreaseMultiplyByUsername(String username) {

        Optional<ApplicationUser> optionalUser = teacherRepository.findById(username);

        if (optionalUser.isPresent()) {
            ApplicationUser currentUser = optionalUser.get();
            int currentLevel = currentUser.getMultiply();

            if (currentLevel > 1) {
                currentUser.setMultiply(currentLevel - 1);
                teacherRepository.save(currentUser);
            } else {
                throw new RuntimeException("Level can't lower level 1!");
            }

        } else {
            throw new RuntimeException(username + " does not exist");
        }

    }

    @Override
    public void decreaseDivideByUsername(String username) {

        Optional<ApplicationUser> optionalUser = teacherRepository.findById(username);

        if (optionalUser.isPresent()) {
            ApplicationUser currentUser = optionalUser.get();
            int currentLevel = currentUser.getDivide();

            if (currentLevel > 1) {
                currentUser.setDivide(currentLevel - 1);
                teacherRepository.save(currentUser);
            } else {
                throw new RuntimeException("Level can't lower level 1!");
            }

        } else {
            throw new RuntimeException(username + " does not exist");
        }

    }
}
