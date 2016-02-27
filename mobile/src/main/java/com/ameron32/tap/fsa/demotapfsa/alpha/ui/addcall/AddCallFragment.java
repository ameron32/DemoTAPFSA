package com.ameron32.tap.fsa.demotapfsa.alpha.ui.addcall;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.ameron32.tap.fsa.demotapfsa.R;
import com.ameron32.tap.fsa.demotapfsa.alpha.model.Territory;
import com.ameron32.tap.fsa.demotapfsa.alpha.model.Visit;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class AddCallFragment extends Fragment {

    RecyclerView recyclerView;
    DummyVisitAdapter adapter;

    public AddCallFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_call_alpha, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        populateFromIntent(view);
    }

    private void populateFromIntent(View view) {
        if (isNew()) {
            return;
        }
        String name = getIntentBundle().getString("name");
        TextView nameView = (TextView) view.findViewById(R.id.name);
        nameView.setText(name);

        String address = getIntentBundle().getString("address");
        TextView addressView = (TextView) view.findViewById(R.id.address);
        addressView.setText(address);

        String age = getIntentBundle().getString("age");
        TextView ageView = (TextView) view.findViewById(R.id.age);
        ageView.setText(age);
    }

    public void enableAdapter() {
        adapter = new DummyVisitAdapter(getVisitList());
        recyclerView.setAdapter(adapter);
    }

    private List<Visit> getVisitList() {
        List<Visit> visits = new ArrayList<>();
        visits.add(new Visit("Initial Call", "Went over opening questions. Agreed to try a sample study next visit.\n\nWants to look at chapter 11 first."));
        visits.add(new Visit("Return Visit", "002"));
        return visits;
    }

    public DummyVisitAdapter getAdapter() {
        return adapter;
    }

    public boolean isNew() {
        Bundle bundle = getActivity().getIntent().getExtras();
        if (bundle == null) {
            return true;
        }
        return false;
    }

    public Bundle getIntentBundle() {
        if (isNew()) {
            return null;
        }
        return getActivity().getIntent().getExtras();
    }

    public List<EditText> getEditViews() {
        List<EditText> views = new ArrayList<>();
        int[] ids = new int[]{R.id.address, R.id.name, R.id.age};
        for (int id : ids) {
            views.add((EditText) getView().findViewById(id));
        }
        return views;
    }

    private void lockEditViews() {
        for (EditText e : getEditViews()) {
            e.clearFocus();
            e.setEnabled(false);
        }
    }

    private void unlockEditViews() {
        for (EditText e : getEditViews()) {
            e.setEnabled(true);
        }
    }

    public void disableEditing() {
        lockEditViews();
    }

    public void enableEditing() {
        unlockEditViews();
    }
}
