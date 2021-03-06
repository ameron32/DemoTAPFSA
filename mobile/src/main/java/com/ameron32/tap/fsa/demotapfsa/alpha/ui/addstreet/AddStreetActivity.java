package com.ameron32.tap.fsa.demotapfsa.alpha.ui.addstreet;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.ameron32.tap.fsa.demotapfsa.R;

public class AddStreetActivity extends AppCompatActivity {

    public static final int RESULT_SAVE_COMPLETE = 316;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_street_alpha);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_SAVE_COMPLETE);
                finish();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void onRadioButtonClicked(View v) {
        AddStreetFragment addStreetFragment = (AddStreetFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
        addStreetFragment.onRadioButtonClicked(v);
    }

}
