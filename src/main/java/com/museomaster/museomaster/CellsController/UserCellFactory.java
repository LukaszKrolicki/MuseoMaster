package com.museomaster.museomaster.CellsController;

import com.museomaster.museomaster.Models.Client;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

public class UserCellFactory extends ListCell<Client> {
    @Override
    protected void updateItem(Client client, boolean empty) {
        super.updateItem(client, empty);
        if(empty) {
            setText(null);
            setGraphic(null);
        }
        else{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Administrator/AdminCells/UserCell.fxml"));
            UserCell controler = new UserCell(client);
            loader.setController(controler);
            setText(null);
            try{
                setGraphic(loader.load());
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}