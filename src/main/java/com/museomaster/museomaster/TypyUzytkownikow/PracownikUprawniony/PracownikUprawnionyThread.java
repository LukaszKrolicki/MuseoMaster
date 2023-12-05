package com.museomaster.museomaster.TypyUzytkownikow.PracownikUprawniony;

import com.museomaster.museomaster.Models.Model;

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
//                Model.getInstance().clearAssignedTasks();
//                Model.getInstance().setTasks("assignedTo");
//                Model.getInstance().refreshAssignedToTaskLV();
//                System.out.println("Zaktualizowano Taski");
            }
        }, 0, 60000); // 0 delay, 3000 milliseconds (3 seconds) interval
    }

    public void stopThread() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }
}