package lk.ijse.jobportal.controller;

import lk.ijse.jobportal.dto.AdminProfileDTO;
import lk.ijse.jobportal.service.AdminProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/admin")
public class AdminController {

    @Autowired
    private AdminProfileService adminProfileService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveAdminProfile(@RequestBody AdminProfileDTO adminProfileDTO){
       return adminProfileService.saveAdminProfile(adminProfileDTO);
    }

    @PostMapping(value = "/file",produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean uploadImage(@RequestParam("file") MultipartFile file) {
        return adminProfileService.uploadImage(file);
    }
}
