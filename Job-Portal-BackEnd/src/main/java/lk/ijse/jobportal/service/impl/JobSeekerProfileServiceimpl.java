package lk.ijse.jobportal.service.impl;

import lk.ijse.jobportal.dto.JobSeekerProfileDTO;
import lk.ijse.jobportal.dto.UserDTO;
import lk.ijse.jobportal.entity.JobSeeker;
import lk.ijse.jobportal.entity.User;
import lk.ijse.jobportal.repository.JObSeekerRepository;
import lk.ijse.jobportal.service.JobSekerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class JobSeekerProfileServiceimpl implements JobSekerProfileService{
    @Autowired
    private JObSeekerRepository jobSeekerRepository;

    private String imagePath;

    private String CVPath;
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean saveSeekerDetails(JobSeekerProfileDTO jobSeekerProfileDTO) {
        User user=new User(jobSeekerProfileDTO.getUserDTO().getUsername(),
                jobSeekerProfileDTO.getUserDTO().getEmail(),
                jobSeekerProfileDTO.getUserDTO().getPassword());

        JobSeeker jobSeeker=new JobSeeker();
        jobSeeker.setId(jobSeekerProfileDTO.getId());
        jobSeeker.setFirstName(jobSeekerProfileDTO.getFirstName());
        jobSeeker.setLastName(jobSeekerProfileDTO.getLastName());
        jobSeeker.setInterstIn(jobSeekerProfileDTO.getInterstIn());
        jobSeeker.setEmailAddress(jobSeekerProfileDTO.getEmailAddress());
        jobSeeker.setAddress(jobSeekerProfileDTO.getAddress());
        jobSeeker.setProvince(jobSeekerProfileDTO.getProvince());
        jobSeeker.setCity(jobSeekerProfileDTO.getCity());
        jobSeeker.setBirthDay(jobSeekerProfileDTO.getBirthDay());
        jobSeeker.setPhoneNumber(jobSeekerProfileDTO.getPhoneNumber());
        jobSeeker.setHighestEducation(jobSeekerProfileDTO.getHighestEducation());
        jobSeeker.setStream(jobSeekerProfileDTO.getStream());
        jobSeeker.setImagePath(imagePath);
        jobSeeker.setCvPath(CVPath);
        jobSeeker.setUser(user);

        jobSeekerRepository.save(jobSeeker);
        return true;
    }

    @Override
    public boolean uploadImage(MultipartFile file) {
        if (!file.getOriginalFilename().isEmpty()) {
            BufferedOutputStream outputStream = null;
            try {

                outputStream = new BufferedOutputStream(
                        new FileOutputStream(
                                new File("E:/Server Images", file.getOriginalFilename())));
                imagePath = "http://localhost:8080/api/v1/profile/file?file=E:/Server Images/" + file.getOriginalFilename();
                outputStream.write(file.getBytes());
                outputStream.flush();
                outputStream.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    @Override
    public boolean uploadCV(MultipartFile file) {
        if (!file.getOriginalFilename().isEmpty()) {
            BufferedOutputStream outputStream = null;
            try {

                outputStream = new BufferedOutputStream(
                        new FileOutputStream(
                                new File("E:/Server Images/CV", file.getOriginalFilename())));
                CVPath = "http://localhost:8080/api/v1/profile/file?file=E:/Server Images/CV" + file.getOriginalFilename();
                outputStream.write(file.getBytes());
                outputStream.flush();
                outputStream.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    @Override
    public JobSeekerProfileDTO searchSeeker(String userName) {
        ArrayList<JobSeeker> aLlJobSeeker = jobSeekerRepository.getALlJobSeeker();

        JobSeekerProfileDTO jobSeekerProfileDTO=null;
        for (JobSeeker jobSeeker:aLlJobSeeker
             ) {
            if (jobSeeker.getUser().getUsername().equals(userName)){
                User user=jobSeeker.getUser();
                UserDTO userDTO=new UserDTO(
                        user.getUsername(),user.getEmail(),user.getPassword());
                System.out.println(jobSeeker.getBirthDay());
                jobSeekerProfileDTO=new JobSeekerProfileDTO();
                jobSeekerProfileDTO.setId(jobSeeker.getId());
                jobSeekerProfileDTO.setFirstName(jobSeeker.getFirstName());
                jobSeekerProfileDTO.setLastName(jobSeeker.getLastName());
                jobSeekerProfileDTO.setInterstIn(jobSeeker.getInterstIn());
                jobSeekerProfileDTO.setEmailAddress(jobSeeker.getEmailAddress());
                jobSeekerProfileDTO.setAddress(jobSeeker.getAddress());
                jobSeekerProfileDTO.setProvince(jobSeeker.getProvince());
                jobSeekerProfileDTO.setCity(jobSeeker.getCity());
                jobSeekerProfileDTO.setBirthDay(jobSeeker.getBirthDay());
                jobSeekerProfileDTO.setPhoneNumber(jobSeeker.getPhoneNumber());
                jobSeekerProfileDTO.setHighestEducation(jobSeeker.getHighestEducation());
                jobSeekerProfileDTO.setStream(jobSeeker.getStream());
                jobSeekerProfileDTO.setImagePath(imagePath);
                jobSeekerProfileDTO.setCvPath(CVPath);
                jobSeekerProfileDTO.setUserDTO(userDTO);
                System.out.println(jobSeekerProfileDTO.getAddress());

            }
        }
        return jobSeekerProfileDTO;
    }

    @Override
    public ResponseEntity<InputStreamResource> downloadCV(String path) {
        String FILE_PATH=path;
        File file = new File(FILE_PATH);
        InputStreamResource resource = null;
        try {
            resource = new InputStreamResource(new FileInputStream(file));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment;filename=" + file.getName())
                .contentType(MediaType.APPLICATION_PDF).contentLength(file.length())
                .body(resource);

    }

    @Override
    public ArrayList<JobSeekerProfileDTO> getAllJobSeeker() {
        ArrayList<JobSeeker> aLlJobSeeker = jobSeekerRepository.getALlJobSeeker();
        ArrayList<JobSeekerProfileDTO> allJobSeekers=new ArrayList<>();

        for (JobSeeker jobSeeker:aLlJobSeeker
             ) {
            User user=jobSeeker.getUser();
            UserDTO userDTO=new UserDTO(user.getUsername(),user.getEmail(),user.getPassword());

            JobSeekerProfileDTO jobSeekerProfileDTO=new JobSeekerProfileDTO(
                    jobSeeker.getId(),
                    jobSeeker.getFirstName(),
                    jobSeeker.getLastName(),
                    jobSeeker.getInterstIn(),
                    jobSeeker.getEmailAddress(),
                    jobSeeker.getAddress(),
                    jobSeeker.getProvince(),
                    jobSeeker.getCity(),
                    jobSeeker.getBirthDay(),
                    jobSeeker.getPhoneNumber(),
                    jobSeeker.getHighestEducation(),
                    jobSeeker.getStream(),
                    jobSeeker.getImagePath(),
                    jobSeeker.getCvPath(),
                    userDTO
            );
            allJobSeekers.add(jobSeekerProfileDTO);
        }
        return  allJobSeekers;
    }
}
