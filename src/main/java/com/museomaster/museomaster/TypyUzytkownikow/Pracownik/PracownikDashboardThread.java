package com.museomaster.museomaster.TypyUzytkownikow.Pracownik;

import com.museomaster.museomaster.Models.Model;

import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class PracownikDashboardThread {
    private Timer timer;

    private Integer wielkosc_tabeli_task;

    private Integer wielkosc_tabeli_task_nowa;

    public PracownikDashboardThread(Integer wielkosc_tabeli_task){
        this.wielkosc_tabeli_task=wielkosc_tabeli_task;
    }

    public void startThread() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                wielkosc_tabeli_task_nowa=Model.getInstance().getSizeAssignedTask();
                System.out.println(wielkosc_tabeli_task_nowa);
                if(!Objects.equals(wielkosc_tabeli_task, wielkosc_tabeli_task_nowa)){
                    wielkosc_tabeli_task=wielkosc_tabeli_task_nowa;
                    Model.getInstance().clearTasks();
                    Model.getInstance().setTasks("assigned");
                    Model.getInstance().refreshAssignedTaskLV();
                    System.out.println("Znaleziono zadanie");
                }
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
