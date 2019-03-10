package com.annushkaproject.programmerscalculator.managers;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class HistoryManager {

    public static final String DATABASE_NAME = "calculator.realm";

    private static final HistoryManager managerInstance = new HistoryManager();

    RealmConfiguration config = new RealmConfiguration.Builder().name(DATABASE_NAME).build();
    private Realm realm;

    public static HistoryManager getSharedInstance() {
        return managerInstance;
    }

    private HistoryManager() {
        Realm.setDefaultConfiguration(config);
        realm = Realm.getDefaultInstance();
    }

    public void printDatabaseLocation() {
        System.out.println("Realm db path: " + realm.getPath());
    }
}
