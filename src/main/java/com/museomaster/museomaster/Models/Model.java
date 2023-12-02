package com.museomaster.museomaster.Models;

import com.museomaster.museomaster.Enums.AccountType;
import com.museomaster.museomaster.Views.ViewFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Model {
    private static Model model;
    private final ViewFactory viewFactory;

    private final DataBaseDriver dataBaseDriver;

    private AccountType loginAccountType = AccountType.ADMIN;

    private Client client;

    //Admin
    ////////////////////////////////
    private final ObservableList<Client> clients;
    private final ObservableList<Report> reports;

    ////////////////////////////////

    //Client vars
    ////////////////////////////////////////////////////////////////
    private boolean ClientLoginSuccessFlag;
    ////////////////////////////////

    //Pracownik+
    private final ObservableList<Client> workersAssigned;
    ////////////////////////////////////////////////////////////////


    private Model(){

        this.viewFactory = new ViewFactory();
        this.dataBaseDriver = new DataBaseDriver();
        this.client = new Client(0,"","","",0,0,"x", 0, "x");

        //Client settings
        this.ClientLoginSuccessFlag = false;
        ////////////////////////////////

        //Admin settings
        this.clients= FXCollections.observableArrayList();
        this.reports= FXCollections.observableArrayList();
        ////////////////////////////////

        //Pracownik+ settings
        ///////////////////////////////
        this.workersAssigned= FXCollections.observableArrayList();
        //////////////////////////////

    }

    public DataBaseDriver getDataBaseDriver() {
        return dataBaseDriver;
    }

    public static synchronized Model getInstance(){
        if(model==null){
            model = new Model();
        }

        return model;
    }

    public ViewFactory getViewFactory(){
        return viewFactory;
    }

    //

    //Client Section
    ////////////////////////////////////////////////////////////////

    public boolean getClientLoginFlag(){
        return ClientLoginSuccessFlag;
    }

    public void setClientLoginFlag(boolean flag){
        this.ClientLoginSuccessFlag = flag;
    }

    public Client getClient(){
        return client;
    }

    public void evaluateClient(String username, String password, String rola){
        ResultSet resultSet = dataBaseDriver.getClientData(username,password,rola);
        try{
            if(resultSet.next()){


                System.out.println("rep1");

                //
                // System.out.println("rep1");

                this.client.idPracownikaProperty().set(resultSet.getInt("idPracownika"));
                this.client.imiePracownikaProperty().set(resultSet.getString("imie"));
                this.client.nazwiskoPracownikaProperty().set(resultSet.getString("nazwisko"));
                this.client.nazwaUzytkownikaProperty().set(resultSet.getString("nazwaUżytkownika"));
                this.client.emailPracownikaProperty().set(resultSet.getString("e-mail"));
                this.client.nrTelefonuProperty().set(resultSet.getInt("nrTelefonu"));
                this.client.wiekPracownikaProperty().set(resultSet.getInt("wiek"));
                this.client.czyUprawnionyProperty().set(resultSet.getInt("czyUprawniony"));
                this.client.rolaProperty().set(resultSet.getString("rola"));
                this.setClientLoginFlag(true);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }





    //Admin sekcja
    ////////////////////////////////////////////////////////////////
    public ObservableList<Client> getClients(){
        return clients;
    }

    public void setClient(){
        ResultSet resultSet = dataBaseDriver.getAllClientsData();

        try{
            while(resultSet.next()){
                Integer id=resultSet.getInt("idPracownika");
                String imie=resultSet.getString("imie");
                String nazwisko=resultSet.getString("nazwisko");
                String nazwaUzytkownika=resultSet.getString("nazwaUżytkownika");
                String email=resultSet.getString("e-mail");
                Integer nrTelefonu=resultSet.getInt("nrTelefonu");
                Integer wiek=resultSet.getInt("wiek");
                Integer uprawniony=resultSet.getInt("czyUprawniony");
                String rola=resultSet.getString("rola");
                clients.add(new Client(id, imie, nazwisko, email, wiek, uprawniony, rola, nrTelefonu, nazwaUzytkownika));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ObservableList<Report> getReports(){
        return reports;
    }

    public void setReports(){
        ResultSet resultSet = dataBaseDriver.getAllReporstData();

        try{
            while(resultSet.next()){
                Integer id=resultSet.getInt("idPracownika");
                String nazwaUzytkownika=resultSet.getString("username");
                String opis=resultSet.getString("opis");
                Integer idR=resultSet.getInt("idRaportu");
                reports.add(new Report(id, idR, nazwaUzytkownika,opis));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    //Pracownik +
    ////////////////////////////////////////////////////////////////////////

    public void setWorkers(String Input, String rolaa){
        ResultSet resultSet = dataBaseDriver.getWorkerData(Input,rolaa);

        try{
            while(resultSet.next()){
                Integer id=resultSet.getInt("idPracownika");
                String imie=resultSet.getString("imie");
                String nazwisko=resultSet.getString("nazwisko");
                String nazwaUzytkownika=resultSet.getString("nazwaUżytkownika");
                String email=resultSet.getString("e-mail");
                Integer nrTelefonu=resultSet.getInt("nrTelefonu");
                Integer wiek=resultSet.getInt("wiek");
                Integer uprawniony=resultSet.getInt("czyUprawniony");
                String rola=resultSet.getString("rola");
                clients.add(new Client(id, imie, nazwisko, email, wiek, uprawniony, rola, nrTelefonu, nazwaUzytkownika));
                System.out.println(clients);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void clearWorkers(){
        clients.clear();
    }

    public void assignWorker(Client client){
        workersAssigned.add(client);
        System.out.println(workersAssigned);
    }
    public void removeWorker(Client client){
        workersAssigned.remove(client);
        System.out.println(workersAssigned);
    }
}
