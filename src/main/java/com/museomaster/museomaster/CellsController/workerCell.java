package com.museomaster.museomaster.CellsController;

import com.museomaster.museomaster.Models.Client;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class workerCell implements Initializable {
    public Label id_lbl;
    public Label name_lbl;
    public Label user_name_lbl;
    public Label phone_number_lbl;
    public Label job_lbl;
    public CheckBox add_task_checkbox;

    private ListView<Client> listView;
    private final Client client;

    public workerCell(Client client, ListView<Client> listView) {

        this.client = client;
        this.listView=listView;

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id_lbl.textProperty().bind(client.idPracownikaProperty().asString());
        name_lbl.textProperty().bind(client.imiePracownikaProperty());
        user_name_lbl.textProperty().bind(client.nazwaUzytkownikaProperty());
        phone_number_lbl.textProperty().bind(client.getNrTelefonu().asString());
        job_lbl.textProperty().bind(client.rolaProperty());
    }
}
