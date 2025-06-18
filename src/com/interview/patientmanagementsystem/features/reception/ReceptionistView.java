package com.interview.patientmanagementsystem.features.reception;

import com.interview.patientmanagementsystem.data.db.AppDb;
import com.interview.patientmanagementsystem.data.dto.Appointment;
import com.interview.patientmanagementsystem.data.dto.Doctor;
import com.interview.patientmanagementsystem.data.dto.Patient;
import com.interview.patientmanagementsystem.features.appointment.ViewAppointmentOptions;
import com.interview.patientmanagementsystem.features.baseview.BaseView;
import com.interview.patientmanagementsystem.features.search.SearchView;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ReceptionistView extends BaseView {
    private final Scanner scanner;
    private final AppDb db;

    public ReceptionistView(Scanner scanner, AppDb db) {
        this.scanner = scanner;
        this.db = db;
    }

    public void receptionistLogin() throws SQLException {
        System.out.println("========================= Receptionist Login =====================");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        if (db.loginReceptionist(username, password)) {
            System.out.println("Login successful!");
            receptionistMenu();
        } else {
            inVaildation();
        }
    }

    private void receptionistMenu() throws SQLException {
        while (true) {
            System.out.println("1. Add Patient\n2. Book Appointment\n3. View Appointments\n4. Search\n5. Remove Patient\n6. Logout");
            int rc = scanner.nextInt();
            scanner.nextLine();

            switch (rc) {
                case 1 -> addPatient();
                case 2 -> bookAppointment();
                case 3 -> ViewAppointmentOptions.show(db, scanner);
                case 4 -> SearchView.search(scanner, db);
                case 5 -> removePatient();
                case 6 -> { return; }
            }
        }
    }

    private void addPatient() throws SQLException {
        System.out.println("===================== Add Patient ====================");
        Patient p = new Patient();
        System.out.print("Name: "); p.setName(scanner.nextLine());
        System.out.print("Age: "); p.setAge(scanner.nextInt()); scanner.nextLine();
        System.out.print("Phone: "); p.setPhone(scanner.nextLine());
        db.addPatient(p);
    }

    private void bookAppointment() throws SQLException {
        List<Doctor> docs = db.getAllDoctors();
        for (Doctor doc : docs) System.out.println(doc.getId() + ": " + doc.getName());
        System.out.print("Choose Doctor ID: ");
        int did = scanner.nextInt();
        List<Patient> pats = db.getAllPatients();
        for (Patient pat : pats) System.out.println(pat.getId() + ": " + pat.getName());
        System.out.print("Choose Patient ID: ");
        int pid = scanner.nextInt(); scanner.nextLine();
        System.out.print("DateTime (yyyy-MM-dd HH:mm): ");
        String dt = scanner.nextLine();
        Appointment a = new Appointment(did, pid, dt);
        db.scheduleAppointment(a);
    }

    private void removePatient() throws SQLException {
        System.out.print("Enter Patient ID to remove: ");
        int pid = scanner.nextInt(); scanner.nextLine();
        db.removePatientById(pid);
        System.out.println("Patient removed.");
    }
}
