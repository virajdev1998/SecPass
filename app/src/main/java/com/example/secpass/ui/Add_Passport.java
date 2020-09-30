package com.example.secpass.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.secpass.R;
import com.example.secpass.helper.MyDatabaseHelper;

public class Add_Passport extends AppCompatActivity {
EditText etTitlepp,etFullNamepp,etNumberpp,etIssueDatepp,etExpirationDatepp,etPlaceOfIssuepp,etGenderpp,etDateofBirthpp,etCountrypp,etNotepp;
Button btnSavepp;
ImageView imgClosepp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__passport);

        etTitlepp=findViewById(R.id.etTitlepp);
        etFullNamepp=findViewById(R.id.etFullNamepp);
        etNumberpp=findViewById(R.id.etNumberpp);
        etIssueDatepp=findViewById(R.id.etIssueDatepp);
        etExpirationDatepp=findViewById(R.id.etExpirationDatepp);
        etPlaceOfIssuepp=findViewById(R.id.etPlaceOfIssuepp);
        etGenderpp=findViewById(R.id.etGenderpp);
        etDateofBirthpp=findViewById(R.id.etDateofBirthpp);
        etCountrypp=findViewById(R.id.etCountrypp);
        etNotepp=findViewById(R.id.etNotepp);
        btnSavepp=findViewById(R.id.btnSavepp);
        imgClosepp=findViewById(R.id.imgClosepp);

        imgClosepp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Add_Passport.this,DashBoardActivity.class);
                startActivity(i);
            }
        });
        btnSavepp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(Add_Passport.this);
                myDB.addpaport(etTitlepp.getText().toString().trim(),
                        etFullNamepp.getText().toString().trim(),
                        Integer.valueOf(etNumberpp.getText().toString().trim()),
                        Integer.valueOf(etIssueDatepp.getText().toString().trim()),
                        Integer.valueOf(etExpirationDatepp.getText().toString().trim()),
                        etPlaceOfIssuepp.getText().toString().trim(),
                        etGenderpp.getText().toString().trim(),
                        Integer.valueOf(etDateofBirthpp.getText().toString().trim()),
                        etCountrypp.getText().toString().trim(),
                        etNotepp.getText().toString().trim()
                );
            }
        });
    }
}