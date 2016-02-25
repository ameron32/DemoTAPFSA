package com.ameron32.tap.fsa.demotapfsa.alpha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.ameron32.tap.fsa.demotapfsa.R;
import com.ameron32.tap.fsa.demotapfsa.alpha.ui.callbook.CallbookActivity;
import com.ameron32.tap.fsa.demotapfsa.alpha.ui.notathomes.NotAtHomesActivity;
import com.ameron32.tap.fsa.demotapfsa.alpha.ui.reports.ReportsActivity;
import com.ameron32.tap.fsa.demotapfsa.alpha.ui.territory.TerritoryActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    public static final String TAG = MainActivity.class.getSimpleName();
    public static final String PACKAGE = "alpha";

    String[] labels = new String[] { "Territory", "Callbook", "Not at Homes", "Field Service Reports" };
    Class[] activities = new Class[] { TerritoryActivity.class, CallbookActivity.class,
            NotAtHomesActivity.class, ReportsActivity.class };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_alpha);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, labels));
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Class className = activities[position];
        Intent intent = new Intent(this, className);
        startActivity(intent);
    }
}
