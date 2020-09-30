package com.example.secpass.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.secpass.R
import kotlinx.android.synthetic.main.activity_add_social_media_sites.*

class AddSocialMediaSites : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_social_media_sites)

        initView()
    }

    private fun initView() {
        imgClose.setOnClickListener(this)
        imgAccount.setOnClickListener(this)
        btnSave.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.imgClose -> {
                onBackPressed()
            }
            R.id.imgAccount -> {

            }
            R.id.btnSave -> {

            }
        }
    }
}
