package com.example.secpass.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.secpass.R;
import com.example.secpass.helper.MyDatabaseHelper;

public class social_media_sites extends AppCompatActivity {
    EditText  etEmailsms, etPasswordsms, etNotesms;
    Spinner spnCategorysms;
    Button btnSavesms;
    ImageView imgClosesms;
    TextView etTitlsms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_media_sites);

        etTitlsms = findViewById(R.id.etTitlsms);
        etEmailsms = findViewById(R.id.etEmailsms);
        etPasswordsms = findViewById(R.id.etPasswordsms);
        etNotesms = findViewById(R.id.etNotesms);
       // spnCategorysms = findViewById(R.id.spnCategorysms);
        btnSavesms = findViewById(R.id.btnSavesms);
        imgClosesms = findViewById(R.id.imgClosesms);
        imgClosesms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(social_media_sites.this, DashBoardActivity.class);
                startActivity(i);
            }
        });

        btnSavesms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etEmailsms.getText().toString().equals("")) {
                    etEmailsms.setError("Please Enter Email or User name");
                    etEmailsms.requestFocus();
                    return;
                }

                else if (etPasswordsms.getText().toString().equals("")) {
                    etPasswordsms.setError("Please Enter Password");
                    etPasswordsms.requestFocus();
                    return;
                }

                else if (etNotesms.getText().toString().equals("")){
                    etNotesms.setError("Please Enter Notes");
                    etPasswordsms.requestFocus();
                    return;
                }



                if (!etEmailsms.getText().toString().equals("")
                        && !etPasswordsms.getText().toString().equals("")
                        && !etNotesms.getText().toString().equals("")
                ) {

                    MyDatabaseHelper myDB = new MyDatabaseHelper(social_media_sites.this);
                    myDB.addsocialmediasites(etTitlsms.getText().toString().trim(),
                            etEmailsms.getText().toString().trim(),
                            etPasswordsms.getText().toString().trim(),
                            etNotesms.getText().toString().trim()
                    );
                    Intent i = new Intent(social_media_sites.this, DashBoardActivity.class);
                    startActivity(i);
                }
            }
        });
    }
}