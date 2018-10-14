package lk.ijse.jobportal.service.impl;

import lk.ijse.jobportal.dto.CatagoryDTO;
import lk.ijse.jobportal.entity.Catagory;
import lk.ijse.jobportal.repository.CatagoryRepository;
import lk.ijse.jobportal.service.CatagoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class CatagoryServiceimpl implements CatagoryService {
    @Autowired
    private CatagoryRepository catagoryRepository;
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean addCatagory(CatagoryDTO catagoryDTO) {
        Catagory catagory=new Catagory(
                catagoryDTO.getCatagoryName()
        );
        catagoryRepository.save(catagory);
        return true;
    }

    @Override
    public ArrayList<CatagoryDTO> getAllCategory() {
        ArrayList<Catagory> allCategory = catagoryRepository.getAllCatagory();

        ArrayList<CatagoryDTO> getAllCatagory=new ArrayList<>();
        for (Catagory catagory:allCategory
             ) {
            CatagoryDTO catagoryDTO=new CatagoryDTO();
            catagoryDTO.setId(catagory.getId());
            catagoryDTO.setCatagoryName(catagory.getCatagoryName());

            getAllCatagory.add(catagoryDTO);
        }
        return getAllCatagory;
 }
}
