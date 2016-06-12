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
 * To help customers get the repair centers list around their location
 */
public class RepairCenter extends AppCompatActivity {
    private ListView listview_repair;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repair_center);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listview_repair = (ListView) findViewById(R.id.listview_repairlist);
        String[] repairs = {
                "Auto 1 Repair Inc",
                "Arrow Repair",
                "24 Hour Repair",
                "3 Rivers Repair",
                "A.S.C. Repair and Recovery",
                "3B's Repair Inc.",
                "Alberts Repair",
                "Paul's Millard Sinclair Services",
                "Evolution Repair LLC"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, repairs);
        listview_repair.setAdapter(adapter);

        listview_repair.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), RepairCenterDetails.class);

                intent.putExtra("RepairTitle",listview_repair.getItemAtPosition(position).toString());
                startActivity(intent);
            }
        });
    }

}
