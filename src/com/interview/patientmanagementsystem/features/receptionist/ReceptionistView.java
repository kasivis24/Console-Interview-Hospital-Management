package com.interview.patientmanagementsystem.features.receptionist;

import java.util.Scanner;

public class ReceptionistView {

    Scanner scanner = new Scanner(System.in);

    int choice = -1;

    public void init(){

        while (true){
            System.out.println("=============== Receptionist Menu =========");
            System.out.println(" 1. Add patient");
            System.out.println(" 2. Book appointments");
            System.out.println(" 3. View Appointments");
            System.out.println(" 4. Remove patient");
            System.out.println(" 5. Main menu");
            System.out.println("Enter your choice");

            choice = scanner.nextInt();

            switch (choice){
                case 1:
                    addPatient();
                    break;
                case 2:
                    bookAppointment();
                    break;
                case 3:
                    viewAppointment();
                    break;
                case 4:
                    removePatient();
                    break;
                case 5:
                    menu();
                    break;
                default:
                    System.out.println("Please choice the vaild choice");
            }

        }

    }

    public void addPatient(){
        new ManagePatient().addPatient();
    }

    public void bookAppointment(){
        new ManagePatient().appointmentScheduling();
    }

    public void viewAppointment(){
        new ManagePatient().manageViewAppointment();
    }

    public void removePatient(){
        new ManagePatient().removePatient();
    }

    public void menu(){

    }
}
