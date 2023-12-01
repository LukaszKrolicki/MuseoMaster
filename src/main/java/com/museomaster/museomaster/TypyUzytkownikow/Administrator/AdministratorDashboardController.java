package com.museomaster.museomaster.TypyUzytkownikow.Administrator;

import com.museomaster.museomaster.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class AdministratorDashboardController implements Initializable {

    public BorderPane adminParent;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().addListener(
                ((observableValue, oldVal, newVal) ->{
                    switch(newVal){
                        case "add_place"->adminParent.setCenter(Model.getInstance().getViewFactory().getAdminView("/Fxml/Administrator/AdminAddRoom.fxml", "addRoomView"));
                        case "user_list" ->adminParent.setCenter(Model.getInstance().getViewFactory().getAdminView("/Fxml/Administrator/AdminUserList.fxml", "userListView"));
                        case "reportListView"->adminParent.setCenter(Model.getInstance().getViewFactory().getAdminView("/Fxml/Administrator/AdminReportList.fxml", "reportListView"));
                        default -> adminParent.setCenter(Model.getInstance().getViewFactory().getAdminView("/Fxml/Administrator/AdminAddUser.fxml", "x"));
                    }
                } )
        );

    }
}
