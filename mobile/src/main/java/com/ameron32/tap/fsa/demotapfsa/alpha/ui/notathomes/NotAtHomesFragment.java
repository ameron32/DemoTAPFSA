package com.ameron32.tap.fsa.demotapfsa.alpha.ui.notathomes;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ameron32.tap.fsa.demotapfsa.R;
import com.ameron32.tap.fsa.demotapfsa.alpha.model.Street;
import com.ameron32.tap.fsa.demotapfsa.alpha.model.Territory;
import com.ameron32.tap.fsa.demotapfsa.alpha.ui.selectterritory.DummyTerritoryAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class NotAtHomesFragment extends Fragment {

    DummyStreetAdapter adapter = new DummyStreetAdapter(getStreetList());

    public NotAtHomesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_not_at_homes_alpha, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);
    }

    private List<Street> getStreetList() {
        List<Street> territories = new ArrayList<>();
        territories.add(new Street("Cherry St"));
        territories.add(new Street("Oakwood Blvd"));
        return territories;
    }

    public DummyStreetAdapter getAdapter() {
        return adapter;
    }
}
