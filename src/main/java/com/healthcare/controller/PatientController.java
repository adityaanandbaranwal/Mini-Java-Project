package com.healthcare.controller;

import com.healthcare.HelloController;
import com.healthcare.model.Patient;
import com.healthcare.service.PatientService;
import com.healthcare.HelloApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PatientController {

    private HelloController app;
    private PatientService patientService = new PatientService();

    @FXML
    public TextField patientNameField; // Updated id to match MainApplication.fxml
    @FXML
    private TextField medicalHistoryField;
    @FXML
    private TextField ongoingTreatmentsField;
    @FXML
    private TextField allergiesField;
    @FXML
    private TextField emergencyContactField;
    @FXML
    private Button backButton;

    public void setApp(HelloController app) {
        this.app = app;
    }

    @FXML
    public void handlePRegister() {
        if (patientNameField.getText().isEmpty() || medicalHistoryField.getText().isEmpty() ||
                ongoingTreatmentsField.getText().isEmpty() || allergiesField.getText().isEmpty() ||
                emergencyContactField.getText().isEmpty()) {
            showAlert("Error", "Please fill in all fields.");
            return;
        }

        Patient patient = new Patient();
        patient.setId(generatePatientId());
        patient.setName(patientNameField.getText());
        patient.setMedicalHistory(medicalHistoryField.getText());
        patient.setOngoingTreatments(ongoingTreatmentsField.getText());
        patient.setAllergies(allergiesField.getText());
        patient.setEmergencyContact(emergencyContactField.getText());

        patientService.registerPatient(patient);
        showAlert("Success", "Patient registered successfully!");
        clearFields();
    }

    @FXML
    private void handleBackToMain() {
        app.switchToMain(); // Ensure this method is implemented if necessary
    }

    private String generatePatientId() {
        return "PAT" + System.currentTimeMillis();
    }

    private void clearFields() {
        patientNameField.clear();
        medicalHistoryField.clear();
        ongoingTreatmentsField.clear();
        allergiesField.clear();
        emergencyContactField.clear();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

