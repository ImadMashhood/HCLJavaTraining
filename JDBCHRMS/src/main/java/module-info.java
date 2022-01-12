module com.example.payrollpage {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    requires java.sql;


    opens com.example.payrollpage to javafx.fxml;
    exports com.example.payrollpage;
}