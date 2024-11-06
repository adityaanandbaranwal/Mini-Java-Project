module com.healthcare {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens com.healthcare to javafx.fxml;
    exports com.healthcare;

    opens com.healthcare.controller to javafx.fxml; // Opens the controller package for FXML
    opens com.healthcare.model to javafx.fxml; // If you have models you want to use with FXML

    exports com.healthcare.controller; // Exports the controller package if needed
    exports com.healthcare.model;
}