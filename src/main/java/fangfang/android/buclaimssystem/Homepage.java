package fangfang.android.buclaimssystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Fang on 2/1/2016
 * To help customers direct the menu item which they want to. The previous claims list listed here.
 */
public class Homepage extends AppCompatActivity {
    private TextView textView, tv_Logout;
    private Button b_reportClaim, b_towing, b_repair, b_payment;
    private ListView claimsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        String firstname = intent.getStringExtra("FirstName");
        String lastname = intent.getStringExtra("LastName");

        textView = (TextView) findViewById(R.id.fullName);

        if(lastname == null || firstname == null){
            textView.setText("Welcome to Bellevue Claims System!");
        }else
            textView.setText("Welcome," + " " + firstname + " " + lastname +"!");
        tv_Logout = (TextView) findViewById(R.id.logout);
        b_reportClaim = (Button) findViewById(R.id.btn_report_claim);
        b_towing = (Button) findViewById(R.id.btn_towing);
        b_reportClaim = (Button) findViewById(R.id.btn_repair_center);
        b_payment = (Button) findViewById(R.id.btn_make_payment);
        claimsList = (ListView) findViewById(R.id.home_claimslist);

        String[] claims = {

                "Claim# BUC-A-789001",
                "Claim# BUC-A-789002",
                "Claim# BUC-A-789003",
                "Claim# BUC-A-789004",
                "Claim# BUC-A-789005",
                "Claim# BUC-B-789001",
                "Claim# BUC-B-789002",
                "Claim# BUC-B-789003",
                "Claim# BUC-B-789004",
                "Claim# BUC-B-789005"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,claims);

        claimsList.setAdapter(adapter);
        claimsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), ClaimDetails.class);

                intent.putExtra("ClaimID", claimsList.getItemAtPosition(position).toString());
                startActivity(intent);
                Toast.makeText(Homepage.this, "Your repairs are completed and vehicle is ready!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void run(View view){
        int id = view.getId();
        switch (id){
            case R.id.logout:
                Intent intent = new Intent(this, MainActivity.class);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
                break;
            case R.id.btn_report_claim:
                Intent intent1 = new Intent(this, ReportClaim.class);
                if (intent1.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent1);
                }
                break;
            case R.id.btn_towing:
                Intent intent2 = new Intent(this, TowingService.class);
                if (intent2.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent2);
                }
                break;
            case R.id.btn_repair_center:
                Intent intent3 = new Intent(this, RepairCenter.class);
                if (intent3.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent3);
                }
                break;
            case R.id.btn_make_payment:
                Intent intent4 = new Intent(this, BillPayment.class);
                if (intent4.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent4);
                }
                break;
        }
    }

}
