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

public class Add_Name extends AppCompatActivity {
EditText etFullName,etNickName,etGender,etDateofBirth,etNote;
Button btnSave;
ImageView imgClosename;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__name);
        etFullName = findViewById(R.id.etFullName);
        etNickName = findViewById(R.id.etNickName);
        imgClosename = findViewById(R.id.imgClosename);
        etGender = findViewById(R.id.etGender);
        etDateofBirth = findViewById(R.id.etDateofBirth);
        etNote = findViewById(R.id.etNote);
        btnSave = findViewById(R.id.btnSave);
        imgClosename.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Add_Name.this,DashBoardActivity.class);
                startActivity(i);
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(Add_Name.this);
                myDB.addName(etFullName.getText().toString().trim(),
                        etNickName.getText().toString().trim(),
                        Integer.valueOf(etDateofBirth.getText().toString().trim()),
                        etGender.getText().toString().trim(),
                        etNote.getText().toString().trim()
                );

            }
        });

    }
}