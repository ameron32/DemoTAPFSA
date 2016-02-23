package com.ameron32.tap.fsa.demotapfsa.alpha.ui.addterritory;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.ameron32.tap.fsa.demotapfsa.R;

public class AddTerritoryActivity extends AppCompatActivity {

  public static final int RESULT_SAVE_COMPLETE = 253;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_territory_alpha);
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
  }

}
