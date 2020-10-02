package com.example.secpass.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.secpass.R;
import com.example.secpass.helper.MyDatabaseHelper;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.Objects;

public class AddPhoneNumberActivity extends AppCompatActivity implements View.OnClickListener {

    AutoCompleteTextView txtCategory;
    AutoCompleteTextView txtCountry;
    ImageView imgphonenumber;
    Button btnSavephonenumber;
    TextInputEditText edt_texttitle, edt_mobileno, edt_Notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_phone_number);

        txtCategory = findViewById(R.id.txtCategory);
        edt_texttitle = findViewById(R.id.edt_texttitle);
        edt_mobileno = findViewById(R.id.edt_mobileno);
        edt_Notes = findViewById(R.id.edt_Notes);
        txtCountry = findViewById(R.id.txtCountry);
        imgphonenumber = findViewById(R.id.imgphonenumber);
        btnSavephonenumber = findViewById(R.id.btnSavephonenumber);

        //  btnClose.setOnClickListener(this);
        ArrayList<String> categories = new ArrayList<>();
        categories.add("abc");
        categories.add("xyz");
        categories.add("pqr");

        ArrayAdapter<String> categoriesAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                categories
        );

        txtCategory.setAdapter(categoriesAdapter);

        ArrayList<String> countries = new ArrayList<>();
        countries.add("India");
        countries.add("Canada");
        countries.add("US");

        ArrayAdapter<String> countriesAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                countries
        );

        txtCountry.setAdapter(countriesAdapter);
        imgphonenumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AddPhoneNumberActivity.this, DashBoardActivity.class);
                startActivity(i);
            }
        });
        btnSavephonenumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddPhoneNumberActivity.this);
                myDB.addName("", "", "0", "",
                        Objects.requireNonNull(edt_texttitle.getText()).toString(),
                        Objects.requireNonNull(edt_mobileno.getText()).toString(),
                        txtCategory.getText().toString(), txtCountry.getText().toString(),
                        Objects.requireNonNull(edt_Notes.getText()).toString());

            }
        });

    }

    @Override
    public void onClick(View v) {
        onBackPressed();
    }
}
