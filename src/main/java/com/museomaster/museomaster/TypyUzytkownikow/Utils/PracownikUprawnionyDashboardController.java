package com.museomaster.museomaster.TypyUzytkownikow.Utils;

import com.museomaster.museomaster.CellsController.assignedTaskFactory;
import com.museomaster.museomaster.CellsController.finishedTaskFactory;
import com.museomaster.museomaster.Models.Model;
import com.museomaster.museomaster.TypyUzytkownikow.Pracownik.PracownikDashboardThread;
import com.museomaster.museomaster.TypyUzytkownikow.PracownikUprawniony.PracownikUprawnionyController;
import com.museomaster.museomaster.TypyUzytkownikow.PracownikUprawniony.PracownikUprawnionyThread;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class PracownikUprawnionyDashboardController implements Initializable {
    public ListView taks_list_textView;
    public ListView task_ended_listview;
    public ListView task_assigned_listView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initData();
        taks_list_textView.setItems(Model.getInstance().getTasks());
        taks_list_textView.setCellFactory(e->new assignedTaskFactory());
        task_ended_listview.setItems(Model.getInstance().getFishedTasks());
        task_ended_listview.setCellFactory(e->new finishedTaskFactory());
        task_assigned_listView.setItems(Model.getInstance().getAssignedToTasks());
        task_assigned_listView.setCellFactory(e->new finishedTaskFactory());
        Model.getInstance().setfinishedTaskLV(task_ended_listview);
        Model.getInstance().setAssignedTaskLV(taks_list_textView);
        Model.getInstance().setAssignedToTaskLV(task_assigned_listView);
        PracownikDashboardThread x = new PracownikDashboardThread(taks_list_textView.getItems().size());
        PracownikUprawnionyThread y = new PracownikUprawnionyThread();
        y.startThread();

    }

    public void initData(){
        Model.getInstance().clearTasks();
        Model.getInstance().clearFinishedTasks();
        Model.getInstance().setTasks("assigned");
        Model.getInstance().setTasks("finished");
        Model.getInstance().setTasks("assignedTo");
    }
}
