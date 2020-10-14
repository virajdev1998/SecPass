package com.example.secpass.ui

import android.content.Intent
import android.opengl.ETC1.isValid
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.secpass.R
import com.example.secpass.hideProgressDialog
import com.example.secpass.modal.Login
import com.example.secpass.showProgressDialog
import com.example.secpass.showToast
import com.example.secpass.webapi.RemoteCallback
import com.example.secpass.webapi.WebAPIManager
import kotlinx.android.synthetic.main.activity_signup.*
import kotlinx.android.synthetic.main.activity_user_login.*


class UserLoginActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_login)

        initView()
    }

    private fun initView() {
        tvLogin.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.tvLogin -> {
                //  startActivity(Intent(this, Ecommerce_sites::class.java))
                etEmaillogin.text.trim().toString()
                etPasswordlogin.text.trim().toString()

                if (isValid()){
                    callLogin()
                }

            }

        }
    }
    private fun callLogin(){

        showProgressDialog()
        WebAPIManager.instance.getSignin("virajbaraiya1998@gmail.com","viraj12345").enqueue(object : RemoteCallback<Login>() {
            override fun onSuccess(response: Login?) {
                hideProgressDialog()
                showToast("Signin Successfully")


                val i = Intent(this@UserLoginActivity, DashBoardActivity::class.java)
                startActivity(i)
            }

            override fun onUnauthorized(throwable: Throwable) {
                hideProgressDialog()
                Log.e("test", throwable.message!!)
            }

            override fun onFailed(throwable: Throwable) {
                hideProgressDialog()
                showToast(throwable.message!!)
                Log.e("tag",throwable.localizedMessage)
                Log.e("test1", throwable.message!!)
                val i = Intent(this@UserLoginActivity, DashBoardActivity::class.java)
                startActivity(i)
            }

            override fun onInternetFailed() {
                hideProgressDialog()
                Log.e("test2", onInternetFailed().toString())
            }

            override fun onEmptyResponse(message: String) {
                hideProgressDialog()
                Log.e("test3", message)
            }
        })
    }

    private fun isValid(): Boolean{
        if (TextUtils.isEmpty(etEmaillogin.toString())) {
            etEmaillogin!!.error="Please enter email address"
            etEmaillogin!!.requestFocus()
            return false
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(etEmaillogin.text.toString()).matches()){
            etEmaillogin.error ="Invalid email address"
            etEmaillogin.requestFocus()
            return false
        }

        if  (TextUtils.isEmpty(etPasswordlogin.toString())){
            etPasswordlogin!!.error="Please enter Password"
            etPasswordlogin!!.requestFocus()
            return false
        }
        if (etPasswordlogin.text.length<8){
            etPasswordlogin!!.error="Password atlist 8 characters"
            etPasswordlogin.requestFocus()
            return false
        }

        return true
    }

}
