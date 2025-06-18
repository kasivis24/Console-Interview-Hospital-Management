package com.interview.patientmanagementsystem.features.appointment;

import com.interview.patientmanagementsystem.data.db.AppDb;
import com.interview.patientmanagementsystem.data.dto.Appointment;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ViewAppointmentOptions {

    public static void show(AppDb db, Scanner scanner) throws SQLException {
        System.out.println("========= View Appointments Options =========");
        System.out.println("1. All appointments for specific patient");
        System.out.println("2. All appointments for specific doctor");
        System.out.println("3. All scheduled appointments");
        System.out.println("4. Available slots");
        System.out.print("Choose option: ");
        int op = scanner.nextInt();
        scanner.nextLine();

        switch (op) {
            case 1 -> {
                System.out.print("Enter Patient ID: ");
                int pid = scanner.nextInt();
                scanner.nextLine();
                List<Appointment> patientAppointments = db.getAppointmentsForPatient(pid);
                patientAppointments.forEach(System.out::println);
            }
            case 2 -> {
                System.out.print("Enter Doctor ID: ");
                int did = scanner.nextInt();
                scanner.nextLine();
                List<Appointment> doctorAppointments = db.getAppointmentsForDoctor(did);
                doctorAppointments.forEach(System.out::println);
            }
            case 3 -> {
                List<Appointment> all = db.getAllAppointments();
                all.forEach(System.out::println);
            }
            case 4 -> {
                System.out.print("Enter Doctor ID: ");
                int did = scanner.nextInt();
                scanner.nextLine();
                List<String> slots = db.getAvailableSlots(did); // assuming you’ve implemented this
                slots.forEach(System.out::println);
            }
            default -> System.out.println("Invalid option");
        }
    }
}

