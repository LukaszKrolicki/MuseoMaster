package com.museomaster.museomaster.TypyUzytkownikow.Utils;

import com.museomaster.museomaster.CellsController.workerCellFactory;
import com.museomaster.museomaster.Models.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class PracownikUprawnionyPrzydzielZadanie implements Initializable {
    public TextField input_name_lbl;
    public Button search_button;
    public ComboBox role_combobox;
    public ListView ser_found_list;
    public Button give_task;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        give_task.setOnAction(e-> {
            if(Objects.equals(Model.getInstance().getViewFactory().getPermissionWorkerSelectedMenuItem().get(), "assign")) {
                Model.getInstance().getViewFactory().getPermissionWorkerSelectedMenuItem().set("giveTask");
            } else if(Objects.equals(Model.getInstance().getViewFactory().getKuratorSelectedMenuItem().get(), "task_add")){
                Model.getInstance().getViewFactory().getKuratorSelectedMenuItem().set("przydzielZadanie");
            }else if(Objects.equals(Model.getInstance().getViewFactory().getPermTechnicalWorkerItem().get(), "assign")){
                Model.getInstance().getViewFactory().getPermTechnicalWorkerItem().set("giveTask");
            }
        });

        search_button.setOnAction(e->{
            Model.getInstance().clearWorkers();
            if(role_combobox.getValue()==null){
                Model.getInstance().setWorkers(input_name_lbl.getText(),"");
            }
            else{
                Model.getInstance().setWorkers(input_name_lbl.getText(),role_combobox.getValue().toString());
            }

            try{
                ser_found_list.setItems(Model.getInstance().getClients());
                ser_found_list.setCellFactory(x->new workerCellFactory());
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }

        });

        ObservableList<String> rolaList = FXCollections.observableArrayList(
                "Admin", "Pracownik", "Pracownik+", "Pracownik Techniczny","Pracownik Techniczny+", "Kurator"
        );

        role_combobox.setItems(rolaList);
    }

}
