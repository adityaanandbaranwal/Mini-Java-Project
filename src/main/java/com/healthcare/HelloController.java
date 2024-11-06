package com.healthcare;

import com.healthcare.controller.AppointmentController;
import com.healthcare.controller.DoctorController;
import com.healthcare.controller.PatientController;
import com.healthcare.model.Patient;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TabPane;

public class HelloController {

    @FXML
    private TabPane tabPane;

    private PatientController patientController;
    private DoctorController doctorController;
    private AppointmentController appointmentController;

    public void setPatientController(PatientController patientController) {
        this.patientController = patientController;
        this.patientController.setApp(this);
    }

    public void setDoctorController(DoctorController doctorController) {
        this.doctorController = doctorController;
        this.doctorController.setApp(this);
    }

    public void setAppointmentController(AppointmentController appointmentController) {
        this.appointmentController = appointmentController;
        this.appointmentController.setApp(this);
    }

    @FXML
    private void handleBackButtonAction() {
        showAlert("Back", "Back button clicked.");
    }


    @FXML
    private void handleRegister() {
        if (patientController != null) {
            patientController.handlePRegister();
        }
    }

    @FXML
    private void handleBookAppointment() {
        if (appointmentController != null) {
            appointmentController.handleBookAppointment();
        }
    }

    @FXML
    private void handleRegisterDoctor() {
        if (doctorController != null) {
            doctorController.handleRegisterDoctor();
        }
    }
    public void switchToMain() {
        tabPane.getSelectionModel().select(0);
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
