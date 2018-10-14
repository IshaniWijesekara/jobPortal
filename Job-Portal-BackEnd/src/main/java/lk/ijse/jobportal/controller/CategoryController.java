package lk.ijse.jobportal.controller;

import lk.ijse.jobportal.dto.CatagoryDTO;
import lk.ijse.jobportal.service.CatagoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/category")
public class CategoryController {

    @Autowired
    private CatagoryService catagoryService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean addCategoey(@RequestBody CatagoryDTO catagoryDTO){
        return catagoryService.addCatagory(catagoryDTO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<CatagoryDTO> getAllCategory(){
        return  catagoryService.getAllCategory();
    }
}
