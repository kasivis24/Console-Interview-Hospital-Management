package com.interview.patientmanagementsystem.features.menu;

import com.interview.patientmanagementsystem.data.db.AppDb;
import com.interview.patientmanagementsystem.features.admin.AdminView;
import com.interview.patientmanagementsystem.features.auth.login.ReceptionistLoginView;
import com.interview.patientmanagementsystem.features.baseview.BaseView;
import com.interview.patientmanagementsystem.features.reception.ReceptionistView;

import java.sql.SQLException;

public class MainModel extends BaseView {
    private final MainView view;

    public MainModel(MainView view) {
        this.view = view;
    }

    public void handleMainMenu(int choice) {
        try {
            switch (choice) {
                case 1 -> new AdminView(view.getScanner(), AppDb.getInstance()).adminMenu();
                case 2 -> {
                    ReceptionistLoginView loginView = new ReceptionistLoginView(AppDb.getInstance(), view.getScanner());
                    if (loginView.login()) {
                        new ReceptionistView(view.getScanner(), AppDb.getInstance()).receptionistMenu();
                    }
                }
                case 3 -> {
                    exit();
                }
                default -> System.out.println("Invalid option.");
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}
