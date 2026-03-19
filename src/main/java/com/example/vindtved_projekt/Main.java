package com.example.vindtved_projekt;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends  Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Vindtved.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Vindtved-Projekt");
        stage.setScene(scene);
        stage.show();
    }
    /*
    public static void main(String[] args) {
        Application.launch(args);
    }
    */
}
