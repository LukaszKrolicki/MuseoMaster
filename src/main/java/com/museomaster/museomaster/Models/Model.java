package com.museomaster.museomaster.Models;

import com.museomaster.museomaster.Enums.AccountType;
import com.museomaster.museomaster.Views.ViewFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Model {
    private static Model model;
    private final ViewFactory viewFactory;

    private final DataBaseDriver dataBaseDriver;

    private AccountType loginAccountType = AccountType.ADMIN;

    private Client client;

    //Client vars
    ////////////////////////////////////////////////////////////////
    private boolean ClientLoginSuccessFlag;
    ////////////////////////////////


    private Model(){

        this.viewFactory = new ViewFactory();
        this.dataBaseDriver = new DataBaseDriver();
        this.client = new Client(0,"","","",0,0,"x", 0, "x");

        //Client settings
        this.ClientLoginSuccessFlag = false;
        ////////////////////////////////

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

}
