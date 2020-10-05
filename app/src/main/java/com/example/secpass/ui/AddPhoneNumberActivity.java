package com.example.secpass.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.secpass.R;
import com.example.secpass.helper.MyDatabaseHelper;

import java.util.Objects;

public class AddPhoneNumberActivity extends AppCompatActivity implements View.OnClickListener {

    AutoCompleteTextView txtCategory;
    ImageView imgphonenumber;
    Button btnSavephonenumber;
    EditText edt_mobileno, edt_Notes, txtCountry;
    TextView edt_texttitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_phone_number);

        edt_texttitle = findViewById(R.id.etTitlepn);
        edt_mobileno = findViewById(R.id.etmobilenumberpn);
        edt_Notes = findViewById(R.id.etnotepn);
        txtCountry = findViewById(R.id.etcountrypn);
        imgphonenumber = findViewById(R.id.imgClosepn);
        btnSavephonenumber = findViewById(R.id.btnSavepn);

        //  btnClose.setOnClickListener(this);
//        ArrayList<String> categories = new ArrayList<>();
//        categories.add("abc");
//        categories.add("xyz");
//        categories.add("pqr");
//
//        ArrayAdapter<String> categoriesAdapter = new ArrayAdapter<>(
//                this,
//                android.R.layout.simple_list_item_1,
//                categories
//        );

//        txtCategory.setAdapter(categoriesAdapter);
//
//        ArrayList<String> countries = new ArrayList<>();
//        countries.add("India");
//        countries.add("Canada");
//        countries.add("US");
//
//        ArrayAdapter<String> countriesAdapter = new ArrayAdapter<>(
//                this,
//                android.R.layout.simple_list_item_1,
//                countries
//        );
//
//        txtCountry.setAdapter(countriesAdapter);
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
