package com.minhtienn.myapplication.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.minhtienn.myapplication.R;
import com.minhtienn.myapplication.models.Product;

import java.util.ArrayList;

public class ProductListViewAdapter extends BaseAdapter {
    final ArrayList<Product> listProduct;

    public ProductListViewAdapter(ArrayList<Product> listProduct) {
        this.listProduct = listProduct;
    }

    @Override
    public int getCount() {
        return listProduct.size();
    }

    @Override
    public Object getItem(int position) {
        return listProduct.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listProduct.get(position).getProductID();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewProduct;
        if(convertView == null) {
            viewProduct = View.inflate(parent.getContext(), R.layout.product_view, null);
        } else viewProduct = convertView;

        Product product = (Product) getItem(position);
        ((TextView) viewProduct.findViewById(R.id.nameproduct)).setText(String.format("Name : %s", product.getName()));
        ((TextView) viewProduct.findViewById(R.id.priceproduct)).setText(String.format("Price %d", product.getPrice()));

        return viewProduct;
    }
}
