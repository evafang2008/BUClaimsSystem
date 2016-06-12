package fangfang.android.buclaimssystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
/**
 * Created by Fang on 2/1/2016
 * To help customers get a list of towing service centers around their location.
 */
public class TowingService extends AppCompatActivity {
    private ListView listview_towing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_towing_service);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listview_towing = (ListView) findViewById(R.id.listview_towing);
        String[] towings = {
                "Auto 1 Towing Inc",
                "Arrow Towing",
                "24 Hour Towing",
                "3 Rivers Towing",
                "A.S.C. Towing and Recovery",
                "3B's Towing Inc.",
                "Alberts Towing",
                "Paul's Millard Sinclair Services",
                "Evolution Towing LLC"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, towings);
        listview_towing.setAdapter(adapter);

        listview_towing.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), TowingDetails.class);

                intent.putExtra("TowingTitle",listview_towing.getItemAtPosition(position).toString());
                startActivity(intent);
            }
        });
    }

}
