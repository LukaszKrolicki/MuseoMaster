package com.museomaster.museomaster.Views;

import com.museomaster.museomaster.TypyUzytkownikow.Administrator.AdministratorDashboardController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ViewFactory {

    private AnchorPane dashboardView;

    public ViewFactory(){

    }

    @FXML
    public void showLoginWindow(){
        System.out.println(getClass().getResource("Fxml/Login.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Login.fxml"));
        createStage(loader);
    }

//    public AnchorPane getAdminAddUser(){
//        if(dashboardView==null){
//            try{
//                dashboardView = new FXMLLoader(getClass().getResource("/Fxml/Administrator/AdminAddUser.fxml")).load();
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        }
//
//        return dashboardView;
//    }

    public void showAdminWindow(){
        System.out.println(getClass().getResource("/Fxml/Administrator/AdminDashboard.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Administrator/AdminDashboard.fxml"));
        AdministratorDashboardController adminController = new AdministratorDashboardController();
        loader.setController(adminController);
        createStage(loader);

    }

    private static void createStage(FXMLLoader loader) {
        Scene scene = null;

        try{
            scene = new Scene(loader.load());
        }
        catch(Exception e){
            e.printStackTrace();
        }

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("MuesoMaster");
        stage.show();
    }
}
