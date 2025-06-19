package com.interview.patientmanagementsystem.features.auth.register;

import com.interview.patientmanagementsystem.data.db.AppDb;
import com.interview.patientmanagementsystem.data.dto.Receptionist;

import java.sql.SQLException;
import java.util.Scanner;
public class ReceptionistRegisterView {
    private final ReceptionistRegisterModel model;
    private final Scanner scanner;

    public ReceptionistRegisterView(AppDb db, Scanner scanner) {
        this.model = new ReceptionistRegisterModel(this, db);
        this.scanner = scanner;
    }

    public void register() {
        System.out.println("=== Register Receptionist ===");
        Receptionist r = new Receptionist();
        System.out.print("Username: ");
        r.setUsername(scanner.nextLine());
        System.out.print("Password: ");
        r.setPassword(scanner.nextLine());

        model.registerReceptionist(r);
    }

    public void showSuccess() {
        System.out.println("Receptionist registered successfully.");
    }

    public void showError(String message) {
        System.out.println("Error: " + message);
    }
}
