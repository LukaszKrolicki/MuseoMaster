package com.museomaster.museomaster.CellsController;

import com.museomaster.museomaster.Models.Exhibit;
import com.museomaster.museomaster.Models.Model;
import com.museomaster.museomaster.TypyUzytkownikow.Kurator.ListaZabytkowController;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class ExhibitCell implements Initializable {
    private final Exhibit exhibit;
    public Button edit_btn;
    public Button opis_btn;

    private ListView<Exhibit> listView;

    public Label id_zab;
    public Label nazwa_zab;
    public Label tematyka_zab;
    public Button usun_btn;


    public ExhibitCell(Exhibit exhibit, ListView<Exhibit> listView) {
        this.exhibit = exhibit;
        this.listView = listView;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id_zab.textProperty().bind(exhibit.idZabytkuProperty().asString());
        nazwa_zab.textProperty().bind(exhibit.nazwa_zabytku_tfProperty());
        tematyka_zab.textProperty().bind(exhibit.tematyka_tfProperty());
        usun_btn.setOnAction(e -> onDelete());
        opis_btn.setOnAction(e -> Model.getInstance().getViewFactory().showExDescWindow(exhibit));
        edit_btn.setOnAction(e -> onEdit());
    }
    private void onDelete(){
        Model.getInstance().getDataBaseDriver().deleteExhibit(Integer.parseInt(id_zab.getText()));
        listView.getItems().remove(exhibit);
        listView.refresh();

    }
    private void onEdit(){
        Model.getInstance().getViewFactory().showExEditWindow(exhibit);
        if(Model.getInstance().getDataBaseDriver().geteditExhibitSuccessFlag()){
            listView.refresh();
        }
    }
}
