package com.example.secpass.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.secpass.Const
import com.example.secpass.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        Handler().postDelayed({
            moveToNextScreen()
        }, Const.DELAY_MILLIS)
    }

    private fun moveToNextScreen() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}
