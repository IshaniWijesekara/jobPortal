package lk.ijse.jobportal.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EducationalSpecialization {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    private String educationalSpecializationName;

    public EducationalSpecialization() {
    }

    public EducationalSpecialization(String educationalSpecializationName) {
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

    @Override
    public String toString() {
        return "EducationalSpecialization{" +
                "id=" + id +
                ", educationalSpecializationName='" + educationalSpecializationName + '\'' +
                '}';
    }
}
