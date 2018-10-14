package lk.ijse.jobportal.service;

import lk.ijse.jobportal.dto.CatagoryDTO;

import java.util.ArrayList;

public interface CatagoryService {
    public boolean addCatagory(CatagoryDTO catagoryDTO);

    public ArrayList<CatagoryDTO> getAllCategory();
}
