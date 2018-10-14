package lk.ijse.jobportal.service.impl;

import lk.ijse.jobportal.dto.AdminDTO;
import lk.ijse.jobportal.dto.AdminProfileDTO;
import lk.ijse.jobportal.entity.Admin;
import lk.ijse.jobportal.entity.AdminProfile;
import lk.ijse.jobportal.repository.AdminProfileRepository;
import lk.ijse.jobportal.service.AdminProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class AdminProfileServiceImpl implements AdminProfileService {
    private String imagePath;
    @Autowired
    private AdminProfileRepository adminProfileRepository;
    @Override
    public boolean saveAdminProfile(AdminProfileDTO adminProfileDTO) {
        AdminDTO adminDTO=adminProfileDTO.getAdmin();
        Admin admin=new Admin(adminDTO.getUsername(),adminDTO.getEmail(),adminDTO.getPassword());

        AdminProfile adminProfile=new AdminProfile(
                adminProfileDTO.getFirstName(),
                adminProfileDTO.getLastName(),
                adminProfileDTO.getAddress(),
                adminProfileDTO.getEmailAddress(),
                adminProfileDTO.getCity(),
                adminProfileDTO.getProvince(),
                adminProfileDTO.getBirthday(),
                adminProfileDTO.getTelNumber(),
                imagePath,
                admin
        );

        adminProfileRepository.save(adminProfile);
        return true;
    }

    @Override
    public boolean uploadImage(MultipartFile multipartFile) {
        if (!multipartFile.getOriginalFilename().isEmpty()) {
            BufferedOutputStream outputStream = null;
            try {

                outputStream = new BufferedOutputStream(
                        new FileOutputStream(
                                new File("F:/Server Images/Admin", multipartFile.getOriginalFilename())));
                imagePath = "http://localhost:8080/api/v1/admin/file?file=F:/Server Images/Admin/" + multipartFile.getOriginalFilename();
                outputStream.write(multipartFile.getBytes());
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
}
