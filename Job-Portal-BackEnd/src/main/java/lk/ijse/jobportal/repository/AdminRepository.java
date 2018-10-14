package lk.ijse.jobportal.repository;

import lk.ijse.jobportal.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,String> {
}
