package com.interview.patientmanagementsystem.features.appointment;

import com.interview.patientmanagementsystem.data.db.AppDb;

import java.sql.SQLException;
import java.util.Scanner;

public class AppointmentView {
    private final Scanner scanner;
    private final AppointmentModel model;

    public AppointmentView(Scanner scanner, AppDb db) {
        this.scanner = scanner;
        this.model = new AppointmentModel(this, db);
    }

    public void show() throws SQLException {
        System.out.println("1. View by patient\n2. View all\n3. View by doctor\n4. View available slots");
        int ch = scanner.nextInt(); scanner.nextLine();
        model.handleViewOption(ch);
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void showMessage(String msg) {
        System.out.println(msg);
    }
}
