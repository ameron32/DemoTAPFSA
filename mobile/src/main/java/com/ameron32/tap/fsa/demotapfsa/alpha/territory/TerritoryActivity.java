package com.ameron32.tap.fsa.demotapfsa.alpha.territory;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.ameron32.tap.fsa.demotapfsa.R;

public class TerritoryActivity extends AppCompatActivity implements DummyTerritoryAdapter.OnAnyItemsCheckedListener {

    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_territory_alpha);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        setAddButton();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getAdapter().setOnAnyItemsCheckedListener(this);
    }

    public DummyTerritoryAdapter getAdapter() {
        TerritoryFragment territoryFragment = (TerritoryFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
        return territoryFragment.getAdapter();
    }

    @Override
    public void onAnyItemsCheckedChange(boolean anyItemsChecked) {
        if (anyItemsChecked) {
            setDeleteButton();
        } else {
            setAddButton();
        }
    }

    public View.OnClickListener getAddListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Add a Territory", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        };
    }

    private void setAddButton() {
        fab.setImageResource(R.drawable.ic_action_add);
        fab.setOnClickListener(getAddListener());
    }

    public View.OnClickListener getDeleteListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Delete a Territory", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        };
    }

    private void setDeleteButton() {
        fab.setImageResource(R.drawable.ic_delete);
        fab.setOnClickListener(getDeleteListener());
    }
}
