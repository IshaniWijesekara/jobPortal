package lk.ijse.jobportal.controller;

import lk.ijse.jobportal.dto.BussinessFuntionDTO;
import lk.ijse.jobportal.dto.IndustryDTO;
import lk.ijse.jobportal.service.IndustryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/Industry")
public class IndustryController {

    @Autowired
    private IndustryService industryService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveIndustry(@RequestBody IndustryDTO industryDTO){
        return industryService.addIndusry(industryDTO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<IndustryDTO> getAllIndustry(){
        return industryService.getAllIndustry();
    }
}
