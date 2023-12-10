package com.museomaster.museomaster.TypyUzytkownikow.Utils;

import com.museomaster.museomaster.Models.Client;
import com.museomaster.museomaster.Models.Model;
import com.museomaster.museomaster.Models.Zadanie;
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
            try{
                if(isWorkerAssignedDifferent()){
                    LocalDate start = stard_date_datePicker.getValue();
                    java.sql.Date starDate = java.sql.Date.valueOf(start);
                    LocalDate end = end_date_datePicker.getValue();
                    java.sql.Date endDate= java.sql.Date.valueOf(end);
                    Model.getInstance().setTaskVars(desc_textfield.getText(),subject_lbl.getText(),starDate,endDate);
                    if(Objects.equals(Model.getInstance().getViewFactory().getPermissionWorkerSelectedMenuItem().get(), "giveTask"))
                        Model.getInstance().getViewFactory().getPermissionWorkerSelectedMenuItem().set("searchEx");
                    else if(Objects.equals(Model.getInstance().getViewFactory().getKuratorSelectedMenuItem().get(), "przydzielZadanie")){
                        Model.getInstance().getViewFactory().getKuratorSelectedMenuItem().set("searchEx");
                    }
                    else if(Objects.equals(Model.getInstance().getViewFactory().getPermTechnicalWorkerItem().get(), "giveTask")){
                        Model.getInstance().getViewFactory().getPermTechnicalWorkerItem().set("searchEx");
                    }
                }
                else{
                    Error_lbl.setText("Wybrani pracownicy to nie pracownicy techniczni");
                }
            }
            catch (Exception x){
                Error_lbl.setText("Zle wypelniony formularz");
            }
        }
        );

        give_task_btn.setOnAction(e-> {
            String lineOfCode;
            if(Objects.equals(Model.getInstance().getViewFactory().getPermissionWorkerSelectedMenuItem().get(), "giveTask")){
                setTask("1");
            }
            else if(Objects.equals(Model.getInstance().getViewFactory().getKuratorSelectedMenuItem().get(), "przydzielZadanie")){
                setTask("2");
            }
            else if(Objects.equals(Model.getInstance().getViewFactory().getPermTechnicalWorkerItem().get(), "giveTask")){
                setTask("3");

            }

        }
        );
    }

    public void setTask(String signal){
        try{

            LocalDate start = stard_date_datePicker.getValue();
            java.sql.Date starDate = java.sql.Date.valueOf(start);
            LocalDate end = end_date_datePicker.getValue();
            java.sql.Date endDate= java.sql.Date.valueOf(end);
            String nazwa=Model.getInstance().getClient().getNazwaUzytkownika();

            System.out.println(endDate);
            if (!desc_textfield.getText().isBlank() && !subject_lbl.getText().isBlank()) {
                Model.getInstance().setTaskVars(desc_textfield.getText(),subject_lbl.getText(),starDate,endDate);
                for(Client client : Model.getInstance().getWorkersAssigned()){
                    Model.getInstance().createTask(client.getIdPracownika(),client.getNazwaUzytkownika(),nazwa);
                }
                Model.getInstance().clearWorkersAssigned();
                if (signal.equals("1")) {
                    Model.getInstance().getViewFactory().getPermissionWorkerSelectedMenuItem().set("x");
                } else if (signal.equals("2")) {
                    Model.getInstance().getViewFactory().getKuratorSelectedMenuItem().set("task_list");
                } else if (signal.equals("3")) {
                    Model.getInstance().getViewFactory().getPermTechnicalWorkerItem().set("x");
                }

            }
            else{
                Error_lbl.setText("Źle wypełniony formularz");
            }
        }
        catch (Exception x){
            Error_lbl.setText("Źle wypełniony formularz");
        }
    }

    public boolean isWorkerAssignedDifferent() {
        for (Client worker : Model.getInstance().getWorkersAssigned()) {
            String position = worker.getRola();
            System.out.println(position);
            if (!position.equals("Pracownik Techniczny") && !position.equals("Pracownik Techniczny+") ) {
                return false;
            }

        }
        return true;
    }
}
