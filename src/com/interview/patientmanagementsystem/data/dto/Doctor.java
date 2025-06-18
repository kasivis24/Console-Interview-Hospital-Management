package com.interview.patientmanagementsystem.data.dto;

import com.interview.patientmanagementsystem.data.type.AvailableType;
public class Doctor {
    private int id;
    private String name;
    private String phone;
    private String specialization;
    private AvailableType availabilityType;
    private String startTime;
    private String endTime;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }
    public AvailableType getAvailabilityType() { return availabilityType; }
    public void setAvailabilityType(AvailableType availabilityType) { this.availabilityType = availabilityType; }
    public String getStartTime() { return startTime; }
    public void setStartTime(String startTime) { this.startTime = startTime; }
    public String getEndTime() { return endTime; }
    public void setEndTime(String endTime) { this.endTime = endTime; }
}