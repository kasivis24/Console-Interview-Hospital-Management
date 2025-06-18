package com.interview.patientmanagementsystem.features.admin;

import com.interview.patientmanagementsystem.data.type.AvailableType;
import com.interview.patientmanagementsystem.data.db.AppDb;
import com.interview.patientmanagementsystem.data.dto.Doctor;

import java.util.Scanner;
import java.util.UUID;

public class ManageDoctor {
    Scanner scanner = new Scanner(System.in);
    private final AppDb appDb = AppDb.getInstance();


    public void addDoctor(){

        while (true){
            System.out.println("=================== Enter The Doctor Details ===================");
            System.out.println("Enter the Doctor Name");
            String doctorName = scanner.nextLine();
            System.out.println("Enter the Doctor PhoneNUmber");
            String doctorMobileNumber = scanner.nextLine();
            System.out.println("Enter the Doctor Avalible 1. Morning or 2. Afternoon or 3. Specfic Time ");
            int avalibleDoctorTime = scanner.nextInt();
            scanner.nextLine();
            int time = 0;
            AvailableType availableType;
            if (avalibleDoctorTime == 1){
                availableType = AvailableType.MORNING;
            }else if (avalibleDoctorTime == 2){
                availableType = AvailableType.AFTERNOON;
            }else {
                System.out.println("Enter Doctor Time Every doctor spend the every patient with one hour (1-24) ex:- 24 patient evrryday");
                do {
                    try {
                        time = scanner.nextInt();
                        if (time < 0 || time > 2359)
                            System.out.println("Time should be between 1 and 24\nEnter valid time:");
                        else break;
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid time\nEnter valid time:");
                    }
                } while (true);
                availableType = AvailableType.SPECFIC_HOURS;
            }
            scanner.nextLine();
            System.out.println("Enter the doctor Speclizations");
            String doctorSpecialization = scanner.nextLine();

            if (!doctorName.isEmpty() && !doctorMobileNumber.isEmpty() && !String.valueOf(time).isEmpty()){
                String uId = UUID.randomUUID().toString();
                appDb.addDoctor(new Doctor(appDb.getDoctorList().size()+1,uId,doctorName,doctorMobileNumber,availableType,false,doctorSpecialization,availableType == AvailableType.SPECFIC_HOURS ? time : availableType == AvailableType.MORNING ? 6 : 12));
                System.out.println("Doctor Added Succesfully");
                break;
            }
        }

    }
}
