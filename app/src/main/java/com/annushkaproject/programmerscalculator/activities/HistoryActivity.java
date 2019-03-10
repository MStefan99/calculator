package com.annushkaproject.programmerscalculator.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.annushkaproject.programmerscalculator.R;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    private ListView lvHistory;
    private ArrayList<String> list = new ArrayList<>();
    ArrayAdapter arrayAdapter;
    String operations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        //add back press button
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lvHistory = findViewById(R.id.lvHistory);
        list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
        list.add("lll");


        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1
                ,list);
        loadArrayList(getApplicationContext());
        lvHistory.setAdapter(arrayAdapter);

        lvHistory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                list.remove(position);
                arrayAdapter.notifyDataSetChanged();
                saveArrayList();
            }
        });
        }
        private void saveArrayList() {
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("operations_size", list.size());

            for(int i=0; i<list.size(); i++) {
                editor.remove("operations" + i);
                editor.putString("operations" + i, list.get(i));
            }
            editor.commit();
        }
        private void loadArrayList(Context context) {
            SharedPreferences sharedPref2 = PreferenceManager.getDefaultSharedPreferences(context);
            list.clear();
            int size = sharedPref2.getInt("operations_size", 0);

            for(int i=0; i<size; i++) {
            list.add(sharedPref2.getString("operations" + i, null));
            }
        }
        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            this.finish();
        }
         return super.onOptionsItemSelected(item);
        }


}
