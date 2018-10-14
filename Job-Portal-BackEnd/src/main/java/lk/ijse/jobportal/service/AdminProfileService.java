package lk.ijse.jobportal.service;

import lk.ijse.jobportal.dto.AdminProfileDTO;
import org.springframework.web.multipart.MultipartFile;

public interface AdminProfileService {

    public boolean saveAdminProfile(AdminProfileDTO adminProfileDTO);

    public boolean uploadImage(MultipartFile multipartFile);
}
