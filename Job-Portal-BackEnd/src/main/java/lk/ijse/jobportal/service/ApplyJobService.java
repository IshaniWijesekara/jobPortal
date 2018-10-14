package lk.ijse.jobportal.service;

import lk.ijse.jobportal.dto.ApplyJobDTO;
import lk.ijse.jobportal.dto.ApplyJobMainDTO;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

public interface ApplyJobService {
    public boolean applyJob(ApplyJobMainDTO applyJobMainDTO);

    public ApplyJobDTO getLastData();

    public ArrayList<ApplyJobMainDTO> getApplyJob(String userName);

    public ApplyJobMainDTO searcJob(Long id);

    public ArrayList<ApplyJobMainDTO> getSeekerApplyJob(String userName);


}
