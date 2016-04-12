package com.example.jozef.predajelektroniky;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.jozef.predajelektroniky.data.Products;

import java.util.ArrayList;

/**
 * Created by Jozef on 13.04.2016.
 */
public class CustomLayout extends ArrayAdapter<Products> {

    ArrayList<Products> products;

    public CustomLayout(Context context, ArrayList<Products> products) {
        super(context, R.layout.all_devices, products);
        this.products = products;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater listInflater = LayoutInflater.from(getContext());
        View customView = listInflater.inflate(R.layout.all_devices, parent, false);

        Products prod = products.get(position);
        TextView name = (TextView) customView.findViewById(R.id.name);
        TextView type = (TextView) customView.findViewById(R.id.type);

        name.setText(prod.getBrand() + " " + prod.getModel());
        type.setText(prod.getCategory());

        return customView;
    }
}
