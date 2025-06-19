package com.interview.patientmanagementsystem.data.dto;

public class Appointment {
    private int id;
    private int doctorId;
    private int patientId;
    private String dateTime;

    public Appointment(){

    }

    public Appointment(int doctorId, int patientId, String dateTime) {
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.dateTime = dateTime;
    }


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getDoctorId() { return doctorId; }
    public void setDoctorId(int doctorId) { this.doctorId = doctorId; }
    public int getPatientId() { return patientId; }
    public void setPatientId(int patientId) { this.patientId = patientId; }
    public String getDateTime() { return dateTime; }
    public void setDateTime(String dateTime) { this.dateTime = dateTime; }


    @Override
    public String toString() {
        return String.format("%-10s %-15s %-15s %-20s",
                "ApptID: " + id,
                "DoctorID: " + doctorId,
                "PatientID: " + patientId,
                "DateTime: " + dateTime);
    }

}