package ru.ratmir.soft.notifycloudmassadges;

import java.util.HashMap;

/**
 * Created RATMIR on 15.04.2018.
 * Copyright © Ratmir
 */
public class AppInstanceState {
    //public static final String ORDER_KEY = "user_order";
    // public static final String BETON_MARCK = "beton_mark";

    private static AppInstanceState appInstanceState;

    private HashMap<String, Object> instance;

    private AppInstanceState(){
        instance = new HashMap<>();
    }

    public static AppInstanceState newInstance(){
        if(appInstanceState == null)
            return new AppInstanceState();
        else return appInstanceState;
    }

    public static void createInstance(){
        if(appInstanceState == null)
            appInstanceState = new AppInstanceState();
    }

    public void saveData(String key, Object value){
        instance.put(key, value);
    }

    public Object restoreData(String key){
        return instance.get(key);
    }

    public void removeDate(String key){
        instance.remove(key);
    }

    public boolean isEmpty(){
        return instance.isEmpty();
    }

    public void clearMap(){
        instance.clear();
    }

    public int getMapCount(){
        return instance.size();
    }
}
