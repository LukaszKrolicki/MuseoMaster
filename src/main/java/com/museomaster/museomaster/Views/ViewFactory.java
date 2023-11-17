package com.museomaster.museomaster.Views;

import com.museomaster.museomaster.TypyUzytkownikow.Administrator.AdministratorDashboardController;
import com.museomaster.museomaster.TypyUzytkownikow.Pracownik.PracownikController;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ViewFactory {


    private final StringProperty adminSelectedMenuItem;

    public ViewFactory(){
        this.adminSelectedMenuItem=new SimpleStringProperty("");
    }


    public void showLoginWindow(){
        System.out.println(getClass().getResource("Fxml/Login.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Login.fxml"));
        createStage(loader);
    }


    public StringProperty getAdminSelectedMenuItem(){
        return adminSelectedMenuItem;
    }


    private AnchorPane view;

    //Admin Views
    ////////////////////////////////////////////////////////////////////////

    public void showAdminWindow(){
        System.out.println(getClass().getResource("/Fxml/Administrator/AdminDashboard.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Administrator/AdminDashboard.fxml"));
        AdministratorDashboardController adminController = new AdministratorDashboardController();
        loader.setController(adminController);
        createStage(loader);

    }
    private AnchorPane dashboardView;
    private AnchorPane addRoomView;

    private AnchorPane userListView;
    private AnchorPane ReportListView;

    public AnchorPane getAdminView(String fxmlPath, String anchorPaneName){


        switch (anchorPaneName){
            case "addRoomView" -> view=dashboardView;
            case "userListView" -> view=userListView;
            case "reportListView" -> view=ReportListView;
            default -> view=dashboardView;
        }

        if(view==null){
            try{
                view = new FXMLLoader(getClass().getResource(fxmlPath)).load();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return view;
    }
    ////////////////////////////////////////////////////////////////



    //Normal WorkerViews
    ////////////////////////////////////////////////////////////////

    public void showWorkerWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Pracownik/Pracownik.fxml"));
        PracownikController pracownikController = new PracownikController();
        loader.setController(pracownikController);
        createStage(loader);

    }

    ////////////////////////////////////////////////////////////////

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

    public void closeStage(Stage stage){
        stage.close();
    }


}
