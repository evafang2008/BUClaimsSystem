package fangfang.android.buclaimssystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
/**
 * Created by Fang on 2/1/2016
 * To help customers sign in or sign up into this mobile application
 */
public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private Button main_btn_signin;
    private Button main_btn_signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        imageView = (ImageView)findViewById(R.id.main_imageView);
        main_btn_signin = (Button) findViewById(R.id.main_btn_signin);
        main_btn_signup = (Button) findViewById(R.id.main_btn_signup);
        Picasso.with(MainActivity.this)
                .load("https://pixabay.com/static/uploads/photo/2014/09/07/22/34/car-race-438467_960_720.jpg")
                .into(imageView);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void signIn(View view){
        Intent intent = new Intent(this, Signin.class);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    public void signUp(View view){
        Intent intent = new Intent(this, Signup.class);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

}
