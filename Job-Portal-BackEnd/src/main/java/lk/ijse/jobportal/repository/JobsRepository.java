package lk.ijse.jobportal.repository;

import lk.ijse.jobportal.entity.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobsRepository extends JpaRepository<Jobs,Long> {

    @Query("SELECT count(j.id) FROM Jobs j")
    long getTotalCustomers();

}
