package lk.ijse.jobportal.repository;

import lk.ijse.jobportal.entity.ApplyJob;
import lk.ijse.jobportal.entity.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface ApplyJobRepository extends JpaRepository<ApplyJob,Long> {

    @Query(value = " select * from ApplyJob ORDER BY aid DESC LIMIT 1",nativeQuery = true)
    ApplyJob getJob();
}
