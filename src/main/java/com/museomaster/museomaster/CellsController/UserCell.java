package com.museomaster.museomaster.CellsController;

import com.museomaster.museomaster.Models.Client;
import com.museomaster.museomaster.Models.Model;
import com.museomaster.museomaster.Views.ViewFactory;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class UserCell implements Initializable {

    private final Client client;
    public Label id_lbl;
    public Label name_lbl;
    public Label user_name_lbl;
    public Label phone_number_lbl;
    public Label email_lbl;
    public Label job_lbl;
    public Label permission_lbl;
    public Button delete_btn;
    private ListView<Client> listView;

    public UserCell(Client client, ListView<Client> listView) {

        this.client = client;
        this.listView=listView;

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id_lbl.textProperty().bind(client.idPracownikaProperty().asString());
        name_lbl.textProperty().bind(client.imiePracownikaProperty());
        user_name_lbl.textProperty().bind(client.nazwaUzytkownikaProperty());
        phone_number_lbl.textProperty().bind(client.getNrTelefonu().asString());
        email_lbl.textProperty().bind(client.emailPracownikaProperty());
        job_lbl.textProperty().bind(client.rolaProperty());
        permission_lbl.textProperty().bind(client.czyUprawnionyProperty().asString());
        delete_btn.setOnAction(e->onDelete());
    }

    private void onDelete(){
        Model.getInstance().getDataBaseDriver().deleteClient(Integer.parseInt(id_lbl.getText()));
        listView.getItems().remove(client);
        listView.refresh();


    }
}
