package com.museomaster.museomaster.CellsController;

import com.museomaster.museomaster.Models.Client;
import com.museomaster.museomaster.Models.Model;
import com.museomaster.museomaster.Models.Zadanie;
import javafx.beans.binding.Bindings;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class assignedTask  implements Initializable {
    public Button success_btn;
    public Button task_desc_btn;
    public Button failure_btn;
    public Button problem_btn;
    public Label task_id_lbl;
    public Label user_name_lbl;
    public Label start_date_lbl;
    public Label end_date_lbl;
    private ListView<Zadanie> listView;
    private final Zadanie zadanie;

    public assignedTask(ListView<Zadanie> listView,Zadanie zadanie) {
        this.zadanie=zadanie;
        this.listView=listView;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        task_id_lbl.textProperty().bind(zadanie.idZadaniaProperty().asString());
        user_name_lbl.textProperty().bind(zadanie.nazwaUzytkownikaNadajacegoProperty());
        start_date_lbl.textProperty().bind(Bindings.concat("End:",zadanie.startDataProperty()));
        end_date_lbl.textProperty().bind(Bindings.concat("Start:",zadanie.endDataProperty()));
        task_desc_btn.setOnAction(e-> Model.getInstance().getViewFactory().showMessageWindow(zadanie.getNazwaUzytkownikaNadajacego(),zadanie.getOpis()));
        success_btn.setOnAction(e->{
            Model.getInstance().getDataBaseDriver().setAssignedTask("Zakonczone",zadanie.getIdZadania());
            zadanie.setStatus("Zakonczone");
            Model.getInstance().removeTask(zadanie);
            listView.refresh();
            Model.getInstance().refreshfinishedTaskLV();
        });
        problem_btn.setOnAction(e-> {
            Model.getInstance().getDataBaseDriver().setAssignedTask("Problem", zadanie.getIdZadania());
            zadanie.setStatus("Problem");
            Model.getInstance().removeTask(zadanie);
            listView.refresh();
            Model.getInstance().refreshfinishedTaskLV();
        });
        failure_btn.setOnAction(e->{Model.getInstance().getDataBaseDriver().setAssignedTask("Fail",zadanie.getIdZadania());
            zadanie.setStatus("Fail");
            Model.getInstance().removeTask(zadanie);
            listView.refresh();
            Model.getInstance().refreshfinishedTaskLV();
        });
    }
}
