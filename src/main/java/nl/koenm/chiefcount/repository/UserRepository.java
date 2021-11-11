package nl.koenm.chiefcount.repository;

import nl.koenm.chiefcount.model.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<ApplicationUser, String> {
}
