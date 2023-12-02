package com.museomaster.museomaster.Models;


import com.museomaster.museomaster.TypyUzytkownikow.Administrator.AdminAddUser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
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

    public void createReport(String opis, Integer id, String username){

        Statement statement ;
        try{
            statement=this.conn.createStatement();
            statement.executeUpdate("INSERT INTO raport (opis, idPracownika,username) VALUES ('"+opis+"', '"+id+"', '"+username+"');");
        } catch (SQLException e) {

        }
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

    public void createRoom(Integer wielkosc ,String nazwaSali, String typ){
        String none = "wolna";
        Statement statement ;
        try{
            statement=this.conn.createStatement();
            statement.executeUpdate("INSERT INTO sala (wielkość,nazwa,status,typ) VALUES ('"+wielkosc+"','"+nazwaSali+"','"+none+"','"+typ+"');");
        } catch (SQLException e) {

        }
    }

    public ResultSet getAllReporstData(){
        Statement statement;
        ResultSet resultSet = null;

        try{
            statement=this.conn.createStatement();
            resultSet=statement.executeQuery("SELECT * FROM raport");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultSet;
    }

    public void deleteReport(Integer id){
        Statement statement;

        try{
            statement=this.conn.createStatement();
            statement.executeUpdate("DELETE FROM raport WHERE idRaportu ='"+id+"';");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    ////////////////////////////////////////////////////////////////////////

    //Pracownik +
    ////////////////////////////////////////////////////////////////////////
    public ResultSet getWorkerData(String Input, String rola){
        Statement statement;
        ResultSet resultSet = null;
        String imie = null;
        String nazwisko = null;

        try{
            if (Input.contains(" ")) {
                String[] words = Input.split(" ");
                imie=words[0];
                nazwisko=words[1];
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }


        try{
            statement=this.conn.createStatement();
            if(Input.isBlank() && rola!=null && !rola.isBlank()){
                resultSet=statement.executeQuery("SELECT * FROM pracownik WHERE rola='"+rola+"';");
            }
            else if (Input.contains(" ")){
                resultSet=statement.executeQuery("SELECT * FROM pracownik WHERE imie='"+imie+"' AND nazwisko='"+nazwisko+"';");
            }
            else{
                resultSet=statement.executeQuery("SELECT * FROM pracownik WHERE nazwaUżytkownika ='"+Input+"'");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultSet;
    }

    public void createTask(Integer idPracownika, String opis, String temat, java.sql.Date dataRozpoczecia, java.sql.Date dataZakonczenia, String nazwaNadajacego){
        String status = "wTrackcie";
        Statement statement ;
        try{
            statement=this.conn.createStatement();
            statement.executeUpdate("INSERT INTO zadanie2 (temat,opis,dataRozpoczęcia,dataZakończenia,status,idPracownika,nazwaNadajacego) VALUES ('"+temat+"','"+opis+"','"+dataRozpoczecia+"','"+dataZakonczenia+"','"+status+"','"+idPracownika+"', '"+nazwaNadajacego+"');");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    /////////////////////////////////////////////////////////////////////////


    //Sekcja pracownika
    ////////////////////////////////////////////////////////////////////////
    public ResultSet getAssignedTask(Integer id){
        Statement statement;
        String status = "wTrackcie";
        ResultSet resultSet = null;

        try{
            statement=this.conn.createStatement();
            resultSet=statement.executeQuery("SELECT * FROM zadanie2 WHERE status='"+status+"' AND idPracownika='"+id+"';");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultSet;
    }

    public void setAssignedTask(String status1, Integer id){
        Statement statement;
        String status2 = "wTrackcie";


        try{
            statement=this.conn.createStatement();
            statement.executeUpdate("Update zadanie2 SET status='"+status1+"' Where status='"+status2+"' AND idZadania='"+id+"';");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    /////////////////////////////////////////////////////////////////////////









    // Sekcja Kuratora
    private boolean createExhibitSuccessFlag;
    public boolean getCreateExhibitSuccessFlag(){
        return createExhibitSuccessFlag;
    }
    public void createExhibit(String nazwaZabytku, Integer okresPowstania, String tematyka, String tworca, String aktMiejscePrzechowywania, String opis){
        Statement statement;
        try{
            statement = this.conn.createStatement();
            createExhibitSuccessFlag = true;
            statement.executeUpdate("INSERT INTO eksponat (nazwaEksponatu, okresPowstania, tematyka, twórca, aktualMiejscePrzech, opis) VALUES ('"+nazwaZabytku+"','"+okresPowstania+"','"+tematyka+"','"+tworca+"','"+aktMiejscePrzechowywania+"', '"+opis+"');");
        } catch (SQLException e) {
            createExhibitSuccessFlag = false;
        }
    }
    public ResultSet getAllExhibitsData(){

        Statement statement;
        ResultSet resultSet = null;

        try{

            statement=this.conn.createStatement();
            resultSet=statement.executeQuery("SELECT * FROM raport");

            statement = this.conn.createStatement();
            resultSet=statement.executeQuery("SELECT * FROM eksponat");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultSet;
    }


}
