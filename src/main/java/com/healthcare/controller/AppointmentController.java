package com.healthcare.controller;

import com.healthcare.HelloApplication;
import com.healthcare.HelloController;
import com.healthcare.model.Appointment;
import com.healthcare.model.Doctor;
import com.healthcare.service.AppointmentService;
import com.healthcare.service.DoctorService;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.List;

public class AppointmentController {

    private HelloController app;
    private AppointmentService appointmentService = new AppointmentService();
    private DoctorService doctorService = new DoctorService();

    @FXML
    private ComboBox<String> doctorComboBox;
    @FXML
    private TextField appointmentPatientIdField; // Updated id to match MainApplication.fxml
    @FXML
    private DatePicker datePicker;
    @FXML
    private Button backButton;

    public void setApp(HelloController app) {
        this.app = app;
    }

    @FXML
    private void initialize() {
        populateDoctorComboBox();
    }

    @FXML
    private void handleBackToMain() {
        app.switchToMain(); // Ensure this method is implemented if necessary
    }

    private void populateDoctorComboBox() {
        List<Doctor> doctors = doctorService.getDoctors();
        for (Doctor doctor : doctors) {
            if ("Available".equals(doctor.getAvailability())) {
                doctorComboBox.getItems().add(doctor.getName());
            }
        }
    }

    @FXML
    public void handleBookAppointment() {
        if (appointmentPatientIdField.getText().isEmpty() || doctorComboBox.getValue() == null || datePicker.getValue() == null) {
            showAlert("Error", "Please fill in all fields.");
            return;
        }

        Appointment appointment = new Appointment();
        appointment.setPatientId(appointmentPatientIdField.getText());
        appointment.setDoctorId(doctorComboBox.getValue());
        appointment.setAppointmentTime(datePicker.getValue().toString());
        appointment.setStatus("scheduled");

        appointmentService.bookAppointment(appointment);
        showAlert("Success", "Appointment booked successfully!");
        clearFields();
    }

    private void clearFields() {
        appointmentPatientIdField.clear();
        doctorComboBox.setValue(null);
        datePicker.setValue(null);
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
