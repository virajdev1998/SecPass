package com.example.secpass.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.secpass.R
import kotlinx.android.synthetic.main.activity_add_ecommerce_sites.*

class AddEcommerceSitesActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_ecommerce_sites)

        initView()
    }

    private fun initView() {
        btnSave.setOnClickListener(this)
        imgAccount.setOnClickListener(this)
        imgClose.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnSave -> {
                startActivity(Intent(this,DashBoardActivity::class.java))
            }
            R.id.imgClose -> {
                onBackPressed()
            }
            R.id.imgAccount -> {

            }
        }
    }
}
