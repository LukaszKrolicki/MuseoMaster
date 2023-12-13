package com.museomaster.museomaster.CellsController;

import com.museomaster.museomaster.Models.Exhibit;
import com.museomaster.museomaster.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class WyborZabytkuCell implements Initializable {
    public Button ex_desc_btn;
    public CheckBox ex_checkbox;
    public Label ex_name;
    public Label ex_subject;
    public Label id_zad;

    private ListView<Exhibit> listView;

    private final Exhibit exhibit;

    boolean permissionFlag=false;

    public WyborZabytkuCell(Exhibit exhibit, ListView<Exhibit> listView) {
        this.exhibit = exhibit;
        this.listView = listView;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id_zad.textProperty().bind(exhibit.idZabytkuProperty().asString());
        ex_name.textProperty().bind(exhibit.nazwa_zabytku_tfProperty());
        ex_subject.textProperty().bind(exhibit.tematyka_tfProperty());

        ex_desc_btn.setOnAction(e-> Model.getInstance().getViewFactory().showExDescWindow(exhibit));
        ex_checkbox.setSelected(exhibit.getChecked());

        ex_checkbox.selectedProperty().addListener((observableValue, oldVal, newVal) -> {
                    permissionFlag=newVal;
                    if(permissionFlag){
                        Model.getInstance().assignEx(exhibit);
                        exhibit.setChecked(true);
                    }
                    else{
                        Model.getInstance().removeEx(exhibit);
                        exhibit.setChecked(false);

                    }
                }
        );
    }
    }

