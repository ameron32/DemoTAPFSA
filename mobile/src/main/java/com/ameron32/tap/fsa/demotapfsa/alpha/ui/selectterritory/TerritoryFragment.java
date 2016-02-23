package com.ameron32.tap.fsa.demotapfsa.alpha.ui.selectterritory;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ameron32.tap.fsa.demotapfsa.R;
import com.ameron32.tap.fsa.demotapfsa.alpha.model.Territory;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class TerritoryFragment extends Fragment {

    DummyTerritoryAdapter adapter = new DummyTerritoryAdapter(getStreetList());

    public TerritoryFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_territory_alpha, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);
    }

    private List<Territory> getStreetList() {
        List<Territory> territories = new ArrayList<>();
        territories.add(new Territory("Ross St", "001"));
        territories.add(new Territory("Riverhills", "002"));
        return territories;
    }

    public DummyTerritoryAdapter getAdapter() {
        return adapter;
    }
}
