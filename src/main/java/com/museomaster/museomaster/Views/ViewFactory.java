package com.museomaster.museomaster.Views;

import com.museomaster.museomaster.Enums.AccountType;
import com.museomaster.museomaster.TypyUzytkownikow.Administrator.AdministratorDashboardController;
import com.museomaster.museomaster.TypyUzytkownikow.Kurator.KuratorDashboardController;
import com.museomaster.museomaster.TypyUzytkownikow.Pracownik.PracownikController;
import com.museomaster.museomaster.TypyUzytkownikow.PracownikUprawniony.PracownikUprawnionyController;
import com.museomaster.museomaster.TypyUzytkownikow.ZwyklyKonswerwator.ZwyklyKonserwator;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ViewFactory {
    //Typ konta
    private AccountType loginAccountType;
    //Zmienne, w których przechowywane są aktualnie wybrane opcji przez poszczególnych pracowników
    private final StringProperty adminSelectedMenuItem;
    private final StringProperty permissionWorkerSelectedMenuItem;
    private final StringProperty technicalWorkerItem;
    private final StringProperty WorkerItem;
    private final StringProperty KuratorSelectedMenuItem;

    /**
     * Konstruktor bezargumentowy, inicjalizuje nam zmienne stworzone wyżej.
     */
    public ViewFactory(){
        this.loginAccountType = AccountType.PRACOWNIK; // Domyślny wybór to zwykły pracownik (zakł, że jest ich najwięcej)
        this.adminSelectedMenuItem = new SimpleStringProperty("");
        this.permissionWorkerSelectedMenuItem = new SimpleStringProperty("");
        this.technicalWorkerItem = new SimpleStringProperty("");
        this.WorkerItem = new SimpleStringProperty("");
        this.KuratorSelectedMenuItem = new SimpleStringProperty("");
    }
    // Gettery stworzone dla Zaznaczonych elementów menu
    public StringProperty getAdminSelectedMenuItem(){
        return adminSelectedMenuItem;
    }
    public StringProperty getPermissionWorkerSelectedMenuItem(){
        return permissionWorkerSelectedMenuItem;
    }
    public StringProperty getTechnicalWorkerSelectedMenuItem(){
        return technicalWorkerItem;
    }
    public StringProperty getWorkerSelectedMenuItem(){
        return WorkerItem;
    }
    public StringProperty getKuratorSelectedMenuItem(){return KuratorSelectedMenuItem;}

    /**
     * Funckja jest odpowiedzialna na wyśiwtlanie okna Loginu w aplikacji
     */
    public void showLoginWindow(){
        System.out.println(getClass().getResource("Fxml/Login.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Login.fxml"));
        createStage(loader);
    }

    private AnchorPane view;

    //Admin Views
    ////////////////////////////////////////////////////////////////////////

    public void showAdminWindow(){
        System.out.println(getClass().getResource("/Fxml/Administrator/AdminDashboard.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Administrator/AdminDashboard.fxml"));
        AdministratorDashboardController adminController = new AdministratorDashboardController();
        loader.setController(adminController);

        createStage(loader);

    }
    private AnchorPane dashboardView;
    private AnchorPane addRoomView;

    private AnchorPane userListView;
    private AnchorPane ReportListView;

    public AnchorPane getAdminView(String fxmlPath, String anchorPaneName){

        switch (anchorPaneName){
            case "addRoomView" -> view = dashboardView;
            case "userListView" -> view = userListView;
            case "reportListView" -> view = ReportListView;
            default -> view = dashboardView;
        }

        if(view==null){
            try{
                view = new FXMLLoader(getClass().getResource(fxmlPath)).load();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return view;
    }
    ////////////////////////////////////////////////////////////////



    //Normal WorkerViews
    ////////////////////////////////////////////////////////////////

    public void showWorkerWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Pracownik/Pracownik.fxml"));
        PracownikController pracownikController = new PracownikController();
        loader.setController(pracownikController);
        createStage(loader);

    }

    AnchorPane view1;
    public AnchorPane showReportView(){

        if(view1==null){
            try{
                view1 = new FXMLLoader(getClass().getResource("/Fxml/Problem/ProblemDashboard.fxml")).load();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return view1;
    }

    AnchorPane view2;
    public AnchorPane showWorkerDashboardView(){

        if(view2==null){
            try{
                view2 = new FXMLLoader(getClass().getResource("/Fxml/Pracownik/PracownikDashboard.fxml")).load();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return view2;
    }

    ////////////////////////////////////////////////////////////////





    //Worker with permissions View
    ////////////////////////////////////////////////////////////////

    public void showPermissionWorkerWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/PracownikUprawniony/PracownikUprawniony.fxml"));
        PracownikUprawnionyController pracownikController = new PracownikUprawnionyController();
        loader.setController(pracownikController);
        createStage(loader);

    }

    private AnchorPane WorkerDashboard;
    private AnchorPane WorkerGiveTask;

    private AnchorPane CreateTask;

    private AnchorPane WyborZabytkow;

    private AnchorPane report;

    private AnchorPane searchEx;
    public AnchorPane showPermissionWorkerView(String fxmlPath, String anchorPaneName){

        System.out.println("jestem tu");
        switch (anchorPaneName){
            case "searchEx"-> view=searchEx;
            case "report" -> view=report;
            case "wyborZabytkow"->view = WyborZabytkow;
            case "assign"->view=WorkerGiveTask;
            case "giveTask" -> view=WorkerGiveTask;
            case "createTask" -> view=CreateTask;
            default -> view=WorkerDashboard;
        }

        if(view==null){
            try{
                view = new FXMLLoader(getClass().getResource(fxmlPath)).load();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return view;
    }

    ////////////////////////////////////////////////////////////////




    //ZwyklyKonserwator
    ////////////////////////////////////////////////////////////////

    public void showTechnicalWorkerWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/ZwyklyKonserwator/ZwyklyKonserwator.fxml"));
        ZwyklyKonserwator pracownikController = new ZwyklyKonserwator();
        loader.setController(pracownikController);
        createStage(loader);

    }

    AnchorPane technicalDashBoard;

    AnchorPane taskList;
    AnchorPane lista_eksponatow;
    public AnchorPane showTechnicalWorkerView(String fxmlPath, String anchorPaneName){

        switch (anchorPaneName){
            case "report"-> view = report;
            case "taskList"-> view = taskList;
            case "lista_eksponatow" -> view = lista_eksponatow;
            default -> view=technicalDashBoard;
        }

        if(view==null){
            try{
                view = new FXMLLoader(getClass().getResource(fxmlPath)).load();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return view;
    }

    //Kurator
    //////////////////////////////////////

    /**
     * Ta metoda jest używana do załadowania odpowiedniego okna dla kuratora
     * Kurator Dashboard składa się z lewej części -> Menu oraz z części centralnej -> odpowiednia zakładka
     */
    public void showKuratorWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Kurator/KuratorDashboard.fxml"));
        KuratorDashboardController kuratorController = new KuratorDashboardController();
        loader.setController(kuratorController);
        createStage(loader);
    }

    /**
     * Tworzymy odpowiednie widoki dla każdego możliwego przypadku
     */
    AnchorPane task_list, task_add, add_ex, ex_list, ad_ex, search_ex, kuratorDashboard, przydzielZadanie, wyborZabytkow, searchExp, lista_zabytkow;

    /**
     * Metoda używanan do odpowiednie zmiany widoku dla kuratora, w zależności od aktywności Kuratora zmienia się centralna część jego ekranu
     * @param fxmlPath -> ścieżka do pliku fxml jaki mamy załadować
     * @param anchorPaneName -> nazwa AnchorPane'a którą przekazujemy
     * @return -> zwracamy wybrany przez nas widok
     */
    public AnchorPane showKuratorView(String fxmlPath, String anchorPaneName){

        switch (anchorPaneName){
            case "task_list"-> view = task_list;
            case "task_add" -> view = task_add;
            case "add_ex"-> view = add_ex;
            case "ex_list"-> view = ex_list;
            case "ad_ex" -> view = ad_ex;
            case "search_ex" -> view = search_ex;
            case "searchEx" -> view = searchExp;
            case "lista_zabytkow" -> view = lista_zabytkow;
            case "przydzielZadanie" -> view = przydzielZadanie;
            case "wyborZabytkow"-> view = wyborZabytkow;
            default -> view = kuratorDashboard;
        }
        /**
         * Próba zmiany widoku kuratora
         * Gdy wystąpi błąd wypisywany jest błąc
         */
        if(view==null){
            try{
                view = new FXMLLoader(getClass().getResource(fxmlPath)).load();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return view;
    }
    ////////////////////////////////////////////////////////////////

    //Utility Methods
    ////////////////////////////////////////////////////////////////

    /**
     * Funkcja używana do tworzenia stage'a
     * @param loader -> przekazujemy loader którego będziemy używać do załadowania sceny
     */
    private static void createStage(FXMLLoader loader) {
        Scene scene = null;

        try{
            scene = new Scene(loader.load());
        }
        catch(Exception e){
            e.printStackTrace();
        }

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("MuesoMaster");
        stage.setResizable(false);
        stage.show();
    }

    /**
     * Metoda odpowiedzialna za zamknięcie stage'a
     * @param stage -> przesyłamy stage'a, którego chcemu zamknąć
     */
    public void closeStage(Stage stage){
        stage.close();
    }

    public AccountType getLoginAccountType() {
        return loginAccountType;
    }

    public void setLoginAccountType(AccountType loginAccountType) {
        this.loginAccountType = loginAccountType;
    }
}
