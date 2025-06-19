package com.interview.patientmanagementsystem.features.auth.login;


import com.interview.patientmanagementsystem.data.db.AppDb;
import com.interview.patientmanagementsystem.features.baseview.BaseView;

import java.sql.SQLException;

public class ReceptionistLoginModel {
    private final ReceptionistLoginView view;
    private final AppDb db;

    public ReceptionistLoginModel(ReceptionistLoginView view, AppDb db) {
        this.view = view;
        this.db = db;
    }

    public boolean validateCredentials(String username, String password) throws SQLException {
        boolean success = db.loginReceptionist(username, password);
        if (!success) {
            view.showError("Invalid credentials.");
        }
        return success;
    }
}
