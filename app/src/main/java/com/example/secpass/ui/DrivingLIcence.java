package com.example.secpass.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.secpass.R;
import com.example.secpass.helper.MyDatabaseHelper;

public class DrivingLIcence extends AppCompatActivity {
EditText etTitle,etfullname,etnumber,etIssueDate,etExpirationDate,etGenderdl,etDateofBirth,etCountry,etNotedl;
Button btnSavedl;
ImageView imgClosedl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driving_l_icence);

        etTitle = findViewById(R.id.etTitle);
        etfullname = findViewById(R.id.etfullname);
        etnumber = findViewById(R.id.etnumber);
        etIssueDate = findViewById(R.id.etIssueDate);
        etExpirationDate = findViewById(R.id.etExpirationDate);
        etGenderdl = findViewById(R.id.etGenderdl);
        etDateofBirth = findViewById(R.id.etDateofBirth);
        etCountry = findViewById(R.id.etCountry);
        etNotedl = findViewById(R.id.etNotedl);
        btnSavedl = findViewById(R.id.btnSavedl);
        imgClosedl = findViewById(R.id.imgClosedl);
        imgClosedl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DrivingLIcence.this,DashBoardActivity.class);
                startActivity(i);
            }
        });

        btnSavedl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(DrivingLIcence.this);
                myDB.adddrivinglicense(etTitle.getText().toString().trim(),
                        etfullname.getText().toString().trim(),
                        Integer.valueOf(etnumber.getText().toString().trim()),
                        Integer.valueOf(etIssueDate.getText().toString().trim()),
                        Integer.valueOf(etExpirationDate.getText().toString().trim()),
                        etGenderdl.getText().toString().trim(),
                        Integer.valueOf(etDateofBirth.getText().toString().trim()),
                        etCountry.getText().toString().trim(),
                        etNotedl.getText().toString().trim()
                );
            }
        });


    }
}