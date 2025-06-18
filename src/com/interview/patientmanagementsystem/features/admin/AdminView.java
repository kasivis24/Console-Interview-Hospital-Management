package com.interview.patientmanagementsystem.features.admin;

import com.interview.patientmanagementsystem.data.db.AppDb;
import com.interview.patientmanagementsystem.data.dto.Doctor;
import com.interview.patientmanagementsystem.data.dto.Receptionist;
import com.interview.patientmanagementsystem.data.type.AvailableType;
import com.interview.patientmanagementsystem.features.baseview.BaseView;

import java.sql.SQLException;
import java.util.Scanner;

public class AdminView extends BaseView {
    private final Scanner scanner;
    private final AppDb db;

    public AdminView(Scanner scanner, AppDb db) {
        this.scanner = scanner;
        this.db = db;
    }

    public void adminMenu() throws SQLException {
        System.out.println("1. Add Doctor\n2. Register Receptionist\n3. Remove Receptionist\n4. Back");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> addDoctor();
            case 2 -> registerReceptionist();
            case 3 -> removeReceptionist();
        }
    }

    private void addDoctor() throws SQLException {
        System.out.println("========================= Add Doctor =====================");
        Doctor d = new Doctor();
        System.out.print("Name: "); d.setName(scanner.nextLine());
        System.out.print("Phone: "); d.setPhone(scanner.nextLine());
        System.out.print("Specialization: "); d.setSpecialization(scanner.nextLine());
        System.out.print("Availability (MORNING, AFTERNOON, SPECIFIC_HOURS): ");
        d.setAvailabilityType(AvailableType.valueOf(scanner.nextLine().toUpperCase()));
        db.addDoctor(d);
    }

    private void registerReceptionist() throws SQLException {
        System.out.println("========================= Receptionist Register =====================");
        Receptionist r = new Receptionist();
        System.out.print("Username: "); r.setUsername(scanner.nextLine());
        System.out.print("Password: "); r.setPassword(scanner.nextLine());
        db.registerReceptionist(r);
    }

    private void removeReceptionist() throws SQLException {
        System.out.print("Enter Receptionist Username to Remove: ");
        db.removeReceptionist(scanner.nextLine());
    }
}
