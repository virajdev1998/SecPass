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

public class social_media_sites extends AppCompatActivity {
EditText etTitlsms,etEmailsms,etPasswordsms,etNotesms;
Spinner spnCategorysms;
Button btnSavesms;
ImageView imgClosesms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_media_sites);

        etTitlsms = findViewById(R.id.etTitlsms);
        etEmailsms = findViewById(R.id.etEmailsms);
        etPasswordsms = findViewById(R.id.etPasswordsms);
        etNotesms = findViewById(R.id.etNotesms);
        spnCategorysms = findViewById(R.id.spnCategorysms);
        btnSavesms = findViewById(R.id.btnSavesms);
        imgClosesms = findViewById(R.id.imgClosesms);
        imgClosesms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(social_media_sites.this,DashBoardActivity.class);
                startActivity(i);
            }
        });

        btnSavesms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(social_media_sites.this);
                myDB.addsocialmediasites(etTitlsms.getText().toString().trim(),
                        etEmailsms.getText().toString().trim(),
                        etPasswordsms.getText().toString().trim(),
                        "",
                        etNotesms.getText().toString().trim()
                );

            }
        });
    }
}