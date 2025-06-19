package com.interview.patientmanagementsystem.features.admin;

import com.interview.patientmanagementsystem.data.db.AppDb;
import com.interview.patientmanagementsystem.features.action.MenuAction;

import java.sql.SQLException;
import java.util.Scanner;

public class AdminMenuAction implements MenuAction {
    private final Scanner scanner;

    public AdminMenuAction(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        try {
            new AdminView(scanner, AppDb.getInstance()).adminMenu();
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}