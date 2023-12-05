package com.museomaster.museomaster.TypyUzytkownikow.Utils;

import com.museomaster.museomaster.CellsController.assignedTaskFactory;
import com.museomaster.museomaster.CellsController.finishedTaskFactory;
import com.museomaster.museomaster.Models.Model;
import com.museomaster.museomaster.TypyUzytkownikow.Pracownik.PracownikDashboardThread;
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
        Model.getInstance().setfinishedTaskLV(task_ended_listview);
        Model.getInstance().setAssignedTaskLV(taks_list_textView);
        PracownikDashboardThread x = new PracownikDashboardThread(taks_list_textView.getItems().size());
        x.startThread();
    }

    public void initData(){
        Model.getInstance().clearTasks();
        Model.getInstance().clearFinishedTasks();
        Model.getInstance().setTasks("assigned");
        Model.getInstance().setTasks("finished");
    }
}
