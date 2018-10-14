package lk.ijse.jobportal.service;

import lk.ijse.jobportal.dto.BussinessFuntionDTO;

import java.util.ArrayList;

public interface BussinessFuntionService {

    public boolean addBussinessFuntion(BussinessFuntionDTO bussinessFuntionDTO);

    public ArrayList<BussinessFuntionDTO> getAllBussinessFuntion();
}
