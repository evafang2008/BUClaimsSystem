package fangfang.android.buclaimssystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
/**
 * Created by Fang on 2/1/2016
 * To help customers to report new claim
 */
public class ReportClaim extends AppCompatActivity {
    private TextView tv_claimid;
    private EditText et_name,et_email,et_phone,et_address,et_accDate, et_accTime,et_carVIN, et_desc;
    private Button btn_submit, btn_cancel;
    private static int claimid = 999000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_claim);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tv_claimid = (TextView) findViewById(R.id.claimpage_claimID);
        et_name = (EditText) findViewById(R.id.claimpage_name);
        et_email = (EditText) findViewById(R.id.claimpage_email);
        et_phone = (EditText) findViewById(R.id.claimpage_phone);
        et_address = (EditText) findViewById(R.id.claimpage_address);
        et_accDate = (EditText) findViewById(R.id.claimpage_date);
        et_accTime = (EditText) findViewById(R.id.claimpage_time);
        et_carVIN = (EditText) findViewById(R.id.claimpage_carVIN);
        et_desc = (EditText) findViewById(R.id.claimpage_claimDesc);
        btn_submit = (Button) findViewById(R.id.claimpage_submit);
        btn_cancel = (Button) findViewById(R.id.claimpage_cancel);

    }

    public void run2(View v){
        switch (v.getId()) {
            case R.id.claimpage_submit:
                claimid += 1;
                String claimid_string ="Claim#: BUC-A-" + claimid;
                String name = et_name.getText().toString();
                String email = et_email.getText().toString();
                String phone = et_phone.getText().toString();
                String address = et_address.getText().toString();
                String date = et_accDate.getText().toString();
                String time = et_accTime.getText().toString();
                String carVin = et_carVIN.getText().toString();
                String desc = et_desc.getText().toString();

                // Assume carVin and description are required information, check they are not null

                if((!name.equals("")) || (!carVin.equals("")) || (!desc.equals(""))) {

                    Intent intent = new Intent(getApplicationContext(), ConfirmationPage.class);
                    intent.putExtra("ClaimID", claimid_string);
                    intent.putExtra("Name", name);
                    intent.putExtra("Email", email);
                    intent.putExtra("Phone", phone);
                    intent.putExtra("Address", address);
                    intent.putExtra("Date", date);
                    intent.putExtra("Time", time);
                    intent.putExtra("CarVin", carVin);
                    intent.putExtra("Desc", desc);
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }
                    finish();
                    Toast.makeText(getApplicationContext(), claimid_string + " has been successfully created.", Toast.LENGTH_LONG).show();
                    break;
                }else{
                    if(name.equals("")){
                        et_name.setError("please input valid data for Name, which is required information.");
                        break;

                    }else if(carVin.equals("")){
                        et_carVIN.setError("please input valid data for Car VIN, which is required information.");
                        break;

                    }else{
                        et_desc.setError("please input valid data for Description, which is required information.");
                        break;

                    }
                }
            case R.id.claimpage_cancel:
                Intent intent2 = new Intent(getApplicationContext(), Homepage.class);
                if (intent2.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent2);
                }
                finish();
                break;
        }

    }


}
