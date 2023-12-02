package com.museomaster.museomaster.Models;

import com.museomaster.museomaster.Enums.AccountType;
import com.museomaster.museomaster.Views.ViewFactory;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Objects;

public class Model {
    private static Model model;
    private final ViewFactory viewFactory;

    private final DataBaseDriver dataBaseDriver;

    private AccountType loginAccountType = AccountType.ADMIN;

    private Client client;
    private Exhibit exhibit;


    //Admin
    ////////////////////////////////
    private final ObservableList<Client> clients;
    private final ObservableList<Report> reports;

    ////////////////////////////////
    private final ObservableList<Exhibit> exhibits;
    private final ObservableList<Exhibit> exhibitsSearched;
    private final ObservableList<Exhibition> exhibitions;

    //Client vars
    ////////////////////////////////////////////////////////////////
    private boolean ClientLoginSuccessFlag;
    ////////////////////////////////

    //Pracownik+
    private final ObservableList<Client> workersAssigned;
    ////////////////////////////////////////////////////////////////

    //Pracownik zwykly
    ////////////////////////////////////////////////////////////////
    private final ObservableList<Zadanie> tasks;
    ////////////////////////////////////////////////////////////////


    private Model() {

        this.viewFactory = new ViewFactory();
        this.dataBaseDriver = new DataBaseDriver();
        this.client = new Client(0, "", "", "", 0, 0, "x", 0, "x");
        this.exhibit = new Exhibit(0, "", "", "", "", "", "", 0, 0, 0, 0);

        //Client settings
        this.ClientLoginSuccessFlag = false;
        ////////////////////////////////

        //Admin settings
        this.clients = FXCollections.observableArrayList();
        this.reports = FXCollections.observableArrayList();
        ////////////////////////////////


        //Pracownik+ settings
        ///////////////////////////////
        this.workersAssigned = FXCollections.observableArrayList();
        //////////////////////////////

        //Pracownik settings
        this.tasks = FXCollections.observableArrayList();
        ////////////////////////////////

        //Kurator Settings
        this.exhibits = FXCollections.observableArrayList();
        this.exhibitions = FXCollections.observableArrayList();
        this.exhibitsSearched = FXCollections.observableArrayList();
        ///////////////////////////////


    }

    public DataBaseDriver getDataBaseDriver() {
        return dataBaseDriver;
    }

    public static synchronized Model getInstance() {
        if (model == null) {
            model = new Model();
        }

        return model;
    }

    public ViewFactory getViewFactory() {
        return viewFactory;
    }

    //

    //Client Section
    ////////////////////////////////////////////////////////////////

    public boolean getClientLoginFlag() {
        return ClientLoginSuccessFlag;
    }

    public void setClientLoginFlag(boolean flag) {
        this.ClientLoginSuccessFlag = flag;
    }

    public Client getClient() {
        return client;
    }

    public void evaluateClient(String username, String password, String rola) {
        ResultSet resultSet = dataBaseDriver.getClientData(username, password, rola);
        try {
            if (resultSet.next()) {


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
    public ObservableList<Client> getClients() {
        return clients;
    }

    public void setClient() {
        ResultSet resultSet = dataBaseDriver.getAllClientsData();

        try {
            while (resultSet.next()) {
                Integer id = resultSet.getInt("idPracownika");
                String imie = resultSet.getString("imie");
                String nazwisko = resultSet.getString("nazwisko");
                String nazwaUzytkownika = resultSet.getString("nazwaUżytkownika");
                String email = resultSet.getString("e-mail");
                Integer nrTelefonu = resultSet.getInt("nrTelefonu");
                Integer wiek = resultSet.getInt("wiek");
                Integer uprawniony = resultSet.getInt("czyUprawniony");
                String rola = resultSet.getString("rola");
                clients.add(new Client(id, imie, nazwisko, email, wiek, uprawniony, rola, nrTelefonu, nazwaUzytkownika));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ObservableList<Report> getReports() {
        return reports;
    }

    public void setReports() {
        ResultSet resultSet = dataBaseDriver.getAllReporstData();

        try {
            while (resultSet.next()) {
                Integer id = resultSet.getInt("idPracownika");
                String nazwaUzytkownika = resultSet.getString("username");
                String opis = resultSet.getString("opis");
                Integer idR = resultSet.getInt("idRaportu");
                reports.add(new Report(id, idR, nazwaUzytkownika, opis));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Kurator Sekcja
    // Dla Listy wszytskich zabytkow



        //Pracownik +
        ////////////////////////////////////////////////////////////////////////

        public void setWorkers (String Input, String rolaa){
            ResultSet resultSet = dataBaseDriver.getWorkerData(Input, rolaa);

            try {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt("idPracownika");
                    String imie = resultSet.getString("imie");
                    String nazwisko = resultSet.getString("nazwisko");
                    String nazwaUzytkownika = resultSet.getString("nazwaUżytkownika");
                    String email = resultSet.getString("e-mail");
                    Integer nrTelefonu = resultSet.getInt("nrTelefonu");
                    Integer wiek = resultSet.getInt("wiek");
                    Integer uprawniony = resultSet.getInt("czyUprawniony");
                    String rola = resultSet.getString("rola");
                    clients.add(new Client(id, imie, nazwisko, email, wiek, uprawniony, rola, nrTelefonu, nazwaUzytkownika));
                    System.out.println(clients);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        public void clearWorkers () {
            clients.clear();
        }

        public void assignWorker (Client client){
            workersAssigned.add(client);
            System.out.println(workersAssigned);
        }
        public void removeWorker (Client client){
            workersAssigned.remove(client);
            System.out.println(workersAssigned);
        }

        //Zwykly pracownik
        ////////////////////////////////////////////////////////////////
        public ObservableList<Zadanie> getTasks () {
            return tasks;
        }
        public void setTasks () {
            ResultSet resultSet = dataBaseDriver.getAssignedTask(client.getIdPracownika());

            try {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt("idZadania");
                    String temat = resultSet.getString("temat");
                    String opis = resultSet.getString("opis");
                    String dataRozpoczecia = resultSet.getDate("dataRozpoczęcia").toString();
                    String dataZakonczenia = resultSet.getDate("dataZakończenia").toString();
                    String status = resultSet.getString("status");
                    Integer idPracownika = resultSet.getInt("idPracownika");
                    String nazwaUzytkownikaNadajacego = resultSet.getString("nazwaNadajacego");
                    tasks.add(new Zadanie(id, temat, opis, dataRozpoczecia, dataZakonczenia, status, idPracownika, nazwaUzytkownikaNadajacego));
                    System.out.println(clients);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        public void clearTasks () {
            tasks.clear();
        }

        public void removeTask (Zadanie task){
            tasks.remove(task);
        }

        ////////////////////////////////////////////////////////////////

        // Dla Listy wszytskich zabytkow
        public ObservableList<Exhibit> getExhibits() {
            return exhibits;
        }

        public void setExhibits() {
            ResultSet resultSet = dataBaseDriver.getAllExhibitsData();
            try {
                while (resultSet.next()) {
                    Integer idZabytku = resultSet.getInt("idEksponatu");
                    String nazwaEksponatu = resultSet.getString("nazwaEksponatu");
                    String okresPowstania = resultSet.getString("okresPowstania");
                    String tematyka = resultSet.getString("tematyka");
                    String tworca = resultSet.getString("twórca");
                    String aktualMiejscePrzech = resultSet.getString("aktualMiejscePrzech");
                    String opis = resultSet.getString("opis");
                    Integer WystawaidWystawy = resultSet.getInt("WystawaidWystawy");
                    Integer ZadanieidZadania = resultSet.getInt("ZadanieidZadania");
                    Integer SalaidSali = resultSet.getInt("SalaidSali");
                    Integer ZadaniePracownikidPracownika = resultSet.getInt("ZadaniePracownikidPracownika");
                    exhibits.add(new Exhibit(idZabytku, nazwaEksponatu, okresPowstania, tematyka, tworca, aktualMiejscePrzech, opis,
                            WystawaidWystawy, ZadanieidZadania, SalaidSali, ZadaniePracownikidPracownika));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        // Dla listy wystaw
        public ObservableList<Exhibition> getExhibitions () {
            return exhibitions;
        }
        public void setExhibitions () {
            ResultSet resultSet = dataBaseDriver.getAllExhibitionsData();

            try {
                while (resultSet.next()) {
                    Integer idWystawy = resultSet.getInt("idWystawy");
                    String nazwaWystawy = resultSet.getString("nazwaWystawy");
                    String sala = resultSet.getString("sala");
                    String miejsceWykonania = resultSet.getString("miejsceWykonania");
                    String tematyka = resultSet.getString("tematyka");
                    String tworca = resultSet.getString("tworca");
                    LocalDate dataRozpoczecia = resultSet.getDate("dataRozpoczecia").toLocalDate();
                    LocalDate dataZakonczenia = resultSet.getDate("dataZakonczenia").toLocalDate();
                    exhibitions.add(new Exhibition(idWystawy, nazwaWystawy, sala, miejsceWykonania, tematyka, tworca, dataRozpoczecia, dataZakonczenia));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        // Dla wyszukiwania zabytkow
        public ObservableList<Exhibit> getSearchedExhibits () {
            return exhibitsSearched;
        }
        public void setExhibitsSearched (String nazwa, String autor, String topic, Integer rok1, Integer rok2, String
        miejsce){
            ResultSet resultSet;
            if (!Objects.equals(nazwa, "")) {
                resultSet = dataBaseDriver.getExhibitByName(nazwa);
            } else {
                if (!Objects.equals(topic, "")) {
                    resultSet = dataBaseDriver.getExhibitByTopic(topic);
                } else {
                    if (!Objects.equals(autor, "")) {
                        resultSet = dataBaseDriver.getExhibitByAuthor(autor);
                    } else {
                        if (rok1 == 10000 && rok2 != 10000) {
                            resultSet = dataBaseDriver.getExhibitBySecYear(rok2);
                        } else if (rok2 == 10000 && rok1 != 10000) {
                            resultSet = dataBaseDriver.getExhibitByFirstYear(rok1);
                        } else if (rok1 != 10000 && rok2 != 10000) {
                            resultSet = dataBaseDriver.getExhibitByYears(rok1, rok2);
                        } else {
                            if (!Objects.equals(miejsce, null)) {
                                resultSet = dataBaseDriver.getExhibitByPlace(miejsce);
                            } else {
                                resultSet = dataBaseDriver.getExhibitByYears(-1000000, 2024);
                            }
                        }
                    }
                }
            }

            try {
                while (resultSet.next()) {
                    Integer idZabytku = resultSet.getInt("idEksponatu");
                    String nazwaEksponatu = resultSet.getString("nazwaEksponatu");
                    String okresPowstania = resultSet.getString("okresPowstania");
                    String tematyka = resultSet.getString("tematyka");
                    String tworca = resultSet.getString("twórca");
                    String aktualMiejscePrzech = resultSet.getString("aktualMiejscePrzech");
                    String opis = resultSet.getString("opis");
                    Integer WystawaidWystawy = resultSet.getInt("WystawaidWystawy");
                    Integer ZadanieidZadania = resultSet.getInt("ZadanieidZadania");
                    Integer SalaidSali = resultSet.getInt("SalaidSali");
                    Integer ZadaniePracownikidPracownika = resultSet.getInt("ZadaniePracownikidPracownika");
                    exhibitsSearched.add(new Exhibit(idZabytku, nazwaEksponatu, okresPowstania, tematyka, tworca, aktualMiejscePrzech, opis,
                            WystawaidWystawy, ZadanieidZadania, SalaidSali, ZadaniePracownikidPracownika));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

