package com.interview.patientmanagementsystem.features.auth.login;

import com.interview.patientmanagementsystem.data.db.AppDb;
import com.interview.patientmanagementsystem.data.dto.LoginInfo;
import com.interview.patientmanagementsystem.data.dto.RegisterInfo;
import com.interview.patientmanagementsystem.features.receptionist.ReceptionistView;

import java.io.IOException;
import java.util.Scanner;
import java.util.UUID;

public class LoginView {

    Scanner scanner = new Scanner(System.in);
    int choioce = -1;

    public void init() throws IOException {
        getLoginDetails();
    }

    public void getLoginDetails() throws IOException {
        do {
            System.out.println("=================== Reception Login ==================");

            System.out.println("Enter Name");
            String name = scanner.nextLine();
            System.out.println("Enter password");
            String password = scanner.nextLine();

            if (!name.isEmpty() && !password.isEmpty()){
                if (processedLogin(new LoginInfo(name,password))){
                    break;
                }else {
                    System.out.println("Please enter vaild pasword an username ");
                }
            }else {
                System.out.println("Please Enter vaild username or password");
                continue;
            }
        }while (true);
    }

    private boolean processedLogin(LoginInfo loginInfo) throws IOException {
        if (AppDb.getInstance().receptionLogin(loginInfo)){
            System.out.println("reception auth succesfulluy");
            new ReceptionistView().init();
            return true;
        }else {
            return false;
        }
    }


}
