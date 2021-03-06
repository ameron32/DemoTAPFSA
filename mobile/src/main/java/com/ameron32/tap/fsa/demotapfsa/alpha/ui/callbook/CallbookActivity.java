package com.ameron32.tap.fsa.demotapfsa.alpha.ui.callbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.ameron32.tap.fsa.demotapfsa.R;
import com.ameron32.tap.fsa.demotapfsa.alpha.model.Call;
import com.ameron32.tap.fsa.demotapfsa.alpha.ui.addcall.AddCallActivity;
import com.ameron32.tap.fsa.demotapfsa.alpha.ui.common.OnAnyItemsCheckedListener;
import com.ameron32.tap.fsa.demotapfsa.alpha.ui.common.OnItemClickedListener;

public class CallbookActivity extends AppCompatActivity
    implements OnAnyItemsCheckedListener, OnItemClickedListener<Call> {

    private static final int ADD_CALL = 364;

    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_callbook_alpha);
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
        getAdapter().setOnItemClickedListener(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        getAdapter().setOnAnyItemsCheckedListener(null);
        getAdapter().setOnItemClickedListener(null);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADD_CALL) {
            if (resultCode == AddCallActivity.RESULT_SAVE_COMPLETE) {
                Snackbar.make(fab, "Call Added", Snackbar.LENGTH_LONG)
                    .setAction("OK", null)
                    .show();
            }
        }
    }

    public DummyCallAdapter getAdapter() {
        CallbookFragment callbookFragment = (CallbookFragment) getSupportFragmentManager()
            .findFragmentById(R.id.fragment);
        return callbookFragment.getAdapter();
    }

    @Override
    public void onAnyItemsCheckedChange(boolean anyItemsChecked) {
        if (anyItemsChecked) {
            setDeleteButton();
        } else {
            setAddButton();
        }
    }

    @Override
    public void onItemClicked(Call item, int position) {
        Intent intent = AddCallActivity.makeIntent(CallbookActivity.this, item.name);
        startActivityForResult(intent, ADD_CALL);
    }

    public View.OnClickListener getAddListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = AddCallActivity.makeIntent(CallbookActivity.this);
                startActivityForResult(intent, ADD_CALL);
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
                Snackbar.make(view, "Delete Selected Call(s)", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            }
        };
    }

    private void setDeleteButton() {
        fab.setImageResource(R.drawable.ic_delete);
        fab.setOnClickListener(getDeleteListener());
    }
}
