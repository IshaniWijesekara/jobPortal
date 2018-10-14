package lk.ijse.jobportal.dto;

public class CatagoryDTO {

    private Long id;
    private String catagoryName;

    public CatagoryDTO() {
    }

    public CatagoryDTO(Long id, String catagoryName) {
        this.id = id;
        this.catagoryName = catagoryName;
    }

    public Long getId() {
        return id;
    }

    public String getCatagoryName() {
        return catagoryName;
    }

    public void setCatagoryName(String catagoryName) {
        this.catagoryName = catagoryName;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
