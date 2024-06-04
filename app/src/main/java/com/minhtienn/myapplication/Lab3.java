package com.minhtienn.myapplication;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;
import com.minhtienn.myapplication.adapters.ProductListViewAdapter;
import com.minhtienn.myapplication.models.Product;

import java.util.ArrayList;

public class Lab3 extends AppCompatActivity {
    ArrayList<Product> productList;
    ProductListViewAdapter productListViewAdapter;
    ListView listViewProduct;
    android.widget.LinearLayout linearLayout;
    EditText editProductName;
    EditText editProductPrice;
    Product selectedProduct;
    int selectedPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lab3);

        productList = new ArrayList<>();
        productList.add(new Product(1, "Iphone 6", 500));
        productList.add(new Product(2, "Iphone 7", 700));
        productList.add(new Product(3, "Sony Abc", 800));
        productList.add(new Product(4, "Samsung XYZ", 900));
        productList.add(new Product(5, "Ipad 5", 500));
        productList.add(new Product(6, "Macbook 6", 700));
        productList.add(new Product(7, "Lenovo 7", 800));
        productList.add(new Product(8, "Pixel 8", 900));

        productListViewAdapter = new ProductListViewAdapter(productList);

        linearLayout = findViewById(R.id.main);
        editProductName = (EditText) findViewById(R.id.editProductName);
        editProductPrice = (EditText) findViewById(R.id.editProductPrice);

        listViewProduct = findViewById(R.id.productList);
        listViewProduct.setAdapter(productListViewAdapter);

        listViewProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Product product = (Product) productListViewAdapter.getItem(position);
                System.out.println("product" + product.getName());
                editProductName.setText(product.getName().toString());
                editProductPrice.setText(String.valueOf(product.getPrice()));
                selectedProduct = product;
                selectedPosition = position;
                Toast.makeText(Lab3.this, "Selected", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(editProductName.getText().toString() + " " + editProductPrice.getText().toString());
                if(TextUtils.isEmpty(editProductName.getText().toString())) {
                    editProductName.setError("Require");
                    return;
                }
                if(TextUtils.isEmpty(editProductPrice.getText().toString())) {
                    editProductPrice.setError("Require");
                    return;
                }
                productList.add(new Product(8, editProductName.getText().toString(), Integer.parseInt(editProductPrice.getText().toString())));
                productListViewAdapter.notifyDataSetChanged();
                editProductName.setText("");
                editProductPrice.setText("");
                selectedPosition = -1;
                selectedProduct = null;

                Snackbar.make(linearLayout, "Product saved successfully!", Snackbar.LENGTH_LONG).show();
            }
        });

        findViewById(R.id.update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectedPosition == -1) return;
                productList.set(selectedPosition, new Product(8, editProductName.getText().toString(), Integer.parseInt(editProductPrice.getText().toString())));
                productListViewAdapter.notifyDataSetChanged();
                Snackbar.make(linearLayout, "Product updated successfully!", Snackbar.LENGTH_LONG).show();
                editProductName.setText("");
                editProductPrice.setText("");
                selectedPosition = -1;
                selectedProduct = null;
            }
        });

        findViewById(R.id.delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (productList.size() > 0 && selectedPosition != -1) {
                    productList.remove(selectedProduct);
                    productListViewAdapter.notifyDataSetChanged();
                    editProductName.setText("");
                    editProductPrice.setText("");
                    selectedPosition = -1;
                    selectedProduct = null;
                    Snackbar.make(linearLayout, "Product deleted successfully!", Snackbar.LENGTH_LONG).show();
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}