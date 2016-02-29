package com.ameron32.tap.fsa.demotapfsa.alpha.ui.addvisit;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ameron32.tap.fsa.demotapfsa.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class AddVisitFragment extends Fragment {

  public AddVisitFragment() {
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_add_visit_alpha, container, false);
  }

  @Override
  public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    populateFromIntent(view);
  }

  private void populateFromIntent(View view) {
    if (isNew()) {
      return;
    }
    String name = getIntentBundle().getString("description");
    TextView nameView = (TextView) view.findViewById(R.id.description);
    nameView.setText(name);

    String address = getIntentBundle().getString("notes");
    TextView addressView = (TextView) view.findViewById(R.id.notes);
    addressView.setText(address);
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
}
