package com.healthcare.model;

public class Patient {
    private String id;
    private String name;
    private String medicalHistory;
    private String ongoingTreatments;
    private String allergies;
    private String emergencyContact;

    public Patient() {}

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getOngoingTreatments() {
        return ongoingTreatments;
    }

    public void setOngoingTreatments(String ongoingTreatments) {
        this.ongoingTreatments = ongoingTreatments;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }
}
