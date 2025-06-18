package com.interview.patientmanagementsystem.data.dto;

import com.interview.patientmanagementsystem.data.type.AvailableType;

public class Doctor {

    private int recordId;
    private String doctorId;
    private String name;
    private String mobileNumber;
    private AvailableType availableTimeSlotType;
    private Boolean isAvailableAppointment;
    private String specialization;
    private int avalibleTime;

    public Doctor(int recordId, String doctorId, String name, String mobileNumber, AvailableType availableTimeSlotType, Boolean isAvailableAppointment, String specialization, int avalibleTime) {
        this.recordId = recordId;
        this.doctorId = doctorId;
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.availableTimeSlotType = availableTimeSlotType;
        this.isAvailableAppointment = isAvailableAppointment;
        this.specialization = specialization;
        this.avalibleTime = avalibleTime;
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public AvailableType getAvailableTimeSlotType() {
        return availableTimeSlotType;
    }

    public void setAvailableTimeSlotType(AvailableType availableTimeSlotType) {
        this.availableTimeSlotType = availableTimeSlotType;
    }

    public Boolean getAvailableAppointment() {
        return isAvailableAppointment;
    }

    public void setAvailableAppointment(Boolean availableAppointment) {
        isAvailableAppointment = availableAppointment;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getAvalibleTime() {
        return avalibleTime;
    }

    public void setAvalibleTime(int avalibleTime) {
        this.avalibleTime = avalibleTime;
    }
}
