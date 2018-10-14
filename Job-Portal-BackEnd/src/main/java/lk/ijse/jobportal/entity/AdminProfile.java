package lk.ijse.jobportal.entity;

import javax.persistence.*;

@Entity
public class AdminProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String emailAddress;
    private String city;
    private String province;
    private String birthday;
    private String telNumber;
    private String imagePath;
    @OneToOne
    private Admin admin;

    public AdminProfile() {
    }

    public AdminProfile(String firstName, String lastName, String address, String emailAddress, String city, String province, String birthday, String telNumber, String imagePath, Admin admin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.emailAddress = emailAddress;
        this.city = city;
        this.province = province;
        this.birthday = birthday;
        this.telNumber = telNumber;
        this.imagePath = imagePath;
        this.admin = admin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "AdminProfile{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", birthday='" + birthday + '\'' +
                ", telNumber='" + telNumber + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", admin=" + admin +
                '}';
    }
}
