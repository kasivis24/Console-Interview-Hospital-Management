package com.interview.patientmanagementsystem.data.db;

import com.interview.patientmanagementsystem.data.dbconfig.DBConnection;
import com.interview.patientmanagementsystem.data.dto.Appointment;
import com.interview.patientmanagementsystem.data.dto.Doctor;
import com.interview.patientmanagementsystem.data.dto.Patient;
import com.interview.patientmanagementsystem.data.dto.Receptionist;
import com.interview.patientmanagementsystem.data.type.AvailableType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppDb {
    private static AppDb instance = null;
    private Connection conn;

    private AppDb() throws SQLException {
        conn = DBConnection.getConnection();
    }

    public static AppDb getInstance() throws SQLException {
        if (instance == null) instance = new AppDb();
        return instance;
    }

    public List<Doctor> searchDoctorsByName(String name) throws SQLException {
        String sql = "SELECT * FROM doctors WHERE name LIKE ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, "%" + name + "%");
        ResultSet rs = stmt.executeQuery();

        List<Doctor> list = new ArrayList<>();
        while (rs.next()) {
            Doctor d = new Doctor();
            d.setId(rs.getInt("id"));
            d.setName(rs.getString("name"));
            d.setPhone(rs.getString("phone"));
            d.setSpecialization(rs.getString("specialization"));
            d.setAvailabilityType(AvailableType.valueOf(rs.getString("availability_type")));
            d.setStartTime(rs.getString("start_time"));
            d.setEndTime(rs.getString("end_time"));
            list.add(d);
        }
        return list;
    }

    public List<Patient> searchPatientsByName(String name) throws SQLException {
        String sql = "SELECT * FROM patients WHERE name LIKE ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, "%" + name + "%");
        ResultSet rs = stmt.executeQuery();

        List<Patient> list = new ArrayList<>();
        while (rs.next()) {
            Patient p = new Patient();
            p.setId(rs.getInt("id"));
            p.setName(rs.getString("name"));
            p.setAge(rs.getInt("age"));
            p.setPhone(rs.getString("phone"));
            list.add(p);
        }
        return list;
    }


    public List<Appointment> getAppointmentsByPatient(int patientId) throws SQLException {
        String sql = "SELECT * FROM appointments WHERE patient_id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, patientId);
        ResultSet rs = stmt.executeQuery();
        List<Appointment> list = new ArrayList<>();
        while (rs.next()) {
            Appointment a = new Appointment();
            a.setId(rs.getInt("id"));
            a.setDoctorId(rs.getInt("doctor_id"));
            a.setPatientId(rs.getInt("patient_id"));
            a.setDateTime(rs.getString("datetime"));
            list.add(a);
        }
        return list;
    }

    public List<Appointment> getAllAppointments() throws SQLException {
        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM appointments");
        List<Appointment> list = new ArrayList<>();
        while (rs.next()) {
            Appointment a = new Appointment();
            a.setId(rs.getInt("id"));
            a.setDoctorId(rs.getInt("doctor_id"));
            a.setPatientId(rs.getInt("patient_id"));
            a.setDateTime(rs.getString("datetime"));
            list.add(a);
        }
        return list;
    }

    public Doctor getDoctorById(int id) throws SQLException {
        String sql = "SELECT * FROM doctors WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            Doctor d = new Doctor();
            d.setId(rs.getInt("id"));
            d.setName(rs.getString("name"));
            d.setPhone(rs.getString("phone"));
            d.setSpecialization(rs.getString("specialization"));
            d.setAvailabilityType(AvailableType.valueOf(rs.getString("availability_type")));
            d.setStartTime(rs.getString("start_time"));
            d.setEndTime(rs.getString("end_time"));
            return d;
        }
        return null;
    }


    public void addDoctor(Doctor doctor) throws SQLException {
        String sql = "INSERT INTO doctors (name, phone, specialization, availability_type, start_time, end_time) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, doctor.getName());
        stmt.setString(2, doctor.getPhone());
        stmt.setString(3, doctor.getSpecialization());
        stmt.setString(4, doctor.getAvailabilityType().toString());
        stmt.setString(5, doctor.getStartTime());
        stmt.setString(6, doctor.getEndTime());
        stmt.executeUpdate();
    }

    public List<Doctor> getAllDoctors() throws SQLException {
        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM doctors");
        List<Doctor> list = new ArrayList<>();
        while (rs.next()) {
            Doctor d = new Doctor();
            d.setId(rs.getInt("id"));
            d.setName(rs.getString("name"));
            d.setPhone(rs.getString("phone"));
            d.setSpecialization(rs.getString("specialization"));
            d.setAvailabilityType(AvailableType.valueOf(rs.getString("availability_type")));
            d.setStartTime(rs.getString("start_time"));
            d.setEndTime(rs.getString("end_time"));
            list.add(d);
        }
        return list;
    }

    public void registerReceptionist(Receptionist r) throws SQLException {
        String sql = "INSERT INTO receptionists (username, password) VALUES (?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, r.getUsername());
        stmt.setString(2, r.getPassword());
        stmt.executeUpdate();
    }

    public void removeReceptionist(String username) throws SQLException {
        String sql = "DELETE FROM receptionists WHERE username = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, username);
        stmt.executeUpdate();
    }

    public boolean loginReceptionist(String username, String password) throws SQLException {
        String sql = "SELECT * FROM receptionists WHERE username = ? AND password = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, username);
        stmt.setString(2, password);
        ResultSet rs = stmt.executeQuery();
        return rs.next();
    }

    public void addPatient(Patient patient) throws SQLException {
        String sql = "INSERT INTO patients (name, age, phone) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, patient.getName());
        stmt.setInt(2, patient.getAge());
        stmt.setString(3, patient.getPhone());
        stmt.executeUpdate();
    }

    public List<Patient> getAllPatients() throws SQLException {
        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM patients");
        List<Patient> list = new ArrayList<>();
        while (rs.next()) {
            Patient p = new Patient();
            p.setId(rs.getInt("id"));
            p.setName(rs.getString("name"));
            p.setAge(rs.getInt("age"));
            p.setPhone(rs.getString("phone"));
            list.add(p);
        }
        return list;
    }

    public void scheduleAppointment(Appointment a) throws SQLException {
        String sql = "INSERT INTO appointments (doctor_id, patient_id, datetime) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, a.getDoctorId());
        stmt.setInt(2, a.getPatientId());
        stmt.setString(3, a.getDateTime());
        stmt.executeUpdate();
    }

    public List<Appointment> getAppointmentsForDoctor(int doctorId) throws SQLException {
        String sql = "SELECT * FROM appointments WHERE doctor_id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, doctorId);
        ResultSet rs = stmt.executeQuery();
        List<Appointment> list = new ArrayList<>();
        while (rs.next()) {
            Appointment a = new Appointment();
            a.setId(rs.getInt("id"));
            a.setDoctorId(rs.getInt("doctor_id"));
            a.setPatientId(rs.getInt("patient_id"));
            a.setDateTime(rs.getString("datetime"));
            list.add(a);
        }
        return list;
    }

    public void removePatientById(int patientId) throws SQLException {
        String sql = "DELETE FROM patients WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, patientId);
        stmt.executeUpdate();
    }


    public List<Appointment> getAppointmentsForPatient(int patientId) {
        List<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT * FROM appointments WHERE patient_id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, patientId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Appointment a = new Appointment(
                        rs.getInt("doctor_id"),
                        rs.getInt("patient_id"),
                        rs.getString("date_time")
                );
                a.setId(rs.getInt("id"));
                appointments.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointments;
    }

    public List<String> getAvailableSlots(int doctorId) {
        List<String> allSlots = List.of(
                "2025-06-19 09:00", "2025-06-19 10:00", "2025-06-19 11:00",
                "2025-06-19 12:00", "2025-06-19 13:00", "2025-06-19 14:00"
        );

        List<String> booked = new ArrayList<>();
        String sql = "SELECT date_time FROM appointments WHERE doctor_id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, doctorId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                booked.add(rs.getString("date_time"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<String> available = new ArrayList<>(allSlots);
        available.removeAll(booked);
        return available;
    }





}