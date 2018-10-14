package lk.ijse.jobportal.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BusinessFuntion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String businessFuntionName;

    public BusinessFuntion() {
    }

    public BusinessFuntion(String businessFuntionName) {
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

    @Override
    public String toString() {
        return "BusinessFuntion{" +
                "id=" + id +
                ", businessFuntionName='" + businessFuntionName + '\'' +
                '}';
    }
}
