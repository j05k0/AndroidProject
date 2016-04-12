package com.example.jozef.predajelektroniky;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import com.backendless.Backendless;

public class MainActivity extends AppCompatActivity {

    String APP_ID = "235A3A14-40D9-B1C4-FF05-B16778D82900";
    String SECRET_KEY = "18EDC1BE-8A8E-F91E-FFA5-B7027802A300";
    String appVersion = "v1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        /*
        final String temp;
        final EditText login = (EditText) findViewById(R.id.editText);
        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (login.getText().toString() == "Login")
                    login.setText("");
            }
        });*/

        Backendless.initApp(this, APP_ID, SECRET_KEY, appVersion );

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

    public void showWifi(View view) {
        Intent intent = new Intent(getApplicationContext(), wifi.class);
        startActivity(intent);
    }

    public void showGetAll(View view){
        Intent intent = new Intent(getApplicationContext(), GetAll.class);
        startActivity(intent);
    }

}
