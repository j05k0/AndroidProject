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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.async.callback.BackendlessCallback;
import com.backendless.exceptions.BackendlessException;
import com.backendless.exceptions.BackendlessFault;
import com.example.jozef.predajelektroniky.data.Products;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class wifi extends AppCompatActivity {

    ArrayList<Products> products = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Product list");

        getAllItems();
    }

    public void getAllItems(){
        RequestQueue queue = Volley.newRequestQueue(this);
        final String url = "http://api.backendless.com/v1/data/Products";

        // HashMap<String, String> params = new HashMap<String, String>();
        // params.put("token", "AbCdEfGh123456");

        JsonObjectRequest request = new JsonObjectRequest(url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        parseJson(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.e("Error: ", error.getMessage());
            }
        })
        {
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<>();
                headers.put("application-id", "235A3A14-40D9-B1C4-FF05-B16778D82900");
                headers.put("secret-key", "18EDC1BE-8A8E-F91E-FFA5-B7027802A300"); //zmenit
                headers.put("Content-Type","application/json");
                headers.put("application-type","REST");
                return headers;
            }
        };

        queue.add(request);
    }

    public void parseJson(JSONObject json){
        try {
            //Get the instance of JSONArray that contains JSONObjects
            JSONArray jsonArray = json.optJSONArray("data");

            //Iterate the jsonArray and print the info of JSONObjects
            for(int i=0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Products product = new Products();

                product.setBrand(jsonObject.optString("Brand").toString());
                product.setModel(jsonObject.optString("Model").toString());
                product.setCategory(jsonObject.optString("Category").toString());
                products.add(product);

            }
        } catch (JSONException e){
            e.printStackTrace();
        }

        ArrayAdapter<Products> allAdapter = new CustomLayout(this, products);
        ListView menuListView = (ListView) findViewById(R.id.listView);
        menuListView.setAdapter(allAdapter);

    }

}
