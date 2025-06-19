package com.interview.patientmanagementsystem.features.auth.register;

import com.interview.patientmanagementsystem.data.db.AppDb;
import com.interview.patientmanagementsystem.data.dto.Receptionist;

public class ReceptionistRegisterModel {
    private final ReceptionistRegisterView view;
    private final AppDb db;

    public ReceptionistRegisterModel(ReceptionistRegisterView view, AppDb db) {
        this.view = view;
        this.db = db;
    }

    public void registerReceptionist(Receptionist receptionist) {
        try {
            db.registerReceptionist(receptionist);
            view.showSuccess();
        } catch (Exception e) {
            view.showError(e.getMessage());
        }
    }
}
