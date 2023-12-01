package com.museomaster.museomaster.Models;


import com.museomaster.museomaster.TypyUzytkownikow.Administrator.AdminAddUser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DataBaseDriver {
    private Connection conn;

    public DataBaseDriver(){
        try{

            Properties properties = new Properties();
            FileInputStream configFile = new FileInputStream("src/main/config/config.properties");
            properties.load(configFile);
            String password = properties.getProperty("db.password");

            String url = "jdbc:mysql://127.0.0.1:3306/MuseoMaster";
            conn = DriverManager.getConnection (url,"remoteUser",password);
            System.out.println ("Database connection established");
        }
        catch(SQLException e){
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    //Sekcja Clienta
    ////////////////////////////////////////////////////////////////////////
    public ResultSet getClientData(String username, String password, String rola){
        Statement statement;
        ResultSet resultSet =null;

        try{
            statement = this.conn.createStatement();
            resultSet=statement.executeQuery("SELECT * FROM pracownik WHERE nazwaUżytkownika='"+username+"' AND haslo ='"+password+"' AND rola ='"+rola+"';");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultSet;
    }

    //Sekcja Admina

    private boolean createSuccessFlag;
    public boolean getCreateSuccessFlag(){
        return createSuccessFlag;
    }
    public void createClient(String imiePracownika, String nazwiskoPracownika, String emailPracownika, Integer wiekPracownika, Integer czyUprawniony, String rola, Integer nrTelefonu, String nazwaUzytkownika, String hasloUzytkownika){
        String none = "-";
        Statement statement ;
        try{
            statement=this.conn.createStatement();
            createSuccessFlag=true;
            statement.executeUpdate("INSERT INTO pracownik (imie, nazwisko, nazwaUżytkownika, `e-mail`, nrTelefonu, wiek, haslo, status, czyUprawniony, rola) VALUES ('"+imiePracownika+"','"+nazwiskoPracownika+"','"+nazwaUzytkownika+"','"+emailPracownika+"','"+nrTelefonu+"','"+wiekPracownika+"', '"+hasloUzytkownika+"','"+none+"', '"+czyUprawniony+"','"+rola+"');");
        } catch (SQLException e) {
            createSuccessFlag=false;
        }
    }

    public ResultSet getAllClientsData(){
        Statement statement;
        ResultSet resultSet = null;

        try{
            statement=this.conn.createStatement();
            resultSet=statement.executeQuery("SELECT * FROM pracownik");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultSet;
    }

    public void deleteClient(Integer id){
        Statement statement;

        try{
            statement=this.conn.createStatement();
            statement.executeUpdate("DELETE FROM pracownik WHERE idPracownika ='"+id+"';");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
