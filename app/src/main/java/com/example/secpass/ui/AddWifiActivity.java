package com.example.secpass.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.res.ResourcesCompat;

import com.example.secpass.R;
import com.example.secpass.helper.MyDatabaseHelper;

public class AddWifiActivity extends AppCompatActivity {

    CardView crdwifi;
    EditText etTitlewifi, etDeviceNamewifi, etPasswordwifi, etNotewifi;
    Spinner spnCategorywifi;
    Context ctx = this;
    ArrayAdapter<String> adapter;
    ImageView imgClosewifi, imageAccount;
    Button btnSavewifi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_wifi);

        etTitlewifi = findViewById(R.id.etTitlewifi);
        etDeviceNamewifi = findViewById(R.id.etDeviceNamewifi);
        etPasswordwifi = findViewById(R.id.etPasswordwifi);
        etNotewifi = findViewById(R.id.etNotewifi);
        spnCategorywifi = findViewById(R.id.spnCategorywifi);

        initView();
        spinnerItem();
    }

    private void initView() {
        imgClosewifi = findViewById(R.id.imgClosewifi);
        imageAccount = findViewById(R.id.imgAccount);
        btnSavewifi = findViewById(R.id.btnSavewifi);
        imgClosewifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AddWifiActivity.this, DashBoardActivity.class);
                startActivity(i);
            }
        });
        imageAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnSavewifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddWifiActivity.this);
                myDB.addsocialmediasites(etTitlewifi.getText().toString().trim(),
                        etDeviceNamewifi.getText().toString().trim(),
                        etPasswordwifi.getText().toString().trim(),
                        "",
                        etNotewifi.getText().toString().trim()
                );

            }
        });
    }

    private void spinnerItem() {
        final Typeface tf = ResourcesCompat.getFont(ctx, R.font.gilroysemi);

        adapter = new ArrayAdapter<String>(ctx, android.R.layout.simple_spinner_item) {

            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                TextView v = (TextView) super.getView(position, convertView, parent);
                if (position == getCount()) {
                    ((TextView) v.findViewById(android.R.id.text1)).setText("");
                    ((TextView) v.findViewById(android.R.id.text1)).setHint(getItem(getCount())); //"Hint to be displayed"
                }
                v.setTypeface(tf);
                return v;
            }

            @Override
            public int getCount() {
                return super.getCount() - 1; // you dont display last item. It is used as hint.
            }

        };

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter.add("Ids");
        adapter.add("Passwords");
        adapter.add("Credit/Debit Cards");
        adapter.add("Personal Info");
        adapter.add("choose category"); //This is the text that will be displayed as hint.

        spnCategorywifi.setAdapter(adapter);
        spnCategorywifi.setSelection(adapter.getCount()); //set the hint the default selection so it appears on launch.
        //spncategory.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
    }

}
