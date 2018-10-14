package lk.ijse.jobportal.controller;

import lk.ijse.jobportal.dto.BussinessFuntionDTO;
import lk.ijse.jobportal.service.BussinessFuntionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/BussinesFuntion")
public class BussinessFuntionController {
    @Autowired
    private BussinessFuntionService bussinessFuntionService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveBussinessFuntion(@RequestBody BussinessFuntionDTO bussinessFuntionDTO){
        return bussinessFuntionService.addBussinessFuntion(bussinessFuntionDTO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<BussinessFuntionDTO> getAllBussinessFuntion(){
        return bussinessFuntionService.getAllBussinessFuntion();
    }
}
