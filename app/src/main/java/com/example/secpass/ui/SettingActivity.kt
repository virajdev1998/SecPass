package com.example.secpass.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.secpass.R
import kotlinx.android.synthetic.main.activity_setting.*

class SettingActivity : AppCompatActivity() , View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
        initView()
    }

    private fun initView() {
        btnBack.setOnClickListener(this)
        btnAccountSettings.setOnClickListener(this)
        btnChangePassword.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.btnBack->{
                startActivity(Intent(this,DashBoardActivity::class.java))
            }
            R.id.btnAccountSettings->{
                startActivity(Intent(this,profile_screen::class.java))
            }
            R.id.btnChangePassword->{
                startActivity(Intent(this,Reset_Password::class.java))
            }
        }
    }
}