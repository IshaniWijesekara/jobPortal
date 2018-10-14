package lk.ijse.jobportal.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class IndustryDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String industryName;

    public IndustryDTO() {
    }

    public IndustryDTO(String industryName) {
        this.industryName = industryName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    @Override
    public String toString() {
        return "IndustryDTO{" +
                "id=" + id +
                ", industryName='" + industryName + '\'' +
                '}';
    }
}
