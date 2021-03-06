package com.ananth.scrollingtechniques;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ToolbarOffScreen extends AppCompatActivity {

    private Toolbar toolbar;

    String[] versions = {"Cupcake", "Donut", "Eclair",
            "Froyo", "Gingerbread", "Honeycomb",
            "Icecream Sandwich", "Jelly Bean", "Kitkat", "Lollipop","Marshmellow"};
    private RecyclerView mVersionsList;
    private SimpleRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar_off_screen);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.back_arrow);
        mVersionsList = (RecyclerView) findViewById(R.id.scrollableview);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ToolbarOffScreen.this);
        mVersionsList.setLayoutManager(linearLayoutManager);
        mVersionsList.setHasFixedSize(true);
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < versions.length; i++) {
            list.add(versions[i]);
        }

        adapter = new SimpleRecyclerAdapter(list);
        mVersionsList.setAdapter(adapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Welcome to android", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
            return true;
        }
        /*switch (item.getItemId()) {

            case R.id.edit_icon:
                Toast.makeText(this, "Settings selected", Toast.LENGTH_SHORT)
                        .show();
                break;
            default:
                break;
        }*/
        return true;
    }
}
