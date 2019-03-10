package com.annushkaproject.programmerscalculator.model;

import java.util.Date;
import java.util.UUID;

import io.realm.RealmObject;

public class HistoryResult extends RealmObject {

    private String result = "";
    private Date saveDate = new Date();
    private String id = UUID.randomUUID().toString();

    public void setResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public Date getSaveDate() {
        return saveDate;
    }

    public String getId() {
        return id;
    }
}
