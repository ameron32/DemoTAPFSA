package com.ameron32.tap.fsa.demotapfsa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainMenuActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    public static final String TAG = MainMenuActivity.class.getSimpleName();

    String[] activities = new String[] { "alpha" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, activities));
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String packageName = activities[position];
        String className = "";
        try {
            className = Util.makeClassName(packageName);
            Intent intent = new Intent(this, Class.forName(className));
            startActivity(intent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(this, packageName + " failed", Toast.LENGTH_SHORT).show();
            Log.d(TAG, packageName + "." + className + " failed");
        }
    }
}
