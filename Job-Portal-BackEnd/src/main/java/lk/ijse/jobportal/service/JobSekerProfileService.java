package lk.ijse.jobportal.service;

import lk.ijse.jobportal.dto.JobSeekerProfileDTO;
import lk.ijse.jobportal.entity.JobSeeker;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

public interface JobSekerProfileService {

    public boolean saveSeekerDetails(JobSeekerProfileDTO jobSeekerProfileDTO);

    public boolean uploadImage(MultipartFile file);

    public boolean uploadCV(MultipartFile file);

    public JobSeekerProfileDTO searchSeeker(String userName);

    public ResponseEntity<InputStreamResource> downloadCV(String path);

    public ArrayList<JobSeekerProfileDTO> getAllJobSeeker();

}
