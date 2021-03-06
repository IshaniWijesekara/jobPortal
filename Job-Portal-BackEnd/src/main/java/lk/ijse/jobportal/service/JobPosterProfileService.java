package lk.ijse.jobportal.service;

import lk.ijse.jobportal.dto.JObPosterProfileDTO;
import org.omg.CORBA_2_3.portable.InputStream;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;

public interface JobPosterProfileService {

    public boolean savePosterProfile(JObPosterProfileDTO posterProfileDTO);

    public ArrayList<JObPosterProfileDTO> viewProfileData();

    public JObPosterProfileDTO searchPosterProfile(String name);

    public boolean uploadFile(MultipartFile file);

    public ResponseEntity<InputStreamResource> getImage(String path);

    public ArrayList<JObPosterProfileDTO> getAllProfile();


}
