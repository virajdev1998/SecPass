package com.example.secpass.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
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

public class AddPhoneNumberActivity extends AppCompatActivity {

    AutoCompleteTextView txtCategory;
    ImageView imgphonenumber;
    Button btnSavephonenumber;
    EditText etmobilenumberpn, etnotepn, etcountrypn, txtCountry;
    TextView etTitlepn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_phone_number);

        etTitlepn = findViewById(R.id.etTitlepn);
        etmobilenumberpn = findViewById(R.id.etmobilenumberpn);
        etcountrypn = findViewById(R.id.etcountrypn);
        etnotepn = findViewById(R.id.etnotepn);
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

                String mobile = etmobilenumberpn.getText().toString().trim();
                if (mobile.isEmpty() || mobile.length() < 10) {
                    etmobilenumberpn.setError("Please Enter a valid Contact Number");
                    etmobilenumberpn.requestFocus();
                    return;

                } else if (etcountrypn.getText().toString().equals("")) {
                    etcountrypn.setError("Please Enter Country");
                    etcountrypn.requestFocus();
                    return;
                }

                else if (etnotepn.getText().toString().equals("")) {
                    etnotepn.setError("Please Enter Notes");
                    etnotepn.requestFocus();
                    return;
                }

                if (!etmobilenumberpn.getText().toString().equals("")
                        && !etcountrypn.getText().toString().equals("")
                        && !etnotepn.getText().toString().equals("")
                ) {

                    MyDatabaseHelper myDB = new MyDatabaseHelper(AddPhoneNumberActivity.this);
                    myDB.addName(


                            etTitlepn.getText().toString(),
                            "",
                            "",
                            "",
                            "",
                            etmobilenumberpn.getText().toString(),
                            etcountrypn.getText().toString(),
                            Objects.requireNonNull(etnotepn.getText()).toString()

                    );

                    Intent i = new Intent(AddPhoneNumberActivity.this, DashBoardActivity.class);
                    startActivity(i);
                }

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
