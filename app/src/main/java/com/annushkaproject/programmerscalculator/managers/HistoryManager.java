package com.annushkaproject.programmerscalculator.managers;

import com.annushkaproject.programmerscalculator.model.HistoryResult;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import java.util.Date;

public class HistoryManager {

    public static final String DATABASE_NAME = "calculator.realm";

    private static final HistoryManager managerInstance = new HistoryManager();

    RealmConfiguration config = new RealmConfiguration.Builder().name(DATABASE_NAME).build();
    private Realm realm;

    private HistoryManager() {
        Realm.setDefaultConfiguration(config);
        realm = Realm.getDefaultInstance();
    }

    public static HistoryManager getSharedInstance() {
        return managerInstance;
    }

    public void printDatabaseLocation() {
        System.out.println("Realm db path: " + realm.getPath());
    }

    public void save(String resultString) {
        realm.beginTransaction();
        HistoryResult result = realm.createObject(HistoryResult.class);
        result.setResult(resultString);
        realm.commitTransaction();
    }

    public void deleteObjectWithDate(String result, Date date) {
        RealmResults<HistoryResult> results = realm.where(HistoryResult.class).equalTo(result, date).findAll();
        realm.beginTransaction();
        results.deleteAllFromRealm();
        realm.commitTransaction();
    }

    public ArrayList<HistoryResult> fetchAllHistoryResults() {
        ArrayList<HistoryResult> results = new ArrayList(realm.where(HistoryResult.class).findAll());
        return results;
    }
}
