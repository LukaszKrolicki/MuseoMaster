package com.museomaster.museomaster.CellsController;

import com.museomaster.museomaster.Models.Client;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

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

    public UserCell(Client client) {
        this.client = client;
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
    }
}
