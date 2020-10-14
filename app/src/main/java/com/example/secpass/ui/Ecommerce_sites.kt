package com.example.secpass.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.secpass.R
import com.example.secpass.helper.MyDatabaseHelper

class Ecommerce_sites : AppCompatActivity() {
    var etEmailes: EditText? = null
    var etPasswordes: EditText? = null
    var etNotees: EditText? = null
    var spnCategoryes: Spinner? = null
    var btnSavees: Button? = null
    var etTitlees: TextView? = null
    var imgClosees: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ecommerce_sites)
        etTitlees = findViewById(R.id.etTitlees)
        etEmailes = findViewById(R.id.etEmailes)
        etPasswordes = findViewById(R.id.etPasswordes)
        etNotees = findViewById(R.id.etNotees)
        btnSavees = findViewById(R.id.btnSavees)
        //spnCategoryes = findViewById(R.id.spnCategoryes);
        imgClosees = findViewById(R.id.imgClosees)
        imgClosees!!.setOnClickListener(View.OnClickListener {
            val i = Intent(this@Ecommerce_sites, DashBoardActivity::class.java)
            startActivity(i)
        })
        btnSavees!!.setOnClickListener(View.OnClickListener {
            if (etEmailes!!.text.toString() == "") {
                etEmailes!!.error="Please Enter Email or User name"
                etEmailes!!.requestFocus()
                return@OnClickListener
            } else if (etPasswordes!!.text.toString() == "") {
                etPasswordes!!.error="Please Enter Password"
                etPasswordes!!.requestFocus()
                return@OnClickListener
            } else if (etNotees!!.text.toString() == "") {
                etNotees!!.error = "Please Enter Notes"
                etNotees!!.requestFocus()
                return@OnClickListener
            }
            if (etPasswordes!!.text.toString() != ""
                && etPasswordes!!.text.toString() != ""
                && etNotees!!.text.toString() != ""
            ) {
                val myDB = MyDatabaseHelper(this@Ecommerce_sites)
                myDB.addsocialmediasites(
                    etTitlees!!.text.toString().trim { it <= ' ' },
                    etEmailes!!.text.toString().trim { it <= ' ' },
                    etPasswordes!!.text.toString().trim { it <= ' ' },
                    etNotees!!.text.toString().trim { it <= ' ' }
                )
                val i = Intent(this@Ecommerce_sites, DashBoardActivity::class.java)
                startActivity(i)
            }
        })
    }
}