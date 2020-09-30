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

public class Add_Electioncard extends AppCompatActivity {
EditText etTitleec,etEmailec,etElectionCard,etNoteec;
Spinner spnCategoryec;
Button btnSaveec;
ImageView imgCloseec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__electioncard);

        etTitleec = findViewById(R.id.etTitleec);
        etEmailec = findViewById(R.id.etEmailec);
        etElectionCard = findViewById(R.id.etElectionCard);
        etNoteec = findViewById(R.id.etNoteec);
        spnCategoryec = findViewById(R.id.spnCategoryec);
        btnSaveec = findViewById(R.id.btnSaveec);
        imgCloseec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Add_Electioncard.this,DashBoardActivity.class);
                startActivity(i);
            }
        });
        btnSaveec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(Add_Electioncard.this);
                        myDB.adddelectioncard(etTitleec.getText().toString().trim(),
                        etEmailec.getText().toString().trim(),
                        Integer.valueOf(etElectionCard.getText().toString().trim()),
                        "",
                        etNoteec.getText().toString().trim()
                );

            }
        });
    }
}