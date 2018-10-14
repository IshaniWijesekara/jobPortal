package lk.ijse.jobportal.repository;

import lk.ijse.jobportal.entity.Catagory;
import lk.ijse.jobportal.entity.Industry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface CatagoryRepository extends JpaRepository<Catagory,Long>{

    @Query(value = "SELECT * FROM Catagory",nativeQuery = true)
    ArrayList<Catagory> getAllCatagory();

}
