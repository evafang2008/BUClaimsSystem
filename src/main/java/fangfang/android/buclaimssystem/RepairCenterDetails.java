package fangfang.android.buclaimssystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
/**
 * Created by Fang on 2/1/2016
 * To help customers get the details of the repair center they selected including address, phone, and open hours.
 */
public class RepairCenterDetails extends AppCompatActivity {
    private TextView tv_repair_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repair_center_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tv_repair_title = (TextView) findViewById(R.id.repair_details_title);
        Intent intent = getIntent();
        String title = intent.getStringExtra("RepairTitle");
        tv_repair_title.setText(title);
    }

}
