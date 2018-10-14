package lk.ijse.jobportal.service;

import lk.ijse.jobportal.dto.EducationalSpecializationDTO;

import java.util.ArrayList;

public interface EducationalSpecializationService {

    public boolean addEducationalSpecialization(EducationalSpecializationDTO educationalSpecializationDTO);

    public ArrayList<EducationalSpecializationDTO> getAllEducationalSpecialization();
}
