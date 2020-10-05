package com.example.secpass.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.secpass.R
import com.example.secpass.helper.MyDatabaseHelper
import kotlinx.android.synthetic.main.activity_add_election_card.*

class AddElectionCardActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_election_card)

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
                var db = MyDatabaseHelper(this)
                db.addidproof(
                    etTitle.text.toString(), etEmail.text.toString(),
                    etElectionCard.text.toString(), "",
                    "", "", "", "",
                    etNote.text.toString(), etTitle.text.toString(), ""
                )
                startActivity(Intent(this, DashBoardActivity::class.java))
            }
        }
    }
}
