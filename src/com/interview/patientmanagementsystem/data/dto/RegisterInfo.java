package com.interview.patientmanagementsystem.data.dto;

public class RegisterInfo {
    private String userName;
    private String password;
    private String receptionistId;

    public RegisterInfo(String userName, String password, String receptionistId) {
        this.userName = userName;
        this.password = password;
        this.receptionistId = receptionistId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getReceptionistId() {
        return receptionistId;
    }

    public void setReceptionistId(String receptionistId) {
        this.receptionistId = receptionistId;
    }
}
