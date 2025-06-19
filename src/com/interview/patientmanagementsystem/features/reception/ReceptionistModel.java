package com.interview.patientmanagementsystem.features.reception;


import com.interview.patientmanagementsystem.data.db.AppDb;
import com.interview.patientmanagementsystem.data.dto.Appointment;
import com.interview.patientmanagementsystem.data.dto.Doctor;
import com.interview.patientmanagementsystem.data.dto.Patient;
import com.interview.patientmanagementsystem.features.appointment.AppointmentView;
import com.interview.patientmanagementsystem.features.search.SearchView;

import java.sql.SQLException;
import java.util.List;

public class ReceptionistModel {
    private final ReceptionistView view;
    private final AppDb db;

    public ReceptionistModel(ReceptionistView view, AppDb db) {
        this.view = view;
        this.db = db;
    }

    public boolean handleReceptionistMenu(int choice) {
        try {
            switch (choice) {
                case 1 -> addPatient();
                case 2 -> bookAppointment();
                case 3 -> new AppointmentView(view.getScanner(), db).show();
                case 4 -> new SearchView(view.getScanner(), db).search();
                case 5 -> removePatient();
                case 6 -> {
                    view.showMessage("Logging out...");
                    return true;
                }
                default -> view.showMessage("Invalid choice.");
            }
        } catch (Exception e) {
            view.showMessage("Error: " + e.getMessage());
        }
        return false;
    }

    private void addPatient() throws SQLException {
        Patient p = new Patient();
        System.out.print("Name: "); p.setName(view.getScanner().nextLine());
        System.out.print("Age: "); p.setAge(view.getScanner().nextInt()); view.getScanner().nextLine();
        System.out.print("Phone: "); p.setPhone(view.getScanner().nextLine());
        db.addPatient(p);
        view.showMessage("Patient added successfully.");
    }

    private void bookAppointment() throws SQLException {
        List<Doctor> docs = db.getAllDoctors();
        for (Doctor doc : docs) System.out.println(doc.getId() + ": " + doc.getName());
        System.out.print("Choose Doctor ID: ");
        int did = view.getScanner().nextInt();

        List<Patient> pats = db.getAllPatients();
        for (Patient pat : pats) System.out.println(pat.getId() + ": " + pat.getName());
        System.out.print("Choose Patient ID: ");
        int pid = view.getScanner().nextInt(); view.getScanner().nextLine();

        System.out.print("DateTime (yyyy-MM-dd HH:mm): ");
        String dt = view.getScanner().nextLine();

        Appointment a = new Appointment();
        a.setDoctorId(did);
        a.setPatientId(pid);
        a.setDateTime(dt);
        db.scheduleAppointment(a);
        view.showMessage("Appointment scheduled.");
    }

    private void removePatient() throws SQLException {
        System.out.print("Enter Patient ID to remove: ");
        int pid = view.getScanner().nextInt(); view.getScanner().nextLine();
        db.removePatientById(pid);
        view.showMessage("Patient removed.");
    }
}
