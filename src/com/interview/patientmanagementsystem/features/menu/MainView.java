package com.interview.patientmanagementsystem.features.menu;

import com.interview.patientmanagementsystem.data.db.AppDb;
import com.interview.patientmanagementsystem.features.admin.AdminView;
import com.interview.patientmanagementsystem.features.baseview.BaseView;
import com.interview.patientmanagementsystem.features.reception.ReceptionistView;

import java.sql.SQLException;
import java.util.Scanner;

public class MainView extends BaseView {
    private Scanner scanner = new Scanner(System.in);
    private AppDb db = AppDb.getInstance();

    public MainView() throws SQLException {
    }

    public void start() throws SQLException {
        while (true) {
            System.out.println("======================= Main Menu ====================");
            System.out.println("1. Admin\n2. Receptionist\n3. Exit");
            int ch = scanner.nextInt();
            scanner.nextLine();

            switch (ch) {
                case 1 -> new AdminView(scanner, db).adminMenu();
                case 2 -> new ReceptionistView(scanner, db).receptionistLogin();
                case 3 -> exit();
            }
        }
    }
}
