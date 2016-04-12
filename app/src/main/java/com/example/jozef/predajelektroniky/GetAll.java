package com.example.jozef.predajelektroniky;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.jozef.predajelektroniky.data.Products;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GetAll extends AppCompatActivity {

    TextView textView;
    final static private String TAG = "myString";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getall);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textView = (TextView) findViewById(R.id.textView2);

        setTitle("GET all items form server");
        GetAllItems();
    }

    public void GetAllItems(){
        RequestQueue queue = Volley.newRequestQueue(this);
        final String url = "http://api.backendless.com/v1/data/Products";

       // HashMap<String, String> params = new HashMap<String, String>();
       // params.put("token", "AbCdEfGh123456");

        JsonObjectRequest request = new JsonObjectRequest(url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        PrintToTextView(response);
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

    public void PrintToTextView(JSONObject response){



        try {
            //Get the instance of JSONArray that contains JSONObjects
            JSONArray jsonArray = response.optJSONArray("data");
            textView.setText("");
            List<Products> productsList = new ArrayList<>();
            Gson gson = new Gson();

            //Iterate the jsonArray and print the info of JSONObjects
            for(int i=0; i < jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Products products = new Products();

                //products = gson.fromJson(response.toString(), Products.class);
                //productsList.add(products);

                products.setBrand(jsonObject.optString("Brand").toString());
                products.setModel(jsonObject.optString("Model").toString());

                textView.append(products.getBrand() + " " + products.getModel() + "\n");
            }
        } catch (JSONException e){
            e.printStackTrace();
        }
    }
}
