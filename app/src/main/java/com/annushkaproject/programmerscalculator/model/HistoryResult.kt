package com.annushkaproject.programmerscalculator.model

import io.realm.RealmObject
import java.util.*

class HistoryResult : RealmObject() {
    var result = ""
    val saveDate = Date()
    val id = UUID.randomUUID().toString()
}