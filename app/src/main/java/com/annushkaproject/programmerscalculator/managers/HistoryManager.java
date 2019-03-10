package com.annushkaproject.programmerscalculator.managers;

import com.annushkaproject.programmerscalculator.model.HistoryResult;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import java.util.Date;

/**
 * Singleton for handling communication with Realm database. Requires Realm.init() call once before usage.
 */
public class HistoryManager {

    private static final String DATABASE_NAME = "calculator.realm";

    private static final HistoryManager managerInstance = new HistoryManager();

    private RealmConfiguration config = new RealmConfiguration.Builder().name(DATABASE_NAME).build();
    private Realm realm = Realm.getInstance(config);

    private HistoryManager() {}

    public static HistoryManager getSharedInstance() {
        return managerInstance;
    }

    /**
     * Debug method for printing current calculator.realm database file's path.
     */
    public void printDatabaseLocation() {
        System.out.println("Realm db path: " + realm.getPath());
    }

    /**
     * Takes result value and saves it to database.
     *
     * @param resultString String with result value.
     */
    public void save(String resultString) {
        realm.beginTransaction();
        HistoryResult result = realm.createObject(HistoryResult.class);
        result.setResult(resultString);
        realm.commitTransaction();
    }

    /**
     * Gets result object, remove from database if exists.
     *
     * @param resultToDelete HistoryResult object to delete.
     */
    public void deleteResult(HistoryResult resultToDelete) {
        RealmResults<HistoryResult> results = realm.where(HistoryResult.class).equalTo("id", resultToDelete.getId()).findAll();
        if (results.size() > 0) {
            realm.beginTransaction();
            results.deleteAllFromRealm();
            realm.commitTransaction();
        }
    }

    /**
     * Fetch all saved history data.
     * @return ArrayList of all founded HistoryResults that were saved previously.
     */
    public ArrayList<HistoryResult> fetchAllHistoryResults() {
        ArrayList<HistoryResult> results = new ArrayList(realm.where(HistoryResult.class).findAll());
        return results;
    }
}
