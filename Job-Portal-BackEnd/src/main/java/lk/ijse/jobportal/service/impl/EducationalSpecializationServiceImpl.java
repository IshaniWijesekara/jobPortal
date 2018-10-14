package lk.ijse.jobportal.service.impl;

import lk.ijse.jobportal.dto.EducationalSpecializationDTO;
import lk.ijse.jobportal.entity.EducationalSpecialization;
import lk.ijse.jobportal.repository.EducationalSpecializationRepository;
import lk.ijse.jobportal.service.EducationalSpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class EducationalSpecializationServiceImpl implements EducationalSpecializationService {

    @Autowired
    private EducationalSpecializationRepository educationalSpecializationRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean addEducationalSpecialization(EducationalSpecializationDTO educationalSpecializationDTO) {
        EducationalSpecialization educationalSpecialization=new EducationalSpecialization(
                educationalSpecializationDTO.getEducationalSpecializationName()
        );
        educationalSpecializationRepository.save(educationalSpecialization);
        return true;
    }

    @Override
    public ArrayList<EducationalSpecializationDTO> getAllEducationalSpecialization() {
        List<EducationalSpecialization> all = educationalSpecializationRepository.findAll();

        ArrayList<EducationalSpecializationDTO> getAllEducationalSpecialization=new ArrayList<>();
        for (EducationalSpecialization educationalSpecialization:all
             ) {
            EducationalSpecializationDTO educationalSpecializationDTO=new EducationalSpecializationDTO();
            educationalSpecializationDTO.setId(educationalSpecialization.getId());
            educationalSpecializationDTO.setEducationalSpecializationName(educationalSpecialization.getEducationalSpecializationName());

            getAllEducationalSpecialization.add(educationalSpecializationDTO);
        }
        return  getAllEducationalSpecialization;
    }
}
