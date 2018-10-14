package lk.ijse.jobportal.repository;

import lk.ijse.jobportal.entity.BusinessFuntion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.security.acl.LastOwnerException;

public interface BusinessFuntionRepository extends JpaRepository<BusinessFuntion,Long> {
}
