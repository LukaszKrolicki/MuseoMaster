package com.museomaster.museomaster;

import com.museomaster.museomaster.Models.Model;
import javafx.application.Application;
import javafx.stage.Stage;
//Main application
public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Model.getInstance().getViewFactory().showLoginWindow();
    }

    public static void main(String[] args) {
        launch();
    }
}
