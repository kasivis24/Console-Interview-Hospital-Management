package com.interview.patientmanagementsystem.data.dto;

public class Patient {

    private int recordNo;
    private String patientId;
    private String name;
    private int age;
    private long phoneNUmber;
    private Boolean isAppointment;

    public Patient(int recordNo, String patientId, String name, int age, long phoneNUmber, Boolean isAppointment) {
        this.recordNo = recordNo;
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.phoneNUmber = phoneNUmber;
        this.isAppointment = isAppointment;
    }

    public int getRecordNo() {
        return recordNo;
    }

    public void setRecordNo(int recordNo) {
        this.recordNo = recordNo;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getPhoneNUmber() {
        return phoneNUmber;
    }

    public void setPhoneNUmber(long phoneNUmber) {
        this.phoneNUmber = phoneNUmber;
    }

    public Boolean getAppointment() {
        return isAppointment;
    }

    public void setAppointment(Boolean appointment) {
        isAppointment = appointment;
    }
}
