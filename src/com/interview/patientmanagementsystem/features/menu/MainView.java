package com.interview.patientmanagementsystem.features.menu;

import com.interview.patientmanagementsystem.data.db.AppDb;
import com.interview.patientmanagementsystem.features.admin.AdminView;
import com.interview.patientmanagementsystem.features.auth.login.ReceptionistLoginView;
import com.interview.patientmanagementsystem.features.baseview.BaseView;
import com.interview.patientmanagementsystem.features.reception.ReceptionistView;
import java.sql.SQLException;
import java.util.Scanner;

public class MainView {
    private final Scanner scanner = new Scanner(System.in);
    private final MainModel model;

    public MainView() throws SQLException {
        model = new MainModel(this);
    }

    public void start() {
        while (true) {
            System.out.println("===== Main Menu =====");
            System.out.println("1. Admin\n2. Receptionist\n3. Exit");
            System.out.print("Enter choice: ");
            int ch = scanner.nextInt();
            scanner.nextLine();
            model.handleMainMenu(ch);
        }
    }

    public Scanner getScanner() {
        return scanner;
    }
}
