package com.museomaster.museomaster.Models;

import com.museomaster.museomaster.Enums.AccountType;
import com.museomaster.museomaster.Views.ViewFactory;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.scene.control.ListView;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
    private final ObservableList<String> rooms;
    private final ObservableList<String> allRooms;
    //Client vars
    ////////////////////////////////////////////////////////////////
    private boolean ClientLoginSuccessFlag;

    ////////////////////////////////

    //Normal client vars
    private boolean NormalClientLoginSuccessFlag;
    ////////////////////////////////////////////////////////////////

    //Pracownik+
    private final ObservableList<Client> workersAssigned;
    private final ObservableList<Zadanie> tasksAssignedTo;

    private final ObservableList<Exhibit> exAssigned;
    ////////////////////////////////////////////////////////////////

    //Pracownik zwykly
    ////////////////////////////////////////////////////////////////
    private final ObservableList<Zadanie> tasks;
    private final ObservableList<Zadanie> tasks_finished;

    ListView task_list_listview;
    ListView ended_task_list_listview;

    ListView assigned_task_to_listview;

    ////////////////////////////////////////////////////////////////

    //AudioVars
    ////////////////////////////////////////////////////////////////
    public Integer playAudioFlag = 1;


    ////////////////////////////////////////////////////////////////


    //TechnicalWorker
    ////////////////////////////////////////////////////////////////

    private final ObservableList<Integer> exIds;

    private final ObservableList<Exhibit> exhibitsAssigned;

    private final ObservableList<Exhibit> exhibitsChecked;

    ////////////////////////////////////////////////////////////////
    private Model() {

        this.viewFactory = new ViewFactory();
        this.dataBaseDriver = new DataBaseDriver();
        this.client = new Client(0, "", "", "", 0, 0, "x", 0, "x");
        this.exhibit = new Exhibit(0, "", "", "", "", "", "", 0, 0, 0, 0,"");

        //Client settings
        this.ClientLoginSuccessFlag = false;
        ////////////////////////////////

        //NormalClient Settings
        this.NormalClientLoginSuccessFlag = false;
        ////////////////////////////////

        //Admin settings
        this.clients = FXCollections.observableArrayList();
        this.reports = FXCollections.observableArrayList();
        ////////////////////////////////


        //Pracownik+ settings
        ///////////////////////////////
        this.workersAssigned = FXCollections.observableArrayList();
        this.tasksAssignedTo = FXCollections.observableArrayList();
        this.exAssigned = FXCollections.observableArrayList();
        //////////////////////////////

        //Pracownik settings
        this.tasks = FXCollections.observableArrayList();
        this.tasks_finished = FXCollections.observableArrayList();
        ////////////////////////////////

        //Kurator Settings
        this.exhibits = FXCollections.observableArrayList();
        this.exhibitions = FXCollections.observableArrayList();
        this.exhibitsSearched = FXCollections.observableArrayList();
        this.rooms = FXCollections.observableArrayList();
        this.allRooms = FXCollections.observableArrayList();
        ///////////////////////////////

        //Technical Settings
        ////////////////////////////////
        this.exIds = FXCollections.observableArrayList();
        this.exhibitsAssigned = FXCollections.observableArrayList();
        this.exhibitsChecked = FXCollections.observableArrayList();
        ///////////////////////////////


    }

    //AudioFlags/Func
    ////////////////////////////////

    public Integer getPlayAudioFlag() {
        return playAudioFlag;
    }

    public void setPlayAudioFlag(Integer playAudioFlag) {
        this.playAudioFlag = playAudioFlag;
    }


    ///////////////////////////////


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

    public void setNormalClientLoginSuccess(boolean flag) {
        this.NormalClientLoginSuccessFlag = flag;
    }

    public boolean getNornalClientLoginSuccess() {
        return this.NormalClientLoginSuccessFlag;
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

    //Normal User
    ////////////////////////////////////////////////////////////////
    public void evaluateNormalUser(String username, String password) {
        ResultSet resultSet = dataBaseDriver.getNormalClientData(username, password);
        try {
            if (resultSet.next()) {

                this.setNormalClientLoginSuccess(true);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    ////////////////////////////////////////////////////////////////

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


    //Pracownik +
    ////////////////////////////////////////////////////////////////////////

    public void setWorkers(String Input, String rolaa) {
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

    public void clearWorkers() {
        clients.clear();
    }

    public void assignWorker(Client client) {
        workersAssigned.add(client);
        System.out.println(workersAssigned);
    }

    public void removeWorker(Client client) {
        workersAssigned.remove(client);
        System.out.println(workersAssigned);
    }

    public ObservableList<Client> getWorkersAssigned() {
        return workersAssigned;
    }

    public void clearWorkersAssigned() {
        workersAssigned.clear();
    }

    public void clearAssignedTasks() {
        tasksAssignedTo.clear();
    }

    public void addTaskAssignedTo(Zadanie task) {
        tasksAssignedTo.add(0, task);
    }

    public void assignEx(Exhibit ex) {
        exAssigned.add(ex);
        System.out.println(exAssigned);
    }

    public void removeEx(Exhibit ex) {
        exAssigned.remove(ex);
        System.out.println(exAssigned);
    }

    public void clearEx(){
        exAssigned.clear();
    }

    public ObservableList<Exhibit> getExAssigned() {
        return exAssigned;
    }

    public ObservableList<Zadanie> getAssignedToTasks() {
        return tasksAssignedTo;
    }

    public void setAssignedToTaskLV(ListView x) {
        assigned_task_to_listview = x;
    }

    public void refreshAssignedToTaskLV() {
        assigned_task_to_listview.refresh();
    }

    public void updateAssignedTasks(String type) {
        ResultSet resultSet;
        if (Objects.equals(type, "assigned")) {
            resultSet = dataBaseDriver.getAssignedTask(client.getIdPracownika());
        } else if (Objects.equals(type, "assignedTo")) {
            resultSet = dataBaseDriver.getAssignedTaskToLv(client.getNazwaUzytkownika());
        } else {
            resultSet = dataBaseDriver.getFinishedTask(client.getIdPracownika());
        }

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
                String nazwaUzytkownika = resultSet.getString("nazwaUzytkownika");
                if (Objects.equals(type, "assigned")) {
                    tasks.add(0, new Zadanie(id, temat, opis, dataRozpoczecia, dataZakonczenia, status, idPracownika, nazwaUzytkownikaNadajacego, nazwaUzytkownika));
                } else if (Objects.equals(type, "assignedTo")) {
                    tasksAssignedTo.add(0, new Zadanie(id, temat, opis, dataRozpoczecia, dataZakonczenia, status, idPracownika, nazwaUzytkownikaNadajacego, nazwaUzytkownika));
                } else {
                    tasks_finished.add(0, new Zadanie(id, temat, opis, dataRozpoczecia, dataZakonczenia, status, idPracownika, nazwaUzytkownikaNadajacego, nazwaUzytkownika));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    String desc;
    String subject;
    java.sql.Date starDate;
    java.sql.Date endDate;

    public void setTaskVars(String desc, String subject, java.sql.Date starDate, java.sql.Date endDate) {
        this.desc = desc;
        this.subject = subject;
        this.starDate = starDate;
        this.endDate = endDate;
    }

    public void createTask(Integer idPracownika, String nazwaUzytkownia, String nazwaNadajacego) {
        Model.getInstance().getDataBaseDriver().createTask(idPracownika, desc, subject, starDate, endDate, nazwaNadajacego, nazwaUzytkownia);
    }


    //Zwykly pracownik
    ////////////////////////////////////////////////////////////////
    public ObservableList<Zadanie> getTasks() {
        return tasks;
    }

    public ObservableList<Zadanie> getFishedTasks() {
        return tasks_finished;
    }

    public void setTasks(String type) {
        ResultSet resultSet;
        if (Objects.equals(type, "assigned")) {
            resultSet = dataBaseDriver.getAssignedTask(client.getIdPracownika());
        } else if (Objects.equals(type, "assignedTo")) {
            resultSet = dataBaseDriver.getAssignedTaskToLv(client.getNazwaUzytkownika());
        } else {
            resultSet = dataBaseDriver.getFinishedTask(client.getIdPracownika());
        }

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
                String nazwaUzytkownika = resultSet.getString("nazwaUzytkownika");
                if (Objects.equals(type, "assigned")) {
                    tasks.add(0, new Zadanie(id, temat, opis, dataRozpoczecia, dataZakonczenia, status, idPracownika, nazwaUzytkownikaNadajacego, nazwaUzytkownika));
                } else if (Objects.equals(type, "assignedTo")) {
                    tasksAssignedTo.add(0, new Zadanie(id, temat, opis, dataRozpoczecia, dataZakonczenia, status, idPracownika, nazwaUzytkownikaNadajacego, nazwaUzytkownika));
                } else {
                    tasks_finished.add(0, new Zadanie(id, temat, opis, dataRozpoczecia, dataZakonczenia, status, idPracownika, nazwaUzytkownikaNadajacego, nazwaUzytkownika));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void clearTasks() {
        tasks.clear();
    }

    public void clearFinishedTasks() {
        tasks_finished.clear();
    }

    public void removeTask(Zadanie task) {
        tasks.remove(task);
        tasks_finished.add(0, task);
    }

    public void setAssignedTaskLV(ListView x) {
        task_list_listview = x;
    }

    public void setfinishedTaskLV(ListView x) {
        ended_task_list_listview = x;
    }

    public void refreshfinishedTaskLV() {
        ended_task_list_listview.refresh();
    }

    public void refreshAssignedTaskLV() {
        ended_task_list_listview.refresh();
    }

    public Integer getSizeAssignedTask() {
        return task_list_listview.getItems().size();
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
                        WystawaidWystawy, ZadanieidZadania, SalaidSali, ZadaniePracownikidPracownika,""));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Dla listy wystaw
    public ObservableList<Exhibition> getExhibitions() {
        return exhibitions;
    }

    public void setExhibitions() {
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
    public ObservableList<Exhibit> getSearchedExhibits() {
        return exhibitsSearched;
    }

    public void setExhibitsSearched(String nazwa, String autor, String topic, Integer rok1, Integer rok2, String
            miejsce) {
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
                        WystawaidWystawy, ZadanieidZadania, SalaidSali, ZadaniePracownikidPracownika,""));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ObservableList<String> getRooms() {
        return rooms;
    }

    public void clearRooms() {
        rooms.clear();
    }

    public void setRoom() {
        ResultSet resultSet = dataBaseDriver.getRoomsNames();

        try {
            while (resultSet.next()) {
                Integer id = resultSet.getInt("idSali");
                Integer wielksc = resultSet.getInt("wielkość");
                String nazwa = resultSet.getString("nazwa");
                String typ = resultSet.getString("typ");
                rooms.add(nazwa);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ObservableList<String> getAllRooms() {
        return allRooms;
    }

    public void clearAllRooms() {
        allRooms.clear();
    }

    public void setAllRooms() {
        ResultSet resultSet = dataBaseDriver.getAllRoomsNames();

        try {
            while (resultSet.next()) {
                Integer id = resultSet.getInt("idSali");
                Integer wielksc = resultSet.getInt("wielkość");
                String nazwa = resultSet.getString("nazwa");
                String typ = resultSet.getString("typ");
                allRooms.add(nazwa);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    //Technical worker
    ////////////////////////////////////////////////////////////////
    List<Integer> idZadList = new ArrayList<Integer>();
    List<Integer> idZadExList = new ArrayList<Integer>();
    public void setExIds() throws SQLException {
        for (Zadanie task : tasks) {
            ResultSet resultSet = dataBaseDriver.getTechnicianEx(task.getIdZadania(), client.getIdPracownika());
            System.out.println(task.getIdZadania());
            while (resultSet.next()) {
                int value = resultSet.getInt(1);
                Integer idZadEx=resultSet.getInt(2);
                Integer idZad=task.getIdZadania();
                idZadList.add(idZad);
                idZadExList.add(idZadEx);
                System.out.println(value);
                exIds.add(value);
            }
        }
        System.out.println(exIds);
    }

    public void clearExIds() {
        idZadExList.clear();
        idZadList.clear();
        exIds.clear();
    }

    public void setExModel() throws SQLException {
        int i=0;
        for (Integer id : exIds) {
            ResultSet resultSet = dataBaseDriver.getExById(id);

            while (resultSet.next()) {

                Integer idEx= resultSet.getInt(1);
                String nazwaEksponatu=resultSet.getString(2);
                String docMiejsce=resultSet.getString(3);
                String aktualMiejscePrzech=resultSet.getString(4);
                if(!docMiejsce.isBlank() || !docMiejsce.equals("-"))
                {
                    System.out.println(idZadList.get(i)+"KOKO");
                    System.out.println(idZadExList.get(i)+"xoxo");
                    Exhibit x = new Exhibit(idEx,nazwaEksponatu,aktualMiejscePrzech,docMiejsce, idZadList.get(i),idZadExList.get(i));
                    i++;
                    exhibitsAssigned.add(x);
                }
            }
        }
    }

    public ObservableList<Exhibit> getExhibitsAssigned() {
        System.out.println(exhibitsAssigned);
        return exhibitsAssigned;
    }

    public void removeExhibitsAssigned(Exhibit ex) {
            exhibitsAssigned.remove(ex);
    }

    public void checkExhibit(Exhibit exhibit) {
        exhibitsChecked.add(exhibit);
        System.out.println(exhibitsChecked);
    }


    public void uncheckWorker(Exhibit exhibit) {
        exhibitsChecked.remove(exhibit);

        System.out.println(exhibitsChecked);
    }

    public void clearCheckedEx() {
        exhibitsChecked.clear();

        System.out.println(exhibitsChecked);
    }


    public void clearExAssigned() {
        exhibitsAssigned.clear();

    }
    public ObservableList<Exhibit> getExChecked() {
        System.out.println(exhibitsChecked);
        return exhibitsChecked;
    }
////////////////////////////////////////////////////////////////

}


