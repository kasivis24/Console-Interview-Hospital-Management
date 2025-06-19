package com.interview.patientmanagementsystem.data.dto;

public class Patient {
    private int id;
    private String name;
    private int age;
    private String phone;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    @Override
    public String toString() {
        return String.format("%-5d %-20s %-5d %-15s",
                id, name, age, phone);
    }

}