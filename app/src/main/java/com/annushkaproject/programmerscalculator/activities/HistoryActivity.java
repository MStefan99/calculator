package com.annushkaproject.programmerscalculator.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.annushkaproject.programmerscalculator.R;
import com.annushkaproject.programmerscalculator.managers.HistoryManager;
import com.annushkaproject.programmerscalculator.model.HistoryResult;
import com.annushkaproject.programmerscalculator.model.ThemeSetting;
import com.annushkaproject.programmerscalculator.utils.SharedPreferencesUtil;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    private ListView lvHistory;
    ArrayAdapter arrayAdapter;
    String result;

    ArrayList<String> historyResults = getResults();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferencesUtil prefUtil = new SharedPreferencesUtil(this);
        setTheme(ThemeSetting.getThemeStyleByThemeSetting(prefUtil.loadThemeSetting()));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        //add back press button
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lvHistory = findViewById(R.id.lvHistory);

        arrayAdapter = new ArrayAdapter<String>(this, R.layout.history_adapter,
                historyResults);
        lvHistory.setAdapter(arrayAdapter);

        lvHistory.setOnItemClickListener((AdapterView<?> parent, View view, int position, long id) -> {
            deleteItem(position);
            arrayAdapter.notifyDataSetChanged();
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private ArrayList<String> getResults() {
        ArrayList<HistoryResult> list = HistoryManager.getSharedInstance().fetchAllHistoryResults();
        ArrayList<String> results = new ArrayList<String>();
        for (HistoryResult result: list) {
            results.add(result.getResult());
        }
        return results;
    }

    private void deleteItem(int position) {
        ArrayList<HistoryResult> results = HistoryManager.getSharedInstance().fetchAllHistoryResults();
        HistoryResult result = results.get(position);
        historyResults.remove(position);
        HistoryManager.getSharedInstance().deleteResult(result);

    }
}
