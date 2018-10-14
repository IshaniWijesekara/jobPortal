package lk.ijse.jobportal.service;

import lk.ijse.jobportal.dto.LoginDTO;


public interface LogService {

    public LoginDTO getLoginUser(String useName,String Pasword);
}
