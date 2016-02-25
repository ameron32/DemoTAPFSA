package com.ameron32.tap.fsa.demotapfsa.alpha.ui.addstreet;

import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.ameron32.tap.fsa.demotapfsa.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class AddStreetFragment extends Fragment {

    int interval = 1;
    RecyclerView recyclerView;
    EditText rangeStart;
    EditText rangeEnd;

    public AddStreetFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_street_alpha, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rangeStart = (EditText) view.findViewById(R.id.rangeStart);
        rangeEnd = (EditText) view.findViewById(R.id.rangeEnd);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 6, GridLayoutManager.HORIZONTAL, false));
    }

    private void refreshGrid() {
        if (isRangeValid()) {
            recyclerView.setAdapter(getAdapter());
        } else {
            Snackbar.make(getView(), "Can't use this address range.", Snackbar.LENGTH_LONG).show();
        }
    }

    private boolean isRangeValid() {
        try {
            int first = getFirstNumber();
            int last = getLastNumber();
            return first <= last;
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return false;
    }

    private RecyclerView.Adapter getAdapter() {
        return new NumberRangeAdapter(getFirstNumber(), getLastNumber(), interval);
    }

    private int getFirstNumber() throws NumberFormatException {
        return Integer.decode(rangeStart.getText().toString());
    }

    private int getLastNumber() throws NumberFormatException {
        return Integer.decode(rangeEnd.getText().toString());
    }

    public void onRadioButtonClicked(View v) {
        switch (v.getId()) {
            case R.id.radio1:
                interval = 1;
                break;
            case R.id.radio10:
                interval = 10;
                break;
            case R.id.radio100:
                interval = 100;
                break;
            case R.id.radio1000:
                interval = 1000;
                break;
            default:
                interval = 1;
        }
        refreshGrid();
    }
}
