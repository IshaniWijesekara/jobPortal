package lk.ijse.jobportal.service.impl;

import lk.ijse.jobportal.dto.IndustryDTO;
import lk.ijse.jobportal.entity.Industry;
import lk.ijse.jobportal.repository.IndustryRepository;
import lk.ijse.jobportal.service.IndustryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class IndustryServiceImpl  implements IndustryService{

    @Autowired
    private IndustryRepository industryRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean addIndusry(IndustryDTO industryDTO) {
        Industry industry=new Industry(industryDTO.getIndustryName());
        industryRepository.save(industry);
        return true;
    }

    @Override
    public ArrayList<IndustryDTO> getAllIndustry() {
        ArrayList<Industry> allIndustry = industryRepository.getAllIndustry();

        ArrayList<IndustryDTO> industryDTOS=new ArrayList<>();

        for (Industry industry :allIndustry
                ) {
            IndustryDTO industryDTO=new IndustryDTO();
            industryDTO.setId(industry.getId());
            industryDTO.setIndustryName(industry.getIndustryName());

            industryDTOS.add(industryDTO);
        }
        return industryDTOS;

    }
}
