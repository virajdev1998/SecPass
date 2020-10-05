package com.example.secpass.ui

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.secpass.R
import com.example.secpass.helper.MyDatabaseHelper
import kotlinx.android.synthetic.main.activity_add__pan_card.*
import kotlinx.android.synthetic.main.activity_add_election_card.*

class Add_PanCard : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_add__pan_card)
        initview()
    }

    private fun initview() {
        btnSavepc.setOnClickListener(this)
        imgClosepc.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnSavepc -> {
                var db = MyDatabaseHelper(this)
                db.addidproof(
                    etTitlepc.text.toString(), etNamepc.text.toString(),
                    etPanNumberpc.text.toString(), "", "",
                    "", "", "", etNotepc.text.toString(), etTitle.text.toString(), ""
                )
                startActivity(Intent(this, DashBoardActivity::class.java))
            }
            R.id.imgClosepc -> {
                onBackPressed()
            }
            R.id.imgAccount -> {

            }

        }
    }

}
