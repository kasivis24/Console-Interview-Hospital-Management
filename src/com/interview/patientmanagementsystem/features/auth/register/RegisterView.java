package com.interview.patientmanagementsystem.features.auth.register;

import com.interview.patientmanagementsystem.data.db.AppDb;
import com.interview.patientmanagementsystem.data.dto.LoginInfo;
import com.interview.patientmanagementsystem.data.dto.RegisterInfo;
import com.interview.patientmanagementsystem.features.admin.AdminView;
import com.interview.patientmanagementsystem.features.auth.login.LoginView;
import com.interview.patientmanagementsystem.features.baseview.BaseView;

import java.io.IOException;
import java.util.Scanner;
import java.util.UUID;

public class RegisterView extends BaseView {


    Scanner scanner = new Scanner(System.in);

    int choices = -1;


    public void init() throws IOException {
        while (true){
            System.out.println("============= Choice Receptionist or Admin ==================");

            System.out.println("1. Admin");
            System.out.println("2. Receptionist");
            System.out.println("3. Exit");

            choices = scanner.nextInt();


            switch (choices){
                case 1:
                    AdminView adminView = new AdminView();
                    adminView.init();
                    break;
                case 2:
                    LoginView loginView = new LoginView();
                    loginView.init();
                    break;
                case 3:
                    exit();
                default:
                    inVaildation();
            }

        }
    }


    public void RegisterDetails() throws IOException {
        do {
            System.out.println("=================== Reception Register ==================");
            System.out.println("Enter Name");
            String name = scanner.nextLine();
            System.out.println("Enter password");
            String password = scanner.nextLine();

            if (!name.isEmpty() && !password.isEmpty()){
                String generateUid = UUID.randomUUID().toString();
                processedRegister(new RegisterInfo(name,password,generateUid));
                break;
            }else {
                System.out.println("Please Enter vaild username or password");
                continue;
            }
        }while (true);

    }

    public void processedRegister(RegisterInfo registerInfo) throws IOException {
        AppDb.getInstance().addUser(registerInfo);
        System.out.println("Receptionist Added Succesfully");

    }

}
