package com.example.imp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    private static Stage stage;

    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main-page.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static <T> T setRoot(String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource(fxml + ".fxml"));
        Parent root = loader.load();
        stage.getScene().setRoot(root);
        @SuppressWarnings("unchecked")
        T controller = (T) loader.getController();
        return controller;
    }

    public static void main(String[] args) {
        launch();
    }
}