package com.museomaster.museomaster.Models;

import com.museomaster.museomaster.Views.ViewFactory;
import javafx.beans.property.StringProperty;

public class Model {
    private static Model model;
    private final ViewFactory viewFactory;


    private Model(){
        this.viewFactory = new ViewFactory();
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
}
