package com.healthcare.controller;

import com.healthcare.HelloApplication;
import com.healthcare.HelloController;
import com.healthcare.model.Doctor;
import com.healthcare.service.DoctorService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class DoctorController {

    private HelloController app;
    private DoctorService doctorService = new DoctorService();

    @FXML
    private Button backButton;
    @FXML
    private TextField doctorIdField;
    @FXML
    private TextField doctorNameField; // Updated id to match MainApplication.fxml
    @FXML
    private TextField specializationField;
    @FXML
    private TextField contactNumberField;
    @FXML
    private ComboBox<String> availabilityComboBox;

    public void setApp(HelloController app) {
        this.app = app;
    }

    @FXML
    private void initialize() {
        availabilityComboBox.getItems().addAll("Available", "Not Available");
    }

    @FXML
    private void handleBackToMain() {
        app.switchToMain(); // Ensure this method is implemented if necessary
    }

    @FXML
    public void handleRegisterDoctor() {
        if (doctorIdField.getText().isEmpty() || doctorNameField.getText().isEmpty() ||
                specializationField.getText().isEmpty() || contactNumberField.getText().isEmpty() ||
                availabilityComboBox.getValue() == null) {
            showAlert("Error", "Please fill in all fields.");
            return;
        }

        Doctor doctor = new Doctor();
        doctor.setDoctorId(doctorIdField.getText());
        doctor.setName(doctorNameField.getText());
        doctor.setSpecialization(specializationField.getText());
        doctor.setContactNumber(contactNumberField.getText());
        doctor.setAvailability(availabilityComboBox.getValue());

        doctorService.addDoctor(doctor);
        showAlert("Success", "Doctor registered successfully!");
        clearFields();
    }

    private void clearFields() {
        doctorIdField.clear();
        doctorNameField.clear();
        specializationField.clear();
        contactNumberField.clear();
        availabilityComboBox.setValue(null);
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
