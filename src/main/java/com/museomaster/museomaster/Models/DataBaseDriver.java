package com.museomaster.museomaster.Models;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataBaseDriver {
    private Connection conn;

    public DataBaseDriver(Connection conn){
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
}
