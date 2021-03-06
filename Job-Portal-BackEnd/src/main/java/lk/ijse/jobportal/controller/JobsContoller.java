package lk.ijse.jobportal.controller;

import lk.ijse.jobportal.dto.JobsDTO;
import lk.ijse.jobportal.dto.PostJobDTO;
import lk.ijse.jobportal.entity.JobPoster;
import lk.ijse.jobportal.service.JobsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/jobs")
public class JobsContoller {

    @Autowired
    private JobsService jobsService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean addJobs(@RequestBody PostJobDTO postJobDTO){
        return jobsService.addJob(postJobDTO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<PostJobDTO> getAllJobs() {
        return jobsService.getAllPostJobs();
    }

    @GetMapping(value = "/{username}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<PostJobDTO> getPosterPostedJobs(@PathVariable("username") String username){
        return jobsService.getPosterPostedJobs(username);
    }

    @GetMapping(value = "category/{category}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<PostJobDTO> searchjobCategory(@PathVariable("category") String category){
        return jobsService.SeachJob(category);
    }
    @PostMapping(value = "/file")
    public boolean postImage(@RequestParam("file") MultipartFile file) {
        return jobsService.uploadImage(file);

    }

    @GetMapping(value = "search/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public PostJobDTO searchJobs(@PathVariable("id") Long id){
        System.out.println(id);
        return jobsService.searchJob(id);
    }

    @DeleteMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean deleteJobs(@PathVariable("id") Long id){
        return jobsService.deleteJob(id);
    }

    @PostMapping(value = "/update",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean updateJob(@RequestBody PostJobDTO postJobDTO){
        return jobsService.updateJob(postJobDTO);
    }

    @GetMapping(value = "/Total",produces = MediaType.APPLICATION_JSON_VALUE)
    public long getTotalJobs(){
       return jobsService.getTotalJobs();
    }

    @GetMapping(value = "/{name}",produces = MediaType.APPLICATION_JSON_VALUE)
    public PostJobDTO getAllSearchedJobs(){
        return null;
    }

}
