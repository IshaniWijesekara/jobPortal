package lk.ijse.jobportal.dto;

public class BussinessFuntionDTO {

    private Long id;
    private String businessFuntionName;

    public BussinessFuntionDTO() {
    }

    public BussinessFuntionDTO(Long id, String businessFuntionName) {
        this.id = id;
        this.businessFuntionName = businessFuntionName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBusinessFuntionName() {
        return businessFuntionName;
    }

    public void setBusinessFuntionName(String businessFuntionName) {
        this.businessFuntionName = businessFuntionName;
    }
}
