package com.example.payrollpage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PayrollEditorApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PayrollEditorApplication.class.getResource("payrollEditor.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Payroll Editor");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}