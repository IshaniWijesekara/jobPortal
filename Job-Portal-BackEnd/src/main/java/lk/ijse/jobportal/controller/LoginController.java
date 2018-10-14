package lk.ijse.jobportal.controller;

import lk.ijse.jobportal.dto.LoginDTO;
import lk.ijse.jobportal.dto.UserDTO;
import lk.ijse.jobportal.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/login")
public class LoginController  {


    @Autowired
    private LogService logService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public LoginDTO Login(@RequestBody UserDTO userDTO){

        return logService.getLoginUser(userDTO.getUsername(),userDTO.getPassword());
    }


}
