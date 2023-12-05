package com.museomaster.museomaster.TypyUzytkownikow.Utils;

import com.museomaster.museomaster.Models.Client;
import com.museomaster.museomaster.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.net.URL;
import java.time.LocalDate;
import java.util.Objects;
import java.util.ResourceBundle;

public class PracownikUtworzZadanieDashboardController implements Initializable{
    public VBox przydziel_zadanie_btn;
    public TextField subject_lbl;
    public TextArea desc_textfield;
    public DatePicker stard_date_datePicker;
    public DatePicker end_date_datePicker;
    public Button ego_to_ex_btn;
    public Button give_task_btn;
    public Text Error_lbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ego_to_ex_btn.setOnAction(e-> {
            if(Objects.equals(Model.getInstance().getViewFactory().getPermissionWorkerSelectedMenuItem().get(), "giveTask"))
                Model.getInstance().getViewFactory().getPermissionWorkerSelectedMenuItem().set("searchEx");
            else if(Objects.equals(Model.getInstance().getViewFactory().getKuratorSelectedMenuItem().get(), "przydzielZadanie")){
                Model.getInstance().getViewFactory().getKuratorSelectedMenuItem().set("searchEx");
            }
        }
        );
        give_task_btn.setOnAction(e-> {
            if(Objects.equals(Model.getInstance().getViewFactory().getPermissionWorkerSelectedMenuItem().get(), "giveTask")){
                try{
                    LocalDate start = stard_date_datePicker.getValue();
                    java.sql.Date starDate = java.sql.Date.valueOf(start);
                    LocalDate end = end_date_datePicker.getValue();
                    java.sql.Date endDate= java.sql.Date.valueOf(end);
                    String nazwa=Model.getInstance().getClient().getNazwaUzytkownika();

                    System.out.println(endDate);


                    for(Client client : Model.getInstance().getClients()){
                        Model.getInstance().getDataBaseDriver().createTask(client.getIdPracownika(),desc_textfield.getText(),subject_lbl.getText(),starDate,endDate,nazwa);
                    }
                    Model.getInstance().getViewFactory().getPermissionWorkerSelectedMenuItem().set("x");
                }
                catch (Exception x){
                    Error_lbl.setText("Źle wypełniony formularz");
                }

            }
            else if(Objects.equals(Model.getInstance().getViewFactory().getKuratorSelectedMenuItem().get(), "przydzielZadanie")){
                Model.getInstance().getViewFactory().getKuratorSelectedMenuItem().set("task_list");
                try{
                    LocalDate start = stard_date_datePicker.getValue();
                    java.sql.Date starDate = java.sql.Date.valueOf(start);
                    LocalDate end = end_date_datePicker.getValue();
                    java.sql.Date endDate= java.sql.Date.valueOf(end);
                    String nazwa=Model.getInstance().getClient().getNazwaUzytkownika();

                    System.out.println(endDate);


                    for(Client client : Model.getInstance().getClients()){
                        Model.getInstance().getDataBaseDriver().createTask(client.getIdPracownika(),desc_textfield.getText(),subject_lbl.getText(),starDate,endDate,nazwa);
                    }
                    Model.getInstance().getViewFactory().getPermissionWorkerSelectedMenuItem().set("x");
                }
                catch (Exception x){
                    Error_lbl.setText("Źle wypełniony formularz");
                }
            }

        }
        );
    }
}
