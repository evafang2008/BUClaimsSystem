package fangfang.android.buclaimssystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
/**
 * Created by Fang on 2/1/2016
 * To help customers sign up into this application
 */
public class Signup extends AppCompatActivity {
    EditText firstname_v, lastname_v,email_v,password_v;
    Button register_v;
    /**
     * I am trying to use SharedPreferences to store the data,
     * but actually the data is stored in local phone, not cloud. It is not good for performance.
     * So just keep it here, I will do some improvements for storing data in the cloud later.

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String FirstName = "firstnameKey";
    public static final String LastName = "lastnameKey";
    public static final String Email = "emailKey";
    public static final String Password = "passwordKey";

    SharedPreferences sharedpreferences;

     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        firstname_v = (EditText) findViewById(R.id.etFirstname);
        lastname_v = (EditText) findViewById(R.id.etLastname);
        email_v = (EditText) findViewById(R.id.etEmail);
        password_v = (EditText) findViewById(R.id.etPassword);
        register_v = (Button) findViewById(R.id.bRegister);

        /**
         * I am trying to use SharedPreferences to store the data,
         * but actually the data is stored in local phone, not cloud. It is not good for performance.
         * So just keep it here, I will do some improvements for storing data in the cloud later.
         * sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
         *
         */

        register_v.setOnClickListener(new View.OnClickListener() {

            Boolean legalcheck;
            @Override
            public void onClick(View v) {

                String firstn = firstname_v.getText().toString();
                String lastn = lastname_v.getText().toString();
                String email = email_v.getText().toString();
                String pwd = password_v.getText().toString();


                /**
                 SharedPreferences.Editor editor = sharedpreferences.edit();

                 editor.putString(FirstName,firstn);
                 editor.putString(LastName, lastn);
                 editor.putString(Email, email);
                 editor.putString(Password, pwd);
                 editor.commit();
                 */
                if(!email.isEmpty()){
                    String message = "Account " + firstn + " " + lastn + " has been successfully created!";
                    Toast.makeText(Signup.this, message, Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), Homepage.class);
                    intent.putExtra("FirstName", firstn);
                    intent.putExtra("LastName", lastn);
                    intent.putExtra("Email", email);
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }
                } else
                    email_v.setError("Email is empty. Please input valid email for new account creation.");
            }
        });
    }


}
