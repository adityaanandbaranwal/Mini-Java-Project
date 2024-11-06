package com.healthcare;

import com.healthcare.controller.AppointmentController;
import com.healthcare.controller.DoctorController;
import com.healthcare.controller.PatientController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/healthcare/MainApplication.fxml"));
        Parent root = loader.load();

        HelloController helloController = loader.getController();

        PatientController patientController = new PatientController();
        DoctorController doctorController = new DoctorController();
        AppointmentController appointmentController = new AppointmentController();

        helloController.setPatientController(patientController);
        helloController.setDoctorController(doctorController);
        helloController.setAppointmentController(appointmentController);

        primaryStage.setScene(new Scene(root));   
        primaryStage.setTitle("Smart Healthcare Management System");
        primaryStage.show();
    }

    public void switchToMain() {
        TabPane tabPane = new TabPane();
        tabPane.getSelectionModel().select(0);
    }
    public static void main(String[] args) {
        launch(args);
    }
}

