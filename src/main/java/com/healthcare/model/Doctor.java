package com.healthcare.model;

public class Doctor {
    private String doctorId;        // Unique ID for the doctor
    private String name;            // Name of the doctor
    private String specialization;   // Specialization of the doctor
    private String contactNumber;    // Contact number of the doctor
    private String availability;      // Availability status (e.g., available, not available)

    // Default constructor
    public Doctor() {}

    // Getters and Setters
    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }
}
