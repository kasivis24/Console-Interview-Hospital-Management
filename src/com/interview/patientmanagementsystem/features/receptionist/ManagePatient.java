package com.interview.patientmanagementsystem.features.receptionist;

import com.interview.patientmanagementsystem.data.db.AppDb;
import com.interview.patientmanagementsystem.data.dto.Doctor;
import com.interview.patientmanagementsystem.data.dto.Patient;

import javax.print.Doc;
import java.io.IOException;
import java.util.*;

public class ManagePatient {

    private final AppDb appDb = AppDb.getInstance();
    Scanner scanner = new Scanner(System.in);

    public ManagePatient() throws IOException {
    }

    public void addPatient(){
        do {
            System.out.println("====================== Please Enter Patient Details ==============");
            System.out.println("Enter the patient Name");
            String name = scanner.nextLine();
            System.out.println("Enter the Age");
            int age = scanner.nextInt();
            System.out.println("Enter the Mobile Number");
            long mobileNumber = scanner.nextLong();
            scanner.nextLine();

            if (!name.isEmpty() && age >= 0 && String.valueOf(mobileNumber).length() == 10){
                String uId = UUID.randomUUID().toString();
                appDb.addPatient(new Patient(appDb.getPatientsList().size()+1,uId,name,age,mobileNumber,false));
                break;
            }else {
                System.out.println("Please enter vaild Details");
            }
        }while (true);
    }

    public void appointmentScheduling(){

        int time = 0;
        do {
            System.out.println("================= Doctor Appoi ntemnt Booking =============");
            System.out.println("Enter the time when your'e want to meet doctor : Time is between (1 to 24)h ");
            time = scanner.nextInt();
            displayDoctorAvaibleThatTime(time);
            break;
        }while (true);
    }

    public void displayDoctorAvaibleThatTime(int time){

        List<Doctor> displayData = new ArrayList<>();
        List<Patient> displayDataForPatient = new ArrayList<>();

        for (Doctor doctor : appDb.getDoctorList()){
            if (doctor.getAvalibleTime() == time && !doctor.getAvailableAppointment()){
                displayData.add(doctor);
            }
        }

        System.out.println("\tDocRecordId\tDoctorName\tDoctorPhoneNumber\tDoctorAvalibleTime");


        for (Doctor avalibleDoc : displayData){
            System.out.println("\t"+avalibleDoc.getRecordId()+"\t"+avalibleDoc.getName()+"\t"+avalibleDoc.getMobileNumber()+"\t"+avalibleDoc.getAvalibleTime());
        }

        System.out.println("Please choice the doctorRecordId :-");
        int recordIdDoc = scanner.nextInt();

        for (Patient patient : appDb.getPatientsList()){
            if (!patient.getAppointment()){
                displayDataForPatient.add(patient);
            }
        }

        System.out.println("\tRecordId\tPatientName\tpatinetAge\tPatinentPhoneNumber");

        for (Patient avaliblePat : displayDataForPatient){
            System.out.println("\t"+avaliblePat.getRecordNo()+"\t"+avaliblePat.getName()+"\t"+avaliblePat.getAge()+"\t"+avaliblePat.getPhoneNUmber()+"\t");
        }

        System.out.println("Please choice the patient Record Id");
        int recordIdPat = scanner.nextInt();

        if (appDb.getPatientsList().isEmpty() && appDb.getDoctorList().isEmpty()){
            System.out.println("Nodata found");
        }else {
            Patient choosenPat = appDb.getPatientsList().get(recordIdPat-1);
            Doctor choosenDoctor = appDb.getDoctorList().get(recordIdDoc-1);

            appDb.getDoctorList().get(recordIdDoc-1).setAvailableAppointment(true);
            appDb.getPatientsList().get(recordIdPat-1).setAppointment(true);

            assignDoctorBySpecAndTime(choosenPat,choosenDoctor);
        }


    }

    public void assignDoctorBySpecAndTime(Patient patient,Doctor doctor){
        appDb.setAppointment(patient,doctor);
    }


    public void displayAllPatientScheduled (){
        System.out.println("patientRecordId\tpatientName\tpatientPhoneNumber");
        for (Patient p : appDb.getPatientsList()){
            if (p.getAppointment()){
                System.out.println(p.getRecordNo()+"\t"+p.getName()+"\t"+p.getPhoneNUmber()+"\t"+p.getAppointment());
            }
        }
    }

    public void displayAppDoctorsScheduled(){
        System.out.println("DoctorsRecordedId\tDcotorname\tDoctorPhoneNumber\tisAvalibe");
        for (Doctor d : appDb.getDoctorList()){
            if (d.getAvailableAppointment()){
                System.out.println(d.getRecordId()+"\t"+d.getName()+"\t"+d.getMobileNumber()+"\t"+d.getAvailableAppointment());
            }
        }
    }

    public void patientAndDoctorWithDisplay(){
        System.out.println("DoctorsRecordedId\tDcotorname\tDoctorPhoneNumber\tChecking_patient_name");
        for (Map.Entry<Patient,Doctor> map : appDb.getDoctorAvalibilty().entrySet()){
            System.out.println(map.getValue().getRecordId()+"\t"+map.getValue().getName()+"\t"+map.getValue().getMobileNumber()+"\t"+map.getKey().getName());
        }
    }

    public void freeSlots(){
        for (Doctor d : appDb.getDoctorList()){
            if (!d.getAvailableAppointment()){
                System.out.println(d.getRecordId()+"\t"+d.getName()+"\t"+d.getMobileNumber()+"\t"+d.getAvailableAppointment());
            }
        }
    }



    public void manageViewAppointment(){
        int choice = -1;

        do{
            System.out.println("==================== Enter the choice to disply the doctors and patient data ===================== ");
            System.out.println("1. Appointment patient");
            System.out.println("2. Appointment Doctor");
            System.out.println("3. Free Doctor Slots");
            System.out.println("4. Patient and doctor Appointment BookedView");

            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    displayAllPatientScheduled();
                    break;
                case 2:
                    displayAppDoctorsScheduled();
                    break;
                case 3:
                    freeSlots();
                    break;
                case 4:
                    patientAndDoctorWithDisplay();
                default:
                    System.out.println("Enter vaild choice");
            }

        }while (true);


    }

    public void removePatient(){
        System.out.println("============ Choice Record Id For Remove Data ==============");

        int recordId = -1;
        System.out.println("patientRecordId\tpatientName\tpatientPhoneNumber");
        for (Patient p : appDb.getPatientsList()){
            System.out.println(p.getRecordNo()+"\t"+p.getName()+"\t"+p.getPhoneNUmber()+"\t"+p.getAppointment());
        }

        System.out.println("Enter the RecordId ");
        recordId = scanner.nextInt();

        appDb.removePatient(recordId-1);
    }




}
