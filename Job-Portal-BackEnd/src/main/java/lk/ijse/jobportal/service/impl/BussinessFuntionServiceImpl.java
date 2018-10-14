package lk.ijse.jobportal.service.impl;

import lk.ijse.jobportal.controller.BussinessFuntion;
import lk.ijse.jobportal.dto.BussinessFuntionDTO;
import lk.ijse.jobportal.entity.BusinessFuntion;
import lk.ijse.jobportal.repository.BusinessFuntionRepository;
import lk.ijse.jobportal.service.BussinessFuntionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class BussinessFuntionServiceImpl implements BussinessFuntionService {

    @Autowired
    private BusinessFuntionRepository businessFuntionRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean addBussinessFuntion(BussinessFuntionDTO bussinessFuntionDTO) {
        BusinessFuntion businessFuntion=new BusinessFuntion(
                bussinessFuntionDTO.getBusinessFuntionName()
        );
        businessFuntionRepository.save(businessFuntion);
        return true;
    }

    @Override
    public ArrayList<BussinessFuntionDTO> getAllBussinessFuntion() {
        List<BusinessFuntion> allBussinessFuntion = businessFuntionRepository.findAll();

        ArrayList<BussinessFuntionDTO> getAllBussinessFuntion=new ArrayList<>();
        for (BusinessFuntion businessFuntion:allBussinessFuntion
             ) {
            BussinessFuntionDTO bussinessFuntionDTO=new BussinessFuntionDTO();
            bussinessFuntionDTO.setId(businessFuntion.getId());
            bussinessFuntionDTO.setBusinessFuntionName(businessFuntion.getBusinessFuntionName());

            getAllBussinessFuntion.add(bussinessFuntionDTO);
        }

        return getAllBussinessFuntion;
    }
}
