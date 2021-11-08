package nl.koenm.chiefcount.repository;

import nl.koenm.chiefcount.model.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<ApplicationUser, Long> {
}
