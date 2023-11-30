package com.museomaster.museomaster.TypyUzytkownikow.Administrator;

import com.museomaster.museomaster.CellsController.UserCell;
import com.museomaster.museomaster.CellsController.UserCellFactory;
import com.museomaster.museomaster.Models.Client;
import com.museomaster.museomaster.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminUserListController implements Initializable {
    public ListView<Client> user_list;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initData();
        user_list.setItems(Model.getInstance().getClients());
        user_list.setCellFactory(e->new UserCellFactory());
    }

    private void initData(){
        if(Model.getInstance().getClients().isEmpty()){
            Model.getInstance().setClient();
        }
    }
}
