package com.ameron32.tap.fsa.demotapfsa.beta.ui.addstreet;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;

import com.ameron32.tap.fsa.demotapfsa.R;
import com.ameron32.tap.fsa.demotapfsa.alpha.ui.addcall.DummyVisitAdapter;
import com.ameron32.tap.fsa.demotapfsa.alpha.ui.addstreet.DummyNumberRangeAdapter;
import com.ameron32.tap.fsa.demotapfsa.alpha.ui.notathomes.DummyStreetAdapter;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A placeholder fragment containing a simple view.
 */
public class AddStreetFragment extends Fragment {

  public AddStreetFragment() {
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_add_street_beta, container, false);
  }

  @Bind({ R.id.numberPicker1, R.id.numberPicker10, R.id.numberPicker100, R.id.numberPicker1000 })
  List<NumberPicker> pickers;
  @Bind(R.id.recyclerView)
  RecyclerView recyclerView;

  DummyNumberRangeAdapter adapter;

  @Override
  public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    ButterKnife.bind(this, view);
    configurePickers();
    setupRecycler();
  }

  private void configurePickers() {
    for (NumberPicker picker : pickers) {
      picker.setMinValue(0);
      picker.setMaxValue(9);
      picker.setWrapSelectorWheel(true);
    }
  }

  private void setupRecycler() {
    recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false));
    recyclerView.setAdapter(adapter = new DummyNumberRangeAdapter());
  }

  @OnClick(R.id.buttonAdd) void addNotAtHome() {
    int number = 0;
    for (int i = 0, size = pickers.size(); i < size; i++) {
      number += pickers.get(i).getValue() * ((int) Math.pow(10,i));
    }
    adapter.add(number);
  }
}
