package fangfang.android.buclaimssystem;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ClaimDetails extends AppCompatActivity {
    private TextView tv_claimid, tv_name,tv_email,tv_phone,tv_address,tv_accDate, tv_accTime,tv_carVIN, tv_desc,tv_pay_message;
    private Button btn_ok,btn_send_email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_claim_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Your repairs are completed and vehicle is ready!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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
        final String name = tv_name.getText().toString();
        final String email = tv_email.getText().toString();
        final String phone =tv_phone.getText().toString();
        final String address =tv_address.getText().toString();
        final String date = tv_accDate.getText().toString();
        final String time = tv_accTime.getText().toString();
        final String carVin =tv_carVIN.getText().toString();
        final String desc =tv_desc.getText().toString();
        final String payment_info = tv_pay_message.getText().toString();

        tv_claimid.setText(claimid);

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Homepage.class);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        btn_send_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = String.format(
                        "\n" + claimid +
                                "\n"+ name +
                                "\n\n"+email +
                                "\n"+phone +
                                "\n"+address +
                                "\n"+time +
                                "\n"+carVin +
                                "\n"+desc +
                                "\n" + payment_info
                );
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                intent.putExtra(Intent.EXTRA_EMAIL, email);
                intent.putExtra(Intent.EXTRA_SUBJECT, "Your Auto " + claimid + " Confirmation");
                intent.putExtra(Intent.EXTRA_TEXT, message);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }

            }
        });
    }

}
