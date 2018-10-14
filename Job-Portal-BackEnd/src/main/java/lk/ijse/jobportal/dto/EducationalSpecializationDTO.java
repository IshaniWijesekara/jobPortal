package lk.ijse.jobportal.dto;

public class EducationalSpecializationDTO {
    private  Long id;
    private String educationalSpecializationName;

    public EducationalSpecializationDTO() {
    }

    public EducationalSpecializationDTO(Long id, String educationalSpecializationName) {
        this.id = id;
        this.educationalSpecializationName = educationalSpecializationName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEducationalSpecializationName() {
        return educationalSpecializationName;
    }

    public void setEducationalSpecializationName(String educationalSpecializationName) {
        this.educationalSpecializationName = educationalSpecializationName;
    }


}
