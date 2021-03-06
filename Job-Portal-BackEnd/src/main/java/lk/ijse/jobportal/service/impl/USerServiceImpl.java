package lk.ijse.jobportal.service.impl;

import lk.ijse.jobportal.dto.UserDTO;
import lk.ijse.jobportal.entity.JobPoster;
import lk.ijse.jobportal.entity.User;
import lk.ijse.jobportal.repository.JobPosterReposistory;
import lk.ijse.jobportal.repository.UserRepository;
import lk.ijse.jobportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class USerServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JobPosterReposistory jobPosterReposistory;
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean addUser(UserDTO userDTO) {
        User user=new User(userDTO.getUsername(),userDTO.getEmail(),userDTO.getPassword());
        userRepository.save(user);
        return true;
    }

    @Override
    public boolean login(String username, String pasword) {
        boolean exists = userRepository.existsById(username);

        if (!exists){
            jobPosterReposistory.existsById(username);
            JobPoster jobPoster = jobPosterReposistory.findById(username).get();
            System.out.println("not Exsist");
            return jobPoster.getPassword().equals(pasword);

        }

        User user = userRepository.findById(username).get();
        return user.getPassword().equals(pasword);


    }


}
