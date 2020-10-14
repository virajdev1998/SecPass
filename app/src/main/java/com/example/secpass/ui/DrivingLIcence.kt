package com.example.secpass.ui

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.secpass.R
import com.example.secpass.helper.MyDatabaseHelper
import kotlinx.android.synthetic.main.activity_add_name.*
import java.util.*

class DrivingLIcence : AppCompatActivity() {
    val c = Calendar.getInstance()
    val year = c.get(Calendar.YEAR)
    val month = c.get(Calendar.MONTH)
    val day = c.get(Calendar.DAY_OF_MONTH)

    var etfullnamedl: EditText? = null
    var etnumberdl: EditText? = null
    var etIssueDatedl: TextView? = null
    var etExpirationDatedl: TextView? = null
    var etGenderdl: EditText? = null
    var etDateofBirthdl: TextView? = null
    var etCountrydl: EditText? = null
    var etNotedl: EditText? = null
    var btnSavedl: Button? = null
    var imgClosedl: ImageView? = null
    var etTitledl: TextView? = null
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_driving_l_icence)
        etTitledl = findViewById(R.id.etTitledl)
        etfullnamedl = findViewById(R.id.etfullnamedl)
        etnumberdl = findViewById(R.id.etnumberdl)
        etIssueDatedl = findViewById(R.id.etIssueDatedl)
        etExpirationDatedl = findViewById(R.id.etExpirationDatedl)
        etGenderdl = findViewById(R.id.etGenderdl)
        etDateofBirthdl = findViewById(R.id.etDateofBirthdl)
        etCountrydl = findViewById(R.id.etCountrydl)
        etNotedl = findViewById(R.id.etNotedl)
        btnSavedl = findViewById(R.id.btnSavedl)
        imgClosedl = findViewById(R.id.imgClosedl)
        imgClosedl!!.setOnClickListener(View.OnClickListener {
            val i = Intent(this@DrivingLIcence, DashBoardActivity::class.java)
            startActivity(i)
        })
        etIssueDatedl!!.setOnClickListener(View.OnClickListener {
            val dpd = DatePickerDialog(this,R.style.DatePicker, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                // Display Selected date in TextView
                etIssueDatedl!!.text = "" + dayOfMonth + "/" + month + "/" + year
            }, year, month, day)
            dpd.show()

        })
        etExpirationDatedl!!.setOnClickListener(View.OnClickListener {
            val dpd = DatePickerDialog(this,R.style.DatePicker, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                // Display Selected date in TextView
                etExpirationDatedl!!.text = "" + dayOfMonth + "/" + month + "/" + year
            }, year, month, day)
            dpd.show()

        })
        etDateofBirthdl!!.setOnClickListener(View.OnClickListener {
            val dpd = DatePickerDialog(this,R.style.DatePicker, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                // Display Selected date in TextView
                etDateofBirthdl!!.text = "" + dayOfMonth + "/" + month + "/" + year
            }, year, month, day)
            dpd.show()

        })
        btnSavedl!!.setOnClickListener(View.OnClickListener {
            val myDB = MyDatabaseHelper(this@DrivingLIcence)
            myDB.addidproof(
                etTitledl!!.text.toString().trim { it <= ' ' },
                etfullnamedl!!.text.toString().trim { it <= ' ' },
                etnumberdl!!.text.toString().trim { it <= ' ' },
                etIssueDatedl!!.text.toString().trim { it <= ' ' },
                etExpirationDatedl!!.text.toString().trim { it <= ' ' },
                etGenderdl!!.text.toString().trim { it <= ' ' },
                etDateofBirthdl!!.text.toString().trim { it <= ' ' },
                etCountrydl!!.text.toString().trim { it <= ' ' },
                etNotedl!!.text.toString().trim { it <= ' ' }, ""
            )
            val i = Intent(this@DrivingLIcence, DashBoardActivity::class.java)
            startActivity(i)
        })
    }
}