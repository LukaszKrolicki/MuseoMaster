package com.museomaster.museomaster.TypyUzytkownikow.PracownikUprawniony;

import com.museomaster.museomaster.Models.Model;
import com.museomaster.museomaster.Models.Zadanie;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class PracownikUprawnionyThread {
    private Timer timer;



    public void startThread() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                ObservableList<Zadanie> assignedTasks=Model.getInstance().getAssignedToTasks();
                ObservableList<Integer> idTaskAssigned;
                ResultSet resultSet=null;

                for(Zadanie zadanie : assignedTasks){
                    resultSet=Model.getInstance().getDataBaseDriver().getAssignedTaskState(zadanie.getIdZadania());
                    try {
                        if(resultSet.next()){
                            if(!Objects.equals(zadanie.getStatus(), resultSet.getString("status"))){
                                zadanie.setStatus(resultSet.getString("status"));
                                Model.getInstance().refreshAssignedToTaskLV();
                            }
                        }
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }

                //Model.getInstance().clearAssignedTasks();
                //Model.getInstance().setTasks("assignedTo");
                //Model.getInstance().refreshAssignedToTaskLV();
                //System.out.println("Zaktualizowano Taski");
            }
        }, 0, 3000); // 0 delay, 3000 milliseconds (3 seconds) interval
    }

    public void stopThread() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }
}