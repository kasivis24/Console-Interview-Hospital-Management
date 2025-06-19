package com.interview.patientmanagementsystem.features.search;


import com.interview.patientmanagementsystem.data.db.AppDb;
import com.interview.patientmanagementsystem.data.dto.Doctor;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class SearchView {
    private final Scanner scanner;
    private final SearchModel model;

    public SearchView(Scanner scanner, AppDb db) {
        this.scanner = scanner;
        this.model = new SearchModel(this, db);
    }

    public void search() throws SQLException {
        System.out.println("1. Search Doctor\n2. Search Patient");
        int ch = scanner.nextInt(); scanner.nextLine();
        model.search(ch);
    }

    public String getInput(String label) {
        System.out.print(label + ": ");
        return scanner.nextLine();
    }

    public void showMessage(String msg) {
        System.out.println(msg);
    }
}