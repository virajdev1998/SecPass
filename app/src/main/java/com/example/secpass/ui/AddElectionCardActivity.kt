package com.example.secpass.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.secpass.R
import com.example.secpass.helper.MyDatabaseHelper
import kotlinx.android.synthetic.main.activity_add__pan_card.*
import kotlinx.android.synthetic.main.activity_add_election_card.*
import kotlinx.android.synthetic.main.activity_add_election_card.imgAccount

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
        when (v?.id) {
            R.id.imgClose -> {
                onBackPressed()
            }
            R.id.imgAccount -> {

            }
            R.id.btnSave -> {
                if (etfullnameec!!.text.toString() == "") {
                    etfullnameec!!.error = "Please Enter Full name"
                    etfullnameec!!.requestFocus()
                    return
                } else if (etElectionCard!!.text.toString() == "") {
                    etElectionCard!!.error = "Please Enter Electioncardnumber"
                    etElectionCard!!.requestFocus()
                    return
                } else if (etNote!!.text.toString() == "") {
                    etNote!!.error = "Please Enter Notes"
                    etNote!!.requestFocus()
                    return
                }
                if (etfullnameec!!.text.toString() != ""
                    && etElectionCard!!.text.toString() != ""
                    && etNote!!.text.toString() != ""
                ) {
                    val db = MyDatabaseHelper(this)
                    db.addidproof(
                        etTitle.text.toString(), etfullnameec.text.toString(),
                        etElectionCard.text.toString(), "",
                        "", "", "", "",
                        etNote.text.toString(), ""
                    )
                    startActivity(Intent(this, DashBoardActivity::class.java))
                }
            }
        }
    }
}
