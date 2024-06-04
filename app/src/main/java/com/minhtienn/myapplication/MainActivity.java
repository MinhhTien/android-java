package com.minhtienn.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnFood;
    Button btnDrink;
    Button btnExit;
    TextView tvFood;
    TextView tvDrink;
    TextView txtLichsu;
    String lichsu = "";

    private static final int REQUEST_CODE_FOOD = 1;
    private static final int REQUEST_CODE_DRINK = 2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnFood = findViewById(R.id.btnFood);
        btnDrink = findViewById(R.id.btnDrink);
        btnExit = findViewById(R.id.btnExit);
        tvFood = findViewById(R.id.tvFood);
        tvDrink = findViewById(R.id.tvDrink);
        txtLichsu = findViewById(R.id.txtLichsu);

        SharedPreferences appPref = getSharedPreferences("appPref", MODE_PRIVATE);
        lichsu = appPref.getString("lichsu", "");
        txtLichsu.setText(lichsu);

        btnFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentFood = new Intent(MainActivity.this, FoodActivity.class);
                startActivityForResult(intentFood, REQUEST_CODE_FOOD);
            }
        });

        btnDrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentDrink = new Intent(MainActivity.this, DrinkActivity.class);
                startActivityForResult(intentDrink, REQUEST_CODE_DRINK);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    protected void onActivityResult(int requestCd, int resultCd, @Nullable Intent data) {
        super.onActivityResult(requestCd, resultCd, data);
        if(resultCd == RESULT_OK && data != null) {
            String selectedItem = data.getStringExtra("selected_item");
            if(requestCd == REQUEST_CODE_FOOD) {
                tvFood.setText(selectedItem);
                lichsu = lichsu + "\nFood: " + selectedItem;
            } else if (requestCd ==  REQUEST_CODE_DRINK) {
                tvDrink.setText(selectedItem);
                lichsu = lichsu + "\nDrink: " + selectedItem;
            }
        }
        txtLichsu.setText(lichsu);
    }

    @Override
    protected  void onPause() {
        super.onPause();
        SharedPreferences appPref = getSharedPreferences("appPref", MODE_PRIVATE);
        SharedPreferences.Editor appEditor = appPref.edit();
        appEditor.putString("lichsu", lichsu);
        appEditor.commit();
    }
}