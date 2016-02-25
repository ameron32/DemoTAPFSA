package com.ameron32.tap.fsa.demotapfsa.alpha.ui.callbook;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.ameron32.tap.fsa.demotapfsa.R;
import com.ameron32.tap.fsa.demotapfsa.alpha.model.Call;
import com.ameron32.tap.fsa.demotapfsa.alpha.ui.common.OnAnyItemsCheckedListener;

import java.util.List;

/**
 * Created by klemeilleur on 2/22/16.
 */
public class DummyCallAdapter extends RecyclerView.Adapter<DummyCallAdapter.ViewHolder> {

    private final List<Call> calls;

    private OnAnyItemsCheckedListener listener;
    private boolean anyItemsCheckedState = false;

    public DummyCallAdapter(List<Call> calls) {
        this.calls = calls;
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
        Call call = calls.get(position);
        holder.textView.setText(call.name + "\n (" + call.age + " " + call.gender + ")");
        holder.checkBox.setSelected(call.selected);
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Call call = calls.get(position);
                call.selected = isChecked;
                notifyAnyItemsCheckedChange();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Open item "+ (position+1), Snackbar.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return calls.size();
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
        if (calls == null || calls.size() == 0) { return false; }

        for (Call call : calls) {
            if (call.selected) {
                return true;
            }
        }
        return false;
    }
}
