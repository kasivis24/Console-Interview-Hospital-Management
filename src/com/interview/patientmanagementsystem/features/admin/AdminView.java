package com.interview.patientmanagementsystem.features.admin;

import com.interview.patientmanagementsystem.features.auth.register.RegisterView;

import java.util.Scanner;

public class AdminView {

    Scanner scanner = new Scanner(System.in);

    int choice = -1;

    public void init(){
        adminMenu();
    }

    public void adminMenu(){

        while (true){

            System.out.println("========= Admin Menu ==========");

            System.out.println(" 1. Add Receptionist ");
            System.out.println(" 2. Add Doctor ");
            System.out.println(" 3. Manage Doctor Avalability");
            System.out.println(" 4. Or MainMenu");

            choice = scanner.nextInt();

            switch (choice){
                case 1 :
                    addReceptionist();
                    break;
                case 2 :
                    addDoctor();
                    break;
                case 3 :
                    manageDoctor();
                    break;
                case 4 :
                    mainMenu();
                    break;
                default:
                    System.out.println("Enetre vaild Choice");
            }
        }
    }


    public void addReceptionist(){
        RegisterView registerView = new RegisterView();
        registerView.RegisterDetails();
    }

    public void addDoctor(){
        ManageDoctor manageDoctor = new ManageDoctor();
        manageDoctor.addDoctor();
    }

    public void manageDoctor(){

    }

    public void mainMenu(){
        new RegisterView().init();
    }
}
