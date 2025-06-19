package com.interview.patientmanagementsystem.features.search;


import com.interview.patientmanagementsystem.data.db.AppDb;
import com.interview.patientmanagementsystem.data.dto.Doctor;
import com.interview.patientmanagementsystem.data.dto.Patient;

import java.sql.SQLException;
import java.util.List;

public class SearchModel {
    private final SearchView view;
    private final AppDb db;

    public SearchModel(SearchView view, AppDb db) {
        this.view = view;
        this.db = db;
    }

    public void search(int type) throws SQLException {
        String name = view.getInput("Enter name to search");
        if (type == 1) {
            List<Doctor> doctors = db.searchDoctorsByName(name);
            doctors.forEach(d -> System.out.println(d));
        } else if (type == 2) {
            List<Patient> patients = db.searchPatientsByName(name);
            patients.forEach(p -> System.out.println(p));
        } else {
            view.showMessage("Invalid search type");
        }
    }
}
