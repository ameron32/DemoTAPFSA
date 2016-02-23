package com.ameron32.tap.fsa.demotapfsa.alpha.territory;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.ameron32.tap.fsa.demotapfsa.R;
import com.ameron32.tap.fsa.demotapfsa.alpha.model.Territory;

import java.util.List;

/**
 * Created by klemeilleur on 2/22/16.
 */
public class DummyTerritoryAdapter extends RecyclerView.Adapter<DummyTerritoryAdapter.ViewHolder> {

    private final List<Territory> territories;

    private OnAnyItemsCheckedListener listener;
    private boolean anyItemsCheckedState = false;

    public DummyTerritoryAdapter(List<Territory> territories) {
        this.territories = territories;
    }

    public void setOnAnyItemsCheckedListener(OnAnyItemsCheckedListener listener) {
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_territory_list_alpha, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Territory territory = territories.get(position);
        holder.checkBox.setText(territory.name + " (" + territory.territory + ")");
        holder.checkBox.setSelected(territory.selected);
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Territory territory = territories.get(position);
                territory.selected = isChecked;
                notifyAnyItemsCheckedChange();
            }
        });
    }

    @Override
    public int getItemCount() {
        return territories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public CheckBox checkBox;

        public ViewHolder(View itemView) {
            super(itemView);
            checkBox = (CheckBox) itemView.findViewById(R.id.checkBox);
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
        if (territories == null || territories.size() == 0) { return false; }

        for (Territory territory : territories) {
            if (territory.selected) {
                return true;
            }
        }
        return false;
    }


    public interface OnAnyItemsCheckedListener {
        void onAnyItemsCheckedChange(boolean anyItemsChecked);
    }
}
