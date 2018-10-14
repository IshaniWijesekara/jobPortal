package lk.ijse.jobportal.service;

import lk.ijse.jobportal.dto.IndustryDTO;

import java.util.ArrayList;

public interface IndustryService {

    public boolean addIndusry(IndustryDTO industryDTO);

    public ArrayList<IndustryDTO> getAllIndustry();
}
