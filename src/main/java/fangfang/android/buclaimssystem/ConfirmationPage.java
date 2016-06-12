package fangfang.android.buclaimssystem;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
/**
 * Created by Fang on 2/1/2016
 * To help customers confirm the claim information. User can send it by email for tracking the information.
 */
public class ConfirmationPage extends AppCompatActivity {
    private TextView tv_claimid, tv_name,tv_email,tv_phone,tv_address,tv_accDate, tv_accTime,tv_carVIN, tv_desc,tv_pay_message;
    private Button btn_ok,btn_send_email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tv_claimid = (TextView) findViewById(R.id.confirm_claimID);
        tv_name = (TextView) findViewById(R.id.confirm_name);
        tv_email = (TextView) findViewById(R.id.confirm_email);
        tv_phone = (TextView) findViewById(R.id.confirm_phone);
        tv_address = (TextView) findViewById(R.id.confirm_address);
        tv_accDate = (TextView) findViewById(R.id.confirm_date);
        tv_accTime = (TextView) findViewById(R.id.confirm_time);
        tv_carVIN = (TextView) findViewById(R.id.confirm_carVIN);
        tv_desc = (TextView) findViewById(R.id.confirm_claimDesc);
        tv_pay_message = (TextView) findViewById(R.id.confirm_payment_message);
        btn_ok= (Button) findViewById(R.id.confirm_ok);
        btn_send_email = (Button) findViewById(R.id.confirm_send_email);

        Intent intent = getIntent();
        final String claimid = intent.getStringExtra("ClaimID");
        final String name = intent.getStringExtra("Name");
        final String email = intent.getStringExtra("Email");
        final String phone = intent.getStringExtra("Phone");
        final String address = intent.getStringExtra("Address");
        final String date = intent.getStringExtra("Date");
        final String time = intent.getStringExtra("Time");
        final String carVin = intent.getStringExtra("CarVin");
        final String desc = intent.getStringExtra("Desc");
        final String payment_info = tv_pay_message.getText().toString();

        tv_claimid.setText(claimid);
        tv_name.setText("Name: " + name);
        tv_email.setText("Email: " + email);
        tv_phone.setText("Phone: " + phone);
        tv_address.setText("Address: " + address);
        tv_accDate.setText("Accident date: " + date);
        tv_accTime.setText("Accident time: " + time);
        tv_carVIN.setText("Car VIN#: "  + carVin);
        tv_desc.setText("Description: \n" + desc);

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Homepage.class);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        btn_send_email.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String message = String.format(
                        "\n" + claimid +
                                "\nName: " + name +
                                "\n\nEmail: " + email +
                                "\nPhone: " + phone +
                                "\nAddress: " + address +
                                "\nAccident Date: " + date +
                                "\nAccident Time: " + time +
                                "\nCar VIN#: " + carVin +
                                "\nClaim Descripton: " + desc +
                                "\n" + payment_info
                        );
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                intent.putExtra(Intent.EXTRA_EMAIL, email);
                intent.putExtra(Intent.EXTRA_SUBJECT, "Your Auto "+ claimid +" Confirmation");
                intent.putExtra(Intent.EXTRA_TEXT, message);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }

            }
        });

    }


}
