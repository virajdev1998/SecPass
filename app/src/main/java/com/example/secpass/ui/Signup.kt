package com.example.secpass.ui

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.secpass.R
import com.example.secpass.hideProgressDialog
import com.example.secpass.modal.register
import com.example.secpass.showProgressDialog
import com.example.secpass.showToast
import com.example.secpass.webapi.RemoteCallback
import com.example.secpass.webapi.WebAPIManager
import kotlinx.android.synthetic.main.activity_signup.*

class Signup : AppCompatActivity() ,View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        initview()
    }
    private fun initview() {
        tvSignup.setOnClickListener(this)
        signup.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.signup -> {
                startActivity(Intent(this,UserLoginActivity::class.java))

            }
            R.id.tvSignup -> {

                etEmail.text.trim().toString()
                etPassword.text.trim().toString()

                if (isValid()){
                    callRegistr()
                }

            }

        }

    }
    private fun callRegistr(){

        showProgressDialog()
        WebAPIManager.instance.getSignup(etEmail.text.toString(),etPassword.text.toString()).enqueue(object : RemoteCallback<register>() {
            override fun onSuccess(response: register?) {
                hideProgressDialog()
                showToast("Signup Successfully")
              //  Log.d("response", "onSuccess: "+response)
                val i = Intent(this@Signup, UserLoginActivity::class.java)
                startActivity(i)
            }

            override fun onUnauthorized(throwable: Throwable) {
                hideProgressDialog()
                Log.e("test", throwable.message!!)
            }

            override fun onFailed(throwable: Throwable) {
                hideProgressDialog()
               // Log.d("email", "onFailed: "+etEmail.text.toString())
                Log.e("test", throwable.localizedMessage)
                showToast(throwable.localizedMessage)
            }

            override fun onInternetFailed() {
                hideProgressDialog()
                Log.e("test", onInternetFailed().toString())
            }

            override fun onEmptyResponse(message: String) {
                hideProgressDialog()
                Log.e("test", message)
            }
        })
    }


    private fun isValid(): Boolean{
        if (TextUtils.isEmpty(etEmail.toString())) {
            etEmail!!.error="Please enter email address"
            etEmail!!.requestFocus()
               return false
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(etEmail.text.toString()).matches()){
            etEmail.error ="Invalid email address"
            etEmail.requestFocus()
            return false
        }

         if  (TextUtils.isEmpty(etPassword.toString())){
            etPassword!!.error="Please enter Password"
            etPassword!!.requestFocus()
             return false
        }
        if (etPassword.text.length<8){
            etPassword!!.error="atlist 8 characters"
            etPassword.requestFocus()
            return false
        }
          if (TextUtils.isEmpty(etPasswordreenter.toString())){
            etPasswordreenter!!.error="Please enter Master Password"
            etPasswordreenter!!.requestFocus()
              return false
        }
        return true
    }


}