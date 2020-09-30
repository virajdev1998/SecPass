package com.example.secpass.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.secpass.R;
import com.example.secpass.helper.MyDatabaseHelper;

public class Ecommerce_sites extends AppCompatActivity {
EditText etTitlees,etEmailes,etPasswordes,etNotees;
Spinner spnCategoryes;
Button btnSavees;
ImageView imgClosees;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecommerce_sites);
        etTitlees = findViewById(R.id.etTitlees);
        etEmailes = findViewById(R.id.etEmailes);
        etPasswordes = findViewById(R.id.etPasswordes);
        etNotees = findViewById(R.id.etNotees);
        btnSavees = findViewById(R.id.btnSavees);
        spnCategoryes = findViewById(R.id.spnCategoryes);
        imgClosees = findViewById(R.id.imgClosees);
        imgClosees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Ecommerce_sites.this,DashBoardActivity.class);
                startActivity(i);
            }
        });
        btnSavees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(Ecommerce_sites.this);
                myDB.addecommercesites(etTitlees.getText().toString().trim(),
                        etEmailes.getText().toString().trim(),

                        etPasswordes.getText().toString().trim(),
                        "",
                        etNotees.getText().toString().trim()
                );

            }
        });
    }
}