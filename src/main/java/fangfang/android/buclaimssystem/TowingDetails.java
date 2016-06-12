package fangfang.android.buclaimssystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
/**
 * Created by Fang on 2/1/2016
 * To help customers get a details of the selected towing service center.
 */
public class TowingDetails extends AppCompatActivity {
    private TextView tv_towing_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_towing_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tv_towing_title = (TextView) findViewById(R.id.towing_details_title);
        Intent intent = getIntent();
        String title = intent.getStringExtra("TowingTitle");
        tv_towing_title.setText(title);
    }

}
