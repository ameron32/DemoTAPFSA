package com.ameron32.tap.fsa.demotapfsa.alpha.ui.addstreet;

import android.util.SparseArray;
import android.widget.CompoundButton;

import java.util.List;

/**
 * Created by klemeilleur on 2/24/16.
 */
public class OnToggleChangedListener implements CompoundButton.OnCheckedChangeListener {

    private final int number;
    private final SparseArray<Boolean> checked;

    public OnToggleChangedListener(int number, SparseArray<Boolean> checked) {
        this.number = number;
        this.checked = checked;
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        checked.put(number, isChecked);
    }
}
