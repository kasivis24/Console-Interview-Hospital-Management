package com.interview.patientmanagementsystem.features.admin;

import com.interview.patientmanagementsystem.data.db.AppDb;
import com.interview.patientmanagementsystem.data.dto.Doctor;
import com.interview.patientmanagementsystem.data.type.AvailableType;

public class AdminModel {
    private final AdminView view;
    private final AppDb db;

    public AdminModel(AdminView view, AppDb db) {
        this.view = view;
        this.db = db;
    }

    public void addDoctor() {
        try {
            Doctor doctor = new Doctor();
            doctor.setName(view.getInput("Enter name"));
            doctor.setPhone(view.getInput("Enter phone"));
            doctor.setSpecialization(view.getInput("Enter specialization"));
            doctor.setAvailabilityType(AvailableType.valueOf(view.getInput("Availability (MORNING, AFTERNOON, SPECIFIC_HOURS)").toUpperCase()));

            db.addDoctor(doctor);
            view.showMessage("Doctor added successfully.");
        } catch (Exception e) {
            view.showMessage("Error: " + e.getMessage());
        }
    }

    public void removeReceptionist() {
        try {
            String username = view.getInput("Enter Receptionist Username to remove");
            db.removeReceptionist(username);
            view.showMessage("Receptionist removed.");
        } catch (Exception e) {
            view.showMessage("Error: " + e.getMessage());
        }
    }

    public AppDb getDb() {
        return db;
    }
}
