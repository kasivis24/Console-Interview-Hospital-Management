package com.interview.patientmanagementsystem.features.auth.login;

import com.interview.patientmanagementsystem.data.db.AppDb;

import java.sql.SQLException;
import java.util.Scanner;
import com.interview.patientmanagementsystem.data.db.AppDb;

import java.util.Scanner;

public class ReceptionistLoginView {
    private final Scanner scanner;
    private final ReceptionistLoginModel model;

    public ReceptionistLoginView(AppDb db, Scanner scanner) {
        this.scanner = scanner;
        this.model = new ReceptionistLoginModel(this, db);
    }

    public boolean login() throws SQLException {
        System.out.println("=== Receptionist Login ===");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        return model.validateCredentials(username, password);
    }

    public void showError(String msg) {
        System.out.println(msg);
    }
}