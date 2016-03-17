package com.example.jozef.predajelektroniky;

import android.app.usage.NetworkStatsManager;
import android.content.Context;
import android.inputmethodservice.KeyboardView;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.async.callback.BackendlessCallback;
import com.backendless.exceptions.BackendlessException;
import com.backendless.exceptions.BackendlessFault;
import com.example.jozef.predajelektroniky.data.Products;


public class wifi extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        setTitle("GET content test");



        final TextView text = (TextView)findViewById(R.id.textView);
        Button getContent = (Button)findViewById(R.id.getContent);
        getContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //FIND FIRST
                /*Backendless.Persistence.of(Products.class).findLast(new AsyncCallback<Products>() {
                    @Override
                    public void handleResponse(Products products) {
                        text.setText("");
                        text.append(products.getBrand() + " " + products.getModel() + "\n");
                    }

                    @Override
                    public void handleFault(BackendlessFault backendlessFault) {
                        Toast.makeText(getBaseContext(), "Can't connect to server", Toast.LENGTH_SHORT).show();
                    }
                });*/

                //FIND ALL

                Backendless.Persistence.of(Products.class).find(new AsyncCallback<BackendlessCollection<Products>>() {
                    @Override
                    public void handleResponse(BackendlessCollection<Products> productsBackendlessCollection) {
                        text.setText("");
                        for (Products product : productsBackendlessCollection.getCurrentPage()){
                            text.append(product.getBrand() + " " + product.getModel() + "\n");
                        }

                    }

                    @Override
                    public void handleFault(BackendlessFault backendlessFault) {
                        Toast.makeText(getBaseContext(), "Can't connect to server", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });
    }

}
