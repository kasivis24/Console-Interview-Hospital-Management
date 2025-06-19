package com.interview.patientmanagementsystem.features.admin;

import com.interview.patientmanagementsystem.data.db.AppDb;
import com.interview.patientmanagementsystem.data.dto.Doctor;
import com.interview.patientmanagementsystem.data.dto.Receptionist;
import com.interview.patientmanagementsystem.data.type.AvailableType;
import com.interview.patientmanagementsystem.features.auth.register.ReceptionistRegisterView;
import com.interview.patientmanagementsystem.features.baseview.BaseView;

import java.sql.SQLException;
import java.util.Scanner;

public class AdminView extends BaseView{
    private final Scanner scanner;
    private final AdminModel model;

    public AdminView(Scanner scanner, AppDb db) {
        this.scanner = scanner;
        this.model = new AdminModel(this, db);
    }

    public void adminMenu() throws SQLException {
        System.out.println("1. Add Doctor\n2. Register Receptionist\n3. Remove Receptionist\n4. Back");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> model.addDoctor();
            case 2 -> new ReceptionistRegisterView(model.getDb(), scanner).register();
            case 3 -> model.removeReceptionist();
            case 4 -> System.out.println("Returning...");
            default -> inValid();
        }
    }

    public String getInput(String label) {
        System.out.print(label + ": ");
        return scanner.nextLine();
    }

    public void showMessage(String msg) {
        System.out.println(msg);
    }
}