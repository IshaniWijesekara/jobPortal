package lk.ijse.jobportal.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Catagory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String catagoryName;

    public Catagory() {
    }

    public Catagory(String catagoryName) {

        this.catagoryName = catagoryName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCatagoryName() {
        return catagoryName;
    }

    public void setCatagoryName(String catagoryName) {
        this.catagoryName = catagoryName;
    }

    @Override
    public String toString() {
        return "Catagory{" +
                "id=" + id +
                ", catagoryName='" + catagoryName + '\'' +
                '}';
    }
}
