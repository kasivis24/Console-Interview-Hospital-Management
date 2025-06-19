package com.interview.patientmanagementsystem.features.appointment;

import com.interview.patientmanagementsystem.data.db.AppDb;
import com.interview.patientmanagementsystem.data.dto.Appointment;

import java.sql.SQLException;
import java.util.List;

public class AppointmentModel {
    private final AppointmentView view;
    private final AppDb db;

    public AppointmentModel(AppointmentView view, AppDb db) {
        this.view = view;
        this.db = db;
    }

    public void handleViewOption(int ch) throws SQLException {
        switch (ch) {
            case 1 -> viewByPatient();
            case 2 -> viewAll();
            case 3 -> viewByDoctor();
            case 4 -> viewAvailable();
            default -> view.showMessage("Invalid option");
        }
    }

    private void viewByPatient() {
        System.out.print("Enter Patient ID: ");
        int id = view.getScanner().nextInt(); view.getScanner().nextLine();
        List<Appointment> list = db.getAppointmentsForPatient(id);
        list.forEach(a -> System.out.println(a));
    }

    private void viewByDoctor() throws SQLException {
        System.out.print("Enter Doctor ID: ");
        int id = view.getScanner().nextInt(); view.getScanner().nextLine();
        List<Appointment> list = db.getAppointmentsForDoctor(id);
        list.forEach(a -> System.out.println(a));
    }

    private void viewAll() throws SQLException {
        List<Appointment> list = db.getAllAppointments();
        list.forEach(a -> System.out.println(a));
    }

    private void viewAvailable() {
        System.out.print("Enter Doctor ID: ");
        int doctorId = view.getScanner().nextInt(); view.getScanner().nextLine();
        List<String> slots = db.getAvailableSlots(doctorId);
        slots.forEach(System.out::println);
    }
}
