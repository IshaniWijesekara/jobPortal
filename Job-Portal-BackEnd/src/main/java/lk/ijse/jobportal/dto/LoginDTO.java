package lk.ijse.jobportal.dto;

public class LoginDTO {
    private UserDTO User;
    private JobPosterDTO jobPosterDTO;
    private AdminDTO adminDTO;

    public LoginDTO() {
    }

    public LoginDTO(UserDTO user, JobPosterDTO jobPosterDTO, AdminDTO adminDTO) {
        User = user;
        this.jobPosterDTO = jobPosterDTO;
        this.adminDTO = adminDTO;
    }

    public UserDTO getUser() {
        return User;
    }

    public void setUser(UserDTO user) {
        User = user;
    }

    public JobPosterDTO getJobPosterDTO() {
        return jobPosterDTO;
    }

    public void setJobPosterDTO(JobPosterDTO jobPosterDTO) {
        this.jobPosterDTO = jobPosterDTO;
    }

    public AdminDTO getAdminDTO() {
        return adminDTO;
    }

    public void setAdminDTO(AdminDTO adminDTO) {
        this.adminDTO = adminDTO;
    }

    @Override
    public String toString() {
        return "LoginDTO{" +
                "User=" + User +
                ", jobPosterDTO=" + jobPosterDTO +
                ", adminDTO=" + adminDTO +
                '}';
    }
}
