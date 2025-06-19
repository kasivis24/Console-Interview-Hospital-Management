package com.interview.patientmanagementsystem.features.reception;

import com.interview.patientmanagementsystem.data.db.AppDb;
import com.interview.patientmanagementsystem.features.action.MenuAction;
import com.interview.patientmanagementsystem.features.auth.login.ReceptionistLoginView;

import java.sql.SQLException;
import java.util.Scanner;

public class ReceptionistLoginAction implements MenuAction {
    private final Scanner scanner;

    public ReceptionistLoginAction(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        try {
            ReceptionistLoginView loginView = new ReceptionistLoginView(AppDb.getInstance(), scanner);
            if (loginView.login()) {
                new ReceptionistView(scanner, AppDb.getInstance()).receptionistMenu();
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}