package com.ameron32.tap.fsa.demotapfsa.alpha.ui.addcall;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.ameron32.tap.fsa.demotapfsa.R;
import com.ameron32.tap.fsa.demotapfsa.alpha.ui.addterritory.AddTerritoryActivity;
import com.ameron32.tap.fsa.demotapfsa.alpha.ui.common.OnAnyItemsCheckedListener;

public class AddCallActivity extends AppCompatActivity implements OnAnyItemsCheckedListener {

  public static final int RESULT_SAVE_COMPLETE = 712;
  private static final int ADD_VISIT = 976;

  FloatingActionButton fab;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_call_alpha);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    fab = (FloatingActionButton) findViewById(R.id.fab);
    setSaveButton();
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (requestCode == ADD_VISIT) {
      if (resultCode == AddTerritoryActivity.RESULT_SAVE_COMPLETE) {
        Snackbar.make(fab, "Visit Added", Snackbar.LENGTH_LONG)
                .setAction("OK", null)
                .show();
      }
    }
  }

  public DummyVisitAdapter getAdapter() {
    AddCallFragment addCallFragment = (AddCallFragment) getSupportFragmentManager()
            .findFragmentById(R.id.fragment);
    return addCallFragment.getAdapter();
  }

  public void enableAdapter() {
    AddCallFragment addCallFragment = (AddCallFragment) getSupportFragmentManager()
            .findFragmentById(R.id.fragment);
    addCallFragment.enableAdapter();
  }

  @Override
  public void onAnyItemsCheckedChange(boolean anyItemsChecked) {
    if (anyItemsChecked) {
      setDeleteButton();
    } else {
      setAddButton();
    }
  }

  private void enableListChecking() {
    getAdapter().setOnAnyItemsCheckedListener(AddCallActivity.this);
  }

  private void disableListChecking() {
    getAdapter().setOnAnyItemsCheckedListener(null);
  }

  public View.OnClickListener getSaveListener() {
    return new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        enableAdapter();
        enableListChecking();
        setAddButton();
      }
    };
  }

  private void setSaveButton() {
    fab.setImageResource(R.drawable.ic_save);
    fab.setOnClickListener(getSaveListener());
  }

  public View.OnClickListener getAddListener() {
    return new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        // TODO add new visit dialog
        Snackbar.make(view, "Add Visit", Snackbar.LENGTH_LONG)
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
        Snackbar.make(view, "Delete Selected Visit(s)", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
      }
    };
  }

  private void setDeleteButton() {
    fab.setImageResource(R.drawable.ic_delete);
    fab.setOnClickListener(getDeleteListener());
  }
}
