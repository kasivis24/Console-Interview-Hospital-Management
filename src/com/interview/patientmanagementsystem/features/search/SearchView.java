package com.interview.patientmanagementsystem.features.search;


import com.interview.patientmanagementsystem.data.db.AppDb;
import com.interview.patientmanagementsystem.data.dto.Doctor;
import com.interview.patientmanagementsystem.data.dto.Patient;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class SearchView {

    public static void search(Scanner scanner, AppDb db) throws SQLException {
        System.out.println("=================== Search Bar =====================");
        System.out.println("Search Options:\n1. Doctor\n2. Patient");
        int searchType = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter name to search: ");
        String searchName = scanner.nextLine();

        if (searchType == 1) {
            List<Doctor> foundDoctors = db.searchDoctorsByName(searchName);
            if (foundDoctors.isEmpty()) {
                System.out.println("No doctors found.");
            } else {
                for (Doctor d : foundDoctors) {
                    System.out.println("ID: " + d.getId() + ", Name: " + d.getName() + ", Specialization: " + d.getSpecialization());
                }
            }
        } else if (searchType == 2) {
            List<Patient> foundPatients = db.searchPatientsByName(searchName);
            if (foundPatients.isEmpty()) {
                System.out.println("No patients found.");
            } else {
                for (Patient p : foundPatients) {
                    System.out.println("ID: " + p.getId() + ", Name: " + p.getName() + ", Age: " + p.getAge());
                }
            }
        } else {
            System.out.println("Invalid search type.");
        }
    }
}
