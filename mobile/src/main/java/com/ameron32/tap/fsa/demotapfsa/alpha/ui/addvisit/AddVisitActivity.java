package com.ameron32.tap.fsa.demotapfsa.alpha.ui.addvisit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.ameron32.tap.fsa.demotapfsa.R;

public class AddVisitActivity extends AppCompatActivity {

  public static Intent makeIntent(Context context) {
    Intent intent = new Intent(context, AddVisitActivity.class);
    return intent;
  }

  public static Intent makeIntent(Context context, String description, String notes) {
    Intent intent = makeIntent(context);
    intent.putExtra("description", description);
    intent.putExtra("notes", notes);
    return intent;
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_visit_alpha);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        setResult(RESULT_OK);
        finish();
      }
    });
    if (isNew()) {
      setStateCreate();
    } else {
      setStateView();
    }
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
  }

  private void setStateCreate() {
  }

  private void setStateView() {

  }

  private void setStateUpdate() {
  }

  public boolean isNew() {
    Bundle bundle = getIntent().getExtras();
    if (bundle == null) {
      return true;
    }
    return false;
  }

  public Bundle getIntentBundle() {
    if (isNew()) {
      return null;
    }
    return getIntent().getExtras();
  }
}
