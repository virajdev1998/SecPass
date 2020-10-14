package com.example.secpass.ui

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import android.view.View
import com.example.secpass.R
import com.example.secpass.helper.MyDatabaseHelper
import com.example.secpass.hideProgressDialog
import com.example.secpass.modal.register
import com.example.secpass.showProgressDialog
import com.example.secpass.showToast
import com.example.secpass.webapi.RemoteCallback
import com.example.secpass.webapi.WebAPIManager
import kotlinx.android.synthetic.main.activity_add__pan_card.*
import kotlinx.android.synthetic.main.activity_add_name.*
import kotlinx.android.synthetic.main.activity_passport.*
import kotlinx.android.synthetic.main.activity_signup.*
import java.util.*

class PassportActivity : AppCompatActivity(), View.OnClickListener {
    val c = Calendar.getInstance()
    val year = c.get(Calendar.YEAR)
    val month = c.get(Calendar.MONTH)
    val day = c.get(Calendar.DAY_OF_MONTH)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_passport)
        initview()
    }
    private fun initview() {
        imgClosepp.setOnClickListener(this)
        btnSavepp.setOnClickListener(this)
        etIssueDatepp.setOnClickListener(this)
        etExpirationDatepp.setOnClickListener(this)
        etDateofBirthpp.setOnClickListener(this)
    }
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnSavepp -> {
                etFullNamepp.text.trim().toString()
                etNumberpp.text.trim().toString()
                etPlaceOfIssuepp.text.trim().toString()
                etGenderpp.text.trim().toString()
                etCountrypp.text.trim().toString()
                etNotepp.text.trim().toString()

                if (isValid()){
                    callpassport()
                }

            }
            R.id.btnSavepp -> {
                onBackPressed()
            }
            R.id.imgAccount -> {

            }
            R.id.etIssueDatepp -> {
                val dpd = DatePickerDialog(this,R.style.DatePicker, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    // Display Selected date in TextView
                    etIssueDatepp.text = "" + dayOfMonth + "/" + month + "/" + year
                }, year, month, day)
                dpd.show()

            }
            R.id.etExpirationDatepp -> {
                val dpded = DatePickerDialog(this,R.style.DatePicker, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    // Display Selected date in TextView
                    etExpirationDatepp.text = "" + dayOfMonth + "/" + month + "/" + year
                }, year, month, day)
                dpded.show()

            }
            R.id.etDateofBirthpp -> {
                val dpddb = DatePickerDialog(this,R.style.DatePicker, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    // Display Selected date in TextView
                    etDateofBirthpp.text = "" + dayOfMonth + "/" + month + "/" + year
                }, year, month, day)
                dpddb.show()


            }


        }
    }



    private fun callpassport(){

        var db = MyDatabaseHelper(this)
        db.addidproof(
            etTitlepp.text.toString(), etFullNamepp.text.toString(),
            etNumberpp.text.toString(), etIssueDatepp.text.toString(), etExpirationDatepp.text.toString(),
            etGenderpp.text.toString(), etDateofBirthpp.text.toString(), etCountrypp.text.toString(), etNotepp.text.toString(), etPlaceOfIssuepp.text.toString()
        )
        startActivity(Intent(this, DashBoardActivity::class.java))
    }
    private fun isValid(): Boolean{
        if (TextUtils.isEmpty(etFullNamepp.toString())) {
            etFullNamepp!!.error="Please enter full name"
            etFullNamepp!!.requestFocus()
            return false
        }

        if  (TextUtils.isEmpty(etNumberpp.toString())){
            etNumberpp!!.error="Please enter mobile number"
            etNumberpp!!.requestFocus()
            return false
        }

        if (TextUtils.isEmpty(etPlaceOfIssuepp.toString())){
            etPlaceOfIssuepp!!.error="Please enter place of issue"
            etPlaceOfIssuepp!!.requestFocus()
            return false
        }
        if (TextUtils.isEmpty(etGenderpp.toString())){
            etGenderpp!!.error="Please enter gender"
            etGenderpp!!.requestFocus()
            return false
        }
        if (TextUtils.isEmpty(etCountrypp.toString())){
            etCountrypp!!.error="Please enter country"
            etCountrypp!!.requestFocus()
            return false
        }
        if (TextUtils.isEmpty(etNotepp.toString())){
            etNotepp!!.error="Please enter note"
            etNotepp!!.requestFocus()
            return false
        }
        return true
    }

}