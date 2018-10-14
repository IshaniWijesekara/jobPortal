package lk.ijse.jobportal.controller;

import lk.ijse.jobportal.dto.ApplyJobDTO;
import lk.ijse.jobportal.dto.ApplyJobMainDTO;
import lk.ijse.jobportal.service.ApplyJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/applyJob")
public class ApplyJobController {

    @Autowired
    private ApplyJobService applyJobService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean applyJob(@RequestBody ApplyJobMainDTO applyJobMainDTO){
        return applyJobService.applyJob(applyJobMainDTO);
    }

    @GetMapping(value = "/Last",produces = MediaType.APPLICATION_JSON_VALUE)
    public ApplyJobDTO getLastData(){
        return applyJobService.getLastData();
    }

    @GetMapping(value = "/{username}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<ApplyJobMainDTO> getApplyJobs(@PathVariable("username") String userName) {
        return applyJobService.getApplyJob(userName);
    }

    @GetMapping(value = "/searchJob/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ApplyJobMainDTO searchApplyJob(@PathVariable("id") Long id) {
        return applyJobService.searcJob(id);
    }


    @GetMapping(value = "/seekerApplyJob/{username}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<ApplyJobMainDTO> getSeekerApplyJobs(@PathVariable("username") String userName) {
        return applyJobService.getSeekerApplyJob(userName);
    }

}
