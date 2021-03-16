package com.annushkaproject.programmerscalculator.managers

import com.annushkaproject.programmerscalculator.model.HistoryResult
import io.realm.Realm
import io.realm.RealmConfiguration
import java.util.*

class HistoryManager private constructor() {
    private val config = RealmConfiguration.Builder().name(DATABASE_NAME).build()
    private val realm = Realm.getInstance(config)
    fun printDatabaseLocation() {
        println("Realm db path: " + realm.path)
    }

    fun save(resultString: String?) {
        realm.beginTransaction()
        val result = realm.createObject(HistoryResult::class.java)
        result.result = resultString
        realm.commitTransaction()
    }

    fun deleteResult(resultToDelete: HistoryResult?) {
        val results = realm.where(HistoryResult::class.java).equalTo("id", resultToDelete.id).findAll()
        if (results.size > 0) {
            realm.beginTransaction()
            results.deleteAllFromRealm()
            realm.commitTransaction()
        }
    }

    fun fetchAllHistoryResults(): ArrayList<HistoryResult?>? {
        return ArrayList(realm.where(HistoryResult::class.java).findAll())
    }

    companion object {
        private val DATABASE_NAME: String? = "calculator.realm"
        private val managerInstance: HistoryManager? = HistoryManager()
        fun getSharedInstance(): HistoryManager? {
            return managerInstance
        }
    }
}