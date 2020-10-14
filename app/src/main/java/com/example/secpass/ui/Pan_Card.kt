package com.example.secpass.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.secpass.R
import com.example.secpass.helper.MyDatabaseHelper
import kotlinx.android.synthetic.main.activity_add__pan_card.*
import kotlinx.android.synthetic.main.activity_ecommerce_sites.*

class Pan_Card : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pan__card)
        initview()
    }
    private fun initview() {
        btnSavepc.setOnClickListener(this)
        imgClosepc.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnSavepc -> {
                if (etNamepc!!.text.toString() == "") {
                    etNamepc!!.error="Please Enter Full name"
                    etNamepc!!.requestFocus()
                    return
                } else if (etPanNumberpc!!.text.toString() == "") {
                    etPanNumberpc!!.error="Please Enter PanNumber"
                    etPanNumberpc!!.requestFocus()
                    return
                } else if (etNotepc!!.text.toString() == "") {
                    etNotepc!!.error = "Please Enter Notes"
                    etNotepc!!.requestFocus()
                    return
                }
                if (etNamepc!!.text.toString() != ""
                    && etPanNumberpc!!.text.toString() != ""
                    && etNotepc!!.text.toString() != ""
                ) {
                val db = MyDatabaseHelper(this)
                db.addidproof(
                    etTitlepc.text.toString(), etNamepc.text.toString(),
                    etPanNumberpc.text.toString(), "", "",
                    "", "", "", etNotepc.text.toString(), ""
                )
                startActivity(Intent(this, DashBoardActivity::class.java))
            }

        }
    }

}
}

