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

public class Add_PanCard extends AppCompatActivity {
EditText etTitlepc,etNamepc,etPanNumberpc,etNotepc;
Spinner spnCategory;
Button btnSavepc;
ImageView imgClosepc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__pan_card);

        etTitlepc=findViewById(R.id.etTitlepc);
        etNamepc=findViewById(R.id.etNamepc);
        etPanNumberpc=findViewById(R.id.etPanNumberpc);
        etNotepc=findViewById(R.id.etNotepc);
        btnSavepc=findViewById(R.id.btnSavepc);
        spnCategory=findViewById(R.id.spnCategory);
        imgClosepc=findViewById(R.id.imgClosepc);

        imgClosepc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Add_PanCard.this,DashBoardActivity.class);
                startActivity(i);
            }
        });
        btnSavepc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(Add_PanCard.this);
                myDB.adddpancard(etTitlepc.getText().toString().trim(),
                        etNamepc.getText().toString().trim(),
                        Integer.valueOf(etPanNumberpc.getText().toString().trim()),
                      "",
                        etNotepc.getText().toString().trim()
                );

            }
        });
    }
}