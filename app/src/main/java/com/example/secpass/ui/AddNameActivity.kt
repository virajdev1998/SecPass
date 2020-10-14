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
import kotlinx.android.synthetic.main.activity_add__name.*
import kotlinx.android.synthetic.main.activity_add__pan_card.*
import kotlinx.android.synthetic.main.activity_add_name.*
import kotlinx.android.synthetic.main.activity_add_name.etNickName
import kotlinx.android.synthetic.main.activity_add_name.imgClosename
import kotlinx.android.synthetic.main.activity_signup.*
import java.util.*

class AddNameActivity : AppCompatActivity() , View.OnClickListener{
    val c = Calendar.getInstance()
    val year = c.get(Calendar.YEAR)
    val month = c.get(Calendar.MONTH)
    val day = c.get(Calendar.DAY_OF_MONTH)

   // var date1: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_name)
        initview()
    }
    private fun initview() {
        btnSavename.setOnClickListener(this)
        imgClosename.setOnClickListener(this)
        etDateofBirthname.setOnClickListener(this)
    }
    override fun onClick( v: View?) {
        when (v?.id) {
            R.id.btnSavename -> {
                etNickName.text.trim().toString()
                etGendername.text.trim().toString()
                //etDateofBirthname.text.trim().toString()
                etNotename.text.trim().toString()

                if (isValid()){
                    callAddNumber()
                }

            }
            R.id.imgClosename -> {
                onBackPressed()
            }
            R.id.imgAccount -> {

            }
            R.id.etDateofBirthname ->{
                val dpd = DatePickerDialog(this,R.style.DatePicker, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    // Display Selected date in TextView
                    etDateofBirthname.text = "" + dayOfMonth + "/" + month + "/" + year
                }, year, month, day)
                dpd.show()

            }

        }
    }
    private fun callAddNumber(){
        var db = MyDatabaseHelper(this)
        db.addName(
            ettitalname.text.toString(), "",etNickName.text.toString(),etDateofBirthname.text.toString(),
            etGendername.text.toString(), "", "",
            etNotename.text.toString()
        )
        startActivity(Intent(this, DashBoardActivity::class.java))

    }


    private fun isValid(): Boolean{
      /*  if (TextUtils.isEmpty(ettitalname.toString())) {
            ettitalname!!.error="Please enter full name"
            ettitalname!!.requestFocus()
            return false
        }
*/
        if  (TextUtils.isEmpty(etNickName.toString())){
            etNickName!!.error="Please enter nick name"
            etNickName!!.requestFocus()
            return false
        }

        if (TextUtils.isEmpty(etDateofBirthname.toString())){
            etDateofBirthname!!.error="Please select date of birth"
            etDateofBirthname!!.requestFocus()
            return false
        }

        if (TextUtils.isEmpty(etGendername.toString())){
            etGendername!!.error="Please select gender"
            etGendername!!.requestFocus()
            return false
        }
        if (TextUtils.isEmpty(etNotename.toString())){
            etNotename!!.error="Please enter notes"
            etNotename!!.requestFocus()
            return false
        }
        return true
    }


}