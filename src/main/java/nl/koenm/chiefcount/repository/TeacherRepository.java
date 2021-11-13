package nl.koenm.chiefcount.repository;

import nl.koenm.chiefcount.model.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherRepository extends JpaRepository<ApplicationUser, String> {

    List<ApplicationUser> findByisStudentTrue();

}
