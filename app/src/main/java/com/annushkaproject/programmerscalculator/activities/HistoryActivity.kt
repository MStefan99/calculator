package com.annushkaproject.programmerscalculator.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemClickListener
import com.annushkaproject.programmerscalculator.R
import com.annushkaproject.programmerscalculator.managers.HistoryManager
import com.annushkaproject.programmerscalculator.model.HistoryResult
import com.annushkaproject.programmerscalculator.model.ThemeSetting.Companion.getThemeStyleByThemeSetting
import com.annushkaproject.programmerscalculator.utils.SharedPreferencesUtil
import java.util.*

class HistoryActivity : AppCompatActivity() {
    private var historyListView: ListView? = null
    private var arrayAdapter: ArrayAdapter<*>? = null
    var historyResults = getResults()
    override fun onCreate(savedInstanceState: Bundle?) {
        val prefUtil = SharedPreferencesUtil(this)
        setTheme(getThemeStyleByThemeSetting(prefUtil.loadThemeSetting()))
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        val toolbar = findViewById<Toolbar?>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar.setDisplayShowHomeEnabled(true)
        supportActionBar.setDisplayHomeAsUpEnabled(true)
        historyListView = findViewById(R.id.lvHistory)
        arrayAdapter = ArrayAdapter(this, R.layout.history_adapter, historyResults)
        historyListView.setAdapter(arrayAdapter)
        historyListView.setOnItemClickListener(OnItemClickListener { parent: AdapterView<*>?, view: View?, position: Int, id: Long ->
            deleteItem(position)
            arrayAdapter.notifyDataSetChanged()
        })
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item.getItemId()
        if (id == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getResults(): ArrayList<String?>? {
        val list: ArrayList<HistoryResult?> = HistoryManager.Companion.getSharedInstance().fetchAllHistoryResults()
        val results = ArrayList<String?>()
        for (result in list) {
            results.add(result.result)
        }
        return results
    }

    private fun deleteItem(position: Int) {
        val results: ArrayList<HistoryResult?> = HistoryManager.Companion.getSharedInstance().fetchAllHistoryResults()
        val result = results[position]
        historyResults.removeAt(position)
        HistoryManager.Companion.getSharedInstance().deleteResult(result)
    }
}