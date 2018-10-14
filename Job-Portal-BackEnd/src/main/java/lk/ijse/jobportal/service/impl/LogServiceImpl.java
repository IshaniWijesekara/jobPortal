package lk.ijse.jobportal.service.impl;

import lk.ijse.jobportal.dto.AdminDTO;
import lk.ijse.jobportal.dto.JobPosterDTO;
import lk.ijse.jobportal.dto.LoginDTO;
import lk.ijse.jobportal.dto.UserDTO;
import lk.ijse.jobportal.entity.Admin;
import lk.ijse.jobportal.entity.JobPoster;
import lk.ijse.jobportal.entity.User;
import lk.ijse.jobportal.repository.AdminRepository;
import lk.ijse.jobportal.repository.JobPosterReposistory;
import lk.ijse.jobportal.repository.UserRepository;
import lk.ijse.jobportal.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class LogServiceImpl implements LogService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JobPosterReposistory jobPosterReposistory;

    @Autowired
    private AdminRepository adminRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public LoginDTO getLoginUser(String useName, String Pasword) {
        System.out.println(adminRepository.existsById(useName));
        LoginDTO loginDTO=null;
        JobPosterDTO jobPosterDTO=null;
        UserDTO userDTO=null;
        AdminDTO adminDTO=null;
        if (userRepository.existsById(useName)){
            User user = userRepository.findById(useName).get();
            if (user.getPassword().equals(Pasword)) {
                userDTO = new UserDTO();
                userDTO.setUsername(user.getUsername());
                userDTO.setEmail(user.getEmail());
                userDTO.setPassword(user.getPassword());
            }
        }else if(adminRepository.existsById(useName)) {
                Admin admin = adminRepository.findById(useName).get();
                System.out.println(admin.getPassword().equals(Pasword));
                if (admin.getPassword().equals(Pasword)) {
                    adminDTO = new AdminDTO();
                    System.out.println(admin.getUserName());
                    adminDTO.setUsername(admin.getUserName());
                    adminDTO.setEmail(admin.getEmail());
                    adminDTO.setPassword(admin.getPassword());
                }



            } else if (jobPosterReposistory.existsById(useName)){
            JobPoster jobPoster = jobPosterReposistory.findById(useName).get();
            if(jobPoster.getPassword().equals(Pasword)) {
                jobPosterDTO = new JobPosterDTO();
                jobPosterDTO.setUsername(jobPoster.getUsername());
                jobPosterDTO.setCompanyname(jobPoster.getCompanyname());
                jobPosterDTO.setEmail(jobPoster.getEmail());
                jobPosterDTO.setPassword(jobPoster.getPassword());
            }
            }
        loginDTO=new LoginDTO();
        loginDTO.setUser(userDTO);
        loginDTO.setJobPosterDTO(jobPosterDTO);
        loginDTO.setAdminDTO(adminDTO);

        return  loginDTO;
    }
}
