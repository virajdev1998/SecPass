package com.example.secpass.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import android.view.View
import com.example.secpass.R
import com.example.secpass.hideProgressDialog
import com.example.secpass.modal.resetpassword
import com.example.secpass.showProgressDialog
import com.example.secpass.showToast
import com.example.secpass.webapi.RemoteCallback
import com.example.secpass.webapi.WebAPIManager
import kotlinx.android.synthetic.main.activity_reset__password2.*
import kotlinx.android.synthetic.main.activity_signup.*

class Reset_Password : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset__password2)
                initview()
    }
    private fun initview() {
        tvdone.setOnClickListener(this)
       // signup.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){

            R.id.tvdone -> {

                etchangepassword.text.trim().toString()
                etPasswordconform.text.trim().toString()

                if (isValid()){
                    callChangepassword()
                }

            }

        }
    }
    private fun callChangepassword(){

        showProgressDialog()
        WebAPIManager.instance.getChangepassword(etchangepassword.text.toString(),etPasswordconform.text.toString()).enqueue(object : RemoteCallback<resetpassword>() {
            override fun onSuccess(response: resetpassword?) {

            }
            override fun onUnauthorized(throwable: Throwable) {
                hideProgressDialog()
                Log.e("test", throwable.message!!)
            }

            override fun onFailed(throwable: Throwable) {
                hideProgressDialog()

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
        if (TextUtils.isEmpty(etchangepassword.toString())) {
            etchangepassword!!.error="Please enter old Password"
            etchangepassword!!.requestFocus()
            return false
        }

        if  (TextUtils.isEmpty(etPasswordconform.toString())){
            etPasswordconform!!.error="Please re enter Password"
            etPasswordconform!!.requestFocus()
            return false
        }
       /* if (etPasswordconform.text.length<8){
            etPasswordconform!!.error="atlist 8 characters"
            etPasswordconform.requestFocus()
            return false
        }
*/
        return true
    }


}
