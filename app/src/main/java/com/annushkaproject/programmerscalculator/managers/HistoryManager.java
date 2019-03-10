package com.annushkaproject.programmerscalculator.managers;

public class HistoryManager {
    private static final HistoryManager managerInstance = new HistoryManager();

    public static HistoryManager getSharedInstance() {
        return managerInstance;
    }

    private HistoryManager() {}
}
