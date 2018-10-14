package lk.ijse.jobportal.controller;

import lk.ijse.jobportal.dto.EducationalSpecializationDTO;
import lk.ijse.jobportal.service.EducationalSpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/EducationalSpecialization")
public class EducationalSpecializationController {

    @Autowired
    private EducationalSpecializationService educationalSpecializationService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveEducationalSpecialization(@RequestBody  EducationalSpecializationDTO educationalSpecializationDTO){
        return educationalSpecializationService.addEducationalSpecialization(educationalSpecializationDTO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<EducationalSpecializationDTO> getAllEducationalSpecialization(){
        return educationalSpecializationService.getAllEducationalSpecialization();
    }
}
