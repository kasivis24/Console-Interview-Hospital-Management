package com.interview.patientmanagementsystem.data.db;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.interview.patientmanagementsystem.data.dto.Doctor;
import com.interview.patientmanagementsystem.data.dto.LoginInfo;
import com.interview.patientmanagementsystem.data.dto.Patient;
import com.interview.patientmanagementsystem.data.dto.RegisterInfo;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppDb {
    private static AppDb appDb;

    private List<RegisterInfo> registerInfoList = new ArrayList<>();

    private static List<Patient> patientsList = new ArrayList<>();

    private static List<Doctor> doctorsList = new ArrayList<>();

    private static Map<Patient,Doctor> doctorAvalibilty = new HashMap<>();

    private static Gson gson = new Gson();

    private FileWriter writerPatient = new FileWriter("pat.json");

    private FileWriter writerDoctor = new FileWriter("doc.json");

    private FileWriter writerDocAvalibilty = new FileWriter("docAva.json");

    private AppDb() throws IOException {

    }

    public static AppDb getInstance() throws IOException {
        if (appDb == null){
            appDb = new AppDb();
            readDataFromFiles();
        }
        return appDb;
    }


    public static void readDataFromFiles(){
        try (FileReader reader = new FileReader("pat.json")) {
            Type listType = new TypeToken<List<Patient>>() {}.getType();
            List<Patient> patientsTemp = gson.fromJson(reader, listType);
            for (Patient data : patientsTemp) {
                System.out.println("Name: " + data.getName() + ", Age: " + data.getAge());
            }

            if (!patientsTemp.isEmpty()){
                patientsList = patientsTemp;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileReader reader = new FileReader("doc.json")) {
            Type listType = new TypeToken<List<Doctor>>() {}.getType();
            List<Doctor> docTemp = gson.fromJson(reader, listType);
            for (Doctor data : docTemp) {
                System.out.println("Name: " + data.getName() + ", Age: " + data.getSpecialization());
            }

            if (!docTemp.isEmpty()){
                doctorsList = docTemp;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }



    }


    public void addUser(RegisterInfo registerInfo){
        registerInfoList.add(registerInfo);
    }

    public boolean receptionLogin(LoginInfo loginInfo){
       for (RegisterInfo registerInfo : registerInfoList){
           if (registerInfo.getUserName().equals(loginInfo.getUserName()) && registerInfo.getPassword().equals(loginInfo.getPassword())){
               return true;
           }
       }
       return false;
    }

    public void addPatient(Patient patient){
        patientsList.add(patient);
    }

    public void addDoctor(Doctor doctor){
        doctorsList.add(doctor);
    }

    public List<Patient> getPatientsList(){
        return patientsList;
    }

    public List<Doctor> getDoctorList(){
        return doctorsList;
    }

    public Map<Patient,Doctor> getDoctorAvalibilty(){
        return doctorAvalibilty;
    }

    public void setAppointment(Patient patient,Doctor doctor){
        doctorAvalibilty.put(patient,doctor);
        System.out.println(doctorAvalibilty);
    }

    public void removePatient(int recordId){
        patientsList.remove(recordId);
    }


    public void storeInFile(){


        Gson prettyGsonPatient = new GsonBuilder().setPrettyPrinting().create();
        prettyGsonPatient.toJson(patientsList, writerPatient);


        Gson prettyGsonDoc = new GsonBuilder().setPrettyPrinting().create();
        prettyGsonDoc.toJson(doctorsList, writerDoctor);

        Gson prettyGsonDocAva = new GsonBuilder().setPrettyPrinting().create();
        prettyGsonDocAva.toJson(doctorAvalibilty, writerDocAvalibilty);

    }

}
