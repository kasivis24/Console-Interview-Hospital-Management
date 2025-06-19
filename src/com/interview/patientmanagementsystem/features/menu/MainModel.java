package com.interview.patientmanagementsystem.features.menu;

import com.interview.patientmanagementsystem.data.db.AppDb;
import com.interview.patientmanagementsystem.features.action.MenuAction;
import com.interview.patientmanagementsystem.features.admin.AdminMenuAction;
import com.interview.patientmanagementsystem.features.admin.AdminView;
import com.interview.patientmanagementsystem.features.auth.login.ReceptionistLoginView;
import com.interview.patientmanagementsystem.features.baseview.BaseView;
import com.interview.patientmanagementsystem.features.reception.ReceptionistLoginAction;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class MainModel extends BaseView {
    private final MainView view;
    private final Map<Integer, MenuAction> menuActions = new HashMap<>();

    public MainModel(MainView view) {
        this.view = view;
        menuActions.put(1, new AdminMenuAction(view.getScanner()));
        menuActions.put(2, new ReceptionistLoginAction(view.getScanner()));
        menuActions.put(3, this::exit);
    }

    public void handleMainMenu(int choice) {
        MenuAction action = menuActions.get(choice);
        if (action != null) {
            action.execute();
        } else {
            System.out.println("Invalid option.");
        }
    }
}