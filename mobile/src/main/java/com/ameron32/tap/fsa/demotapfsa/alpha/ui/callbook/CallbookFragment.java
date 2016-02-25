package com.ameron32.tap.fsa.demotapfsa.alpha.ui.callbook;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ameron32.tap.fsa.demotapfsa.R;
import com.ameron32.tap.fsa.demotapfsa.alpha.model.Call;
import com.ameron32.tap.fsa.demotapfsa.alpha.model.Territory;
import com.ameron32.tap.fsa.demotapfsa.alpha.ui.selectterritory.DummyTerritoryAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class CallbookFragment extends Fragment {

    DummyCallAdapter adapter = new DummyCallAdapter(getCallList());

    public CallbookFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_callbook_alpha, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);
    }

    private List<Call> getCallList() {
        List<Call> calls = new ArrayList<>();
        calls.add(new Call("David Jones", "1021 Meadowview", "mid-30s", "man"));
        calls.add(new Call("Natalie Lane", "111 Rainbow Way", "12", "girl"));
        return calls;
    }

    public DummyCallAdapter getAdapter() {
        return adapter;
    }
}
