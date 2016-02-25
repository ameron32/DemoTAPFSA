package com.ameron32.tap.fsa.demotapfsa.alpha.ui.notathomes;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.ameron32.tap.fsa.demotapfsa.R;
import com.ameron32.tap.fsa.demotapfsa.alpha.ui.addstreet.AddStreetActivity;
import com.ameron32.tap.fsa.demotapfsa.alpha.ui.common.OnAnyItemsCheckedListener;

public class NotAtHomesActivity extends AppCompatActivity
        implements OnAnyItemsCheckedListener {

    private static final int ADD_STREET = 664;

    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_not_at_homes_alpha);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADD_STREET) {
            if (resultCode == AddStreetActivity.RESULT_SAVE_COMPLETE) {
                Snackbar.make(fab, "Street Added", Snackbar.LENGTH_LONG)
                        .setAction("OK", null)
                        .show();
            }
        }
    }

    public DummyStreetAdapter getAdapter() {
        NotAtHomesFragment notAtHomesFragment = (NotAtHomesFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment);
        return notAtHomesFragment.getAdapter();
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
                Intent intent = new Intent(NotAtHomesActivity.this, AddStreetActivity.class);
                startActivityForResult(intent, ADD_STREET);
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
                Snackbar.make(view, "Delete Selected Street(s)", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        };
    }

    private void setDeleteButton() {
        fab.setImageResource(R.drawable.ic_delete);
        fab.setOnClickListener(getDeleteListener());
    }

}
