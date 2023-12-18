package com.museomaster.museomaster.TypyUzytkownikow.Pracownik;

import com.museomaster.museomaster.CellsController.UserCellFactory;
import com.museomaster.museomaster.CellsController.assignedTask;
import com.museomaster.museomaster.CellsController.assignedTaskFactory;
import com.museomaster.museomaster.CellsController.finishedTaskFactory;
import com.museomaster.museomaster.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class PracownikDashboardController implements Initializable {
    public ListView task_list_listview;
    public ListView ended_task_list_listview;
    public Label name_lbl;
    public Label date_lbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initData();
        task_list_listview.setItems(Model.getInstance().getTasks());
        task_list_listview.setCellFactory(e->new assignedTaskFactory());
        ended_task_list_listview.setItems(Model.getInstance().getFishedTasks());
        ended_task_list_listview.setCellFactory(e->new finishedTaskFactory());
        Model.getInstance().setfinishedTaskLV(ended_task_list_listview);
        Model.getInstance().setAssignedTaskLV(task_list_listview);
        System.out.println(task_list_listview.getItems().size());
        PracownikDashboardThread x = new PracownikDashboardThread(task_list_listview.getItems().size());
        x.startThread();
    }

    public void initData(){
        name_lbl.setText("Witaj " + Model.getInstance().getClient().imiePracownikaProperty().get() + "!");
        date_lbl.setText(LocalDate.now().toString());
        Model.getInstance().clearTasks();
        Model.getInstance().clearFinishedTasks();
        Model.getInstance().setTasks("assigned");
        Model.getInstance().setTasks("finished");
    }
}
