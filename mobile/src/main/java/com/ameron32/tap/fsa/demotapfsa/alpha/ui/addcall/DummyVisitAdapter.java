package com.ameron32.tap.fsa.demotapfsa.alpha.ui.addcall;

import android.app.AlertDialog;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.ameron32.tap.fsa.demotapfsa.R;
import com.ameron32.tap.fsa.demotapfsa.alpha.model.Territory;
import com.ameron32.tap.fsa.demotapfsa.alpha.model.Visit;
import com.ameron32.tap.fsa.demotapfsa.alpha.ui.common.OnAnyItemsCheckedListener;

import java.util.List;

/**
 * Created by klemeilleur on 2/25/16.
 */
public class DummyVisitAdapter extends RecyclerView.Adapter<DummyVisitAdapter.ViewHolder> {

    private final List<Visit> visits;

    private OnAnyItemsCheckedListener listener;
    private boolean anyItemsCheckedState = false;

    public DummyVisitAdapter(List<Visit> visits) {
        this.visits = visits;
    }

    public void setOnAnyItemsCheckedListener(OnAnyItemsCheckedListener listener) {
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_word_list_alpha, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Visit visit = visits.get(position);
        holder.textView.setText(visit.type);
        holder.checkBox.setSelected(visit.selected);
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Visit visit = visits.get(position);
                visit.selected = isChecked;
                notifyAnyItemsCheckedChange();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(v.getContext())
                        .setTitle(visit.type + ": Notes")
                        .setMessage(visit.text)
                        .create().show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return visits.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public CheckBox checkBox;
        public TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            checkBox = (CheckBox) itemView.findViewById(R.id.checkBox);
            textView = (TextView) itemView.findViewById(android.R.id.text1);
        }
    }

    private void notifyAnyItemsCheckedChange() {
        boolean anyItemsChecked = isAnyItemsChecked();
        if (anyItemsChecked != anyItemsCheckedState) {
            anyItemsCheckedState = anyItemsChecked;
            if (listener != null) {
                listener.onAnyItemsCheckedChange(anyItemsCheckedState);
            }
        }
    }

    private boolean isAnyItemsChecked() {
        if (visits == null || visits.size() == 0) { return false; }

        for (Visit visit : visits) {
            if (visit.selected) {
                return true;
            }
        }
        return false;
    }
}
