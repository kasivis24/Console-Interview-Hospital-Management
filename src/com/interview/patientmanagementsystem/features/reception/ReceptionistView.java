package com.interview.patientmanagementsystem.features.reception;

import com.interview.patientmanagementsystem.data.db.AppDb;

import java.util.Scanner;
public class ReceptionistView {
    private final Scanner scanner;
    private final ReceptionistModel model;

    public ReceptionistView(Scanner scanner, AppDb db) {
        this.scanner = scanner;
        this.model = new ReceptionistModel(this, db);
    }

    public void receptionistMenu() {
        while (true) {
            System.out.println("1. Add Patient\n2. Book Appointment\n3. View Appointments\n4. Search\n5. Remove Patient\n6. Logout");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (model.handleReceptionistMenu(choice)) break;
        }
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void showMessage(String msg) {
        System.out.println(msg);
    }
}