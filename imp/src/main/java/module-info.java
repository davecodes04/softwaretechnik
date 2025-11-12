module com.example.imp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.imp to javafx.fxml;
    exports com.example.imp;
}