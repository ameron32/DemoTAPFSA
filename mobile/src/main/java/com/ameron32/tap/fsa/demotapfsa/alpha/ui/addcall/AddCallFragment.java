package com.ameron32.tap.fsa.demotapfsa.alpha.ui.addcall;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
}
