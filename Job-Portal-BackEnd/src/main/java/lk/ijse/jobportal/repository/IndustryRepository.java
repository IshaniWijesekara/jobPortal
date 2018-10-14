package lk.ijse.jobportal.repository;

import lk.ijse.jobportal.entity.Industry;
import lk.ijse.jobportal.entity.Qulifications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface IndustryRepository extends JpaRepository<Industry,Long> {

    @Query(value = "SELECT * FROM Industry",nativeQuery = true)
    ArrayList<Industry> getAllIndustry();
}
