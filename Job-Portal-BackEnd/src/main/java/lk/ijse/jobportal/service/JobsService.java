package lk.ijse.jobportal.service;

import lk.ijse.jobportal.dto.JobsDTO;
import lk.ijse.jobportal.dto.PostJobDTO;
import lk.ijse.jobportal.entity.JobPoster;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

public interface JobsService {

    public boolean addJob(PostJobDTO postJobDTO);

    public ArrayList<JobsDTO> getAllJObs();

    public ArrayList<PostJobDTO> getAllPostJobs();

    public ArrayList<PostJobDTO> getPosterPostedJobs(String username);

    public boolean uploadImage(MultipartFile file);

    public PostJobDTO searchJob(Long id);

    public boolean deleteJob(Long id);

    public boolean updateJob(PostJobDTO postJobDTO);

    public long getTotalJobs();

    public ArrayList<PostJobDTO> SeachJob(String categoryName);
}
