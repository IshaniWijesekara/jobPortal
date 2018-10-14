package lk.ijse.jobportal.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Industry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String industryName;

    public Industry() {
    }

    public Industry(String industryName) {
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
        return "Industry{" +
                "id=" + id +
                ", industryName='" + industryName + '\'' +
                '}';
    }
}
