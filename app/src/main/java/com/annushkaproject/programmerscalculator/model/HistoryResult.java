package com.annushkaproject.programmerscalculator.model;

import java.util.Date;
import java.util.UUID;

import io.realm.RealmObject;

/**
 * Model object to store in Realm database or extract from it.
 */
public class HistoryResult extends RealmObject {

    private String result = "";
    private Date saveDate = new Date();
    private String id = UUID.randomUUID().toString();

    /**
     * Creates HistoryResult model object, sets current date as creation date, creates unique identifier.
     *
     * @param result String parameter represented result.
     */
    public void setResult(String result) {
        this.result = result;
    }

    /**
     * Returns result represented by String.
     *
     * @return Result represented by String.
     */
    public String getResult() {
        return result;
    }

    /**
     * Returns date when result was saved.
     *
     * @return Date of HistoryResult save.
     */
    public Date getSaveDate() {
        return saveDate;
    }

    /**
     * Returns unique id for current result.
     *
     * @return Unique identifier of HistoryResult object.
     */
    public String getId() {
        return id;
    }
}
