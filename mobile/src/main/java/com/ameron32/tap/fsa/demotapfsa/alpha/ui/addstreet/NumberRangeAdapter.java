package com.ameron32.tap.fsa.demotapfsa.alpha.ui.addstreet;

import android.support.v4.app.TaskStackBuilder;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import com.ameron32.tap.fsa.demotapfsa.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by klemeilleur on 2/24/16.
 */
public class NumberRangeAdapter extends RecyclerView.Adapter<NumberRangeAdapter.ViewHolder> {

    List<String> numbers;
    SparseArray<Boolean> checked;

    public NumberRangeAdapter(int start, int end, int interval) {
        numbers = new ArrayList<>();
        checked = new SparseArray<>();
        for (int i = start; i <= end; i += interval) {
            numbers.add(String.valueOf(i));
            checked.put(i, false);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_address_range_alpha, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String number = numbers.get(position);
        holder.toggleButton.setOnCheckedChangeListener(null);
        holder.toggleButton.setChecked(checked.get(Integer.decode(number)));
        holder.toggleButton.setOnCheckedChangeListener(new OnToggleChangedListener(Integer.decode(number), checked));
        holder.toggleButton.setText(number);
        holder.toggleButton.setTextOn(number);
        holder.toggleButton.setTextOff(number);
    }

    @Override
    public int getItemCount() {
        return numbers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ToggleButton toggleButton;

        public ViewHolder(View itemView) {
            super(itemView);
            toggleButton = (ToggleButton) itemView.findViewById(R.id.toggleButton);
        }
    }
}
