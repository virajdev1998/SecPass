package com.example.secpass.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.secpass.Adapter.IDs_Adapter
import com.example.secpass.Adapter.Personal_info_Adapter
import com.example.secpass.Adapter.Social_Media_Adapter
import com.example.secpass.R
import com.example.secpass.helper.MyDatabaseHelper
import com.example.secpass.modal.IDs
import com.example.secpass.modal.Personal_Info
import com.example.secpass.modal.Social_Media
import com.github.clans.fab.FloatingActionMenu
import kotlinx.android.synthetic.main.activity_dash_board.*
import java.util.*

class DashBoardActivity : AppCompatActivity(), View.OnClickListener,
    FloatingActionMenu.OnMenuToggleListener {

    private var isopened = false
    var recyclerView: RecyclerView? = null
    var recyclerViewecs: RecyclerView? = null
    var recyclerViewwifi: RecyclerView? = null

    private var myDB: MyDatabaseHelper? = null

    private var list: ArrayList<Personal_Info>? = arrayListOf()
    private var Ids: ArrayList<IDs>? = arrayListOf()
    private var Social_list:ArrayList<Social_Media>? = arrayListOf()

    private var Perosnal_info: Personal_info_Adapter? = null
    private var ID_Adapter:IDs_Adapter?=null
    private var Social_media_adapter:Social_Media_Adapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)

        initView()
        myDB = MyDatabaseHelper(this)

        Store_Personal_info()
        Store_IDs()
        Store_Social_Media()

        Perosnal_info = Personal_info_Adapter(this, list!!)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView!!.adapter = Perosnal_info
        recyclerView!!.layoutManager = LinearLayoutManager(this)
        //ids
        ID_Adapter=IDs_Adapter(this,Ids!!)
        recyclerView!!.adapter = ID_Adapter
        recyclerView!!.layoutManager = LinearLayoutManager(this)
        //social media

        Social_media_adapter= Social_Media_Adapter(this,Social_list!!)
        recyclerView!!.adapter = Social_media_adapter
        recyclerView!!.layoutManager = LinearLayoutManager(this)

    }

    private fun initView() {

        ids.setOnClickListener(this)
        cards.setOnClickListener(this)
        password.setOnClickListener(this)
        floatingmenu.setOnClickListener(this)
        personalinfo.setOnClickListener(this)
        floatingmenu.setOnMenuToggleListener(this)
        pan_card.setOnClickListener(this)
        election_card.setOnClickListener(this)
        driving_license.setOnClickListener(this)
        passport.setOnClickListener(this)
        wifi.setOnClickListener(this)
        ecommerce.setOnClickListener(this)
        address.setOnClickListener(this)
        name.setOnClickListener(this)
        phonenumber.setOnClickListener(this)
        socialmedia.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.ids -> {
                pan_card.visibility = View.VISIBLE
                election_card.visibility = View.VISIBLE
                passport.visibility = View.VISIBLE
                driving_license.visibility = View.VISIBLE
                ids.visibility = View.GONE
                personalinfo.visibility = View.GONE
                cards.visibility = View.GONE
                password.visibility = View.GONE
                wifi.visibility = View.GONE
                ecommerce.visibility = View.GONE
                socialmedia.visibility = View.GONE
                address.visibility = View.GONE
                name.visibility = View.GONE
                phonenumber.visibility = View.GONE
            }

            R.id.password -> {
                wifi.visibility = View.VISIBLE
                ecommerce.visibility = View.VISIBLE
                socialmedia.visibility = View.VISIBLE
                pan_card.visibility = View.GONE
                election_card.visibility = View.GONE
                passport.visibility = View.GONE
                driving_license.visibility = View.GONE
                ids.visibility = View.GONE
                personalinfo.visibility = View.GONE
                cards.visibility = View.GONE
                password.visibility = View.GONE
                address.visibility = View.GONE
                name.visibility = View.GONE
                phonenumber.visibility = View.GONE
            }

            R.id.floatingmenu -> {
                var a = 0
                if (a % 2 != 0) {
                    isopened = true
                    floatingmenu.close(isopened)
                    a += 1
                } else {
                    pan_card.visibility = View.GONE
                    election_card.visibility = View.GONE
                    passport.visibility = View.GONE
                    driving_license.visibility = View.GONE
                    address.visibility = View.GONE
                    name.visibility = View.GONE
                    phonenumber.visibility = View.GONE
                    wifi.visibility = View.GONE
                    ecommerce.visibility = View.GONE
                    socialmedia.visibility = View.GONE
                    a += 1
                }
            }

            R.id.personalinfo -> {
                address.visibility = View.VISIBLE
                name.visibility = View.VISIBLE
                phonenumber.visibility = View.VISIBLE
                ids.visibility = View.GONE
                personalinfo.visibility = View.GONE
                cards.visibility = View.GONE
                password.visibility = View.GONE
                pan_card.visibility = View.GONE
                election_card.visibility = View.GONE
                passport.visibility = View.GONE
                driving_license.visibility = View.GONE
                wifi.visibility = View.GONE
                ecommerce.visibility = View.GONE
                socialmedia.visibility = View.GONE
            }

            R.id.cards -> {

            }

            R.id.pan_card -> {
                startActivity(Intent(this, Add_PanCard::class.java))
            }

            R.id.election_card -> {
                startActivity(Intent(this, AddElectionCardActivity::class.java))
            }

            R.id.passport -> {
                startActivity(Intent(this, ::class.java))
            }

            R.id.driving_license -> {
                startActivity(Intent(this, DrivingLIcence::class.java))
            }

            R.id.wifi -> {
                startActivity(Intent(this, AddWifiActivity::class.java))
            }

            R.id.ecommerce -> {
                startActivity(Intent(this, Ecommerce_sites::class.java))
            }

            R.id.address -> {
                startActivity(Intent(this, AddAddressActivity::class.java))
            }

            R.id.phonenumber -> {
                startActivity(Intent(this, AddPhoneNumberActivity::class.java))
            }

            R.id.socialmedia -> {
                startActivity(Intent(this, social_media_sites::class.java))
            }
            R.id.name -> {
                startActivity(Intent(this, Add_Name::class.java))
            }
        }
    }

    override fun onMenuToggle(opened: Boolean) {
        if (floatingmenu.isOpened) {
            ids.visibility = View.VISIBLE
            personalinfo.visibility = View.VISIBLE
            cards.visibility = View.VISIBLE
            password.visibility = View.VISIBLE

        } else {
            wifi.visibility = View.GONE
            ecommerce.visibility = View.GONE
            socialmedia.visibility = View.GONE
            pan_card.visibility = View.GONE
            election_card.visibility = View.GONE
            passport.visibility = View.GONE
            driving_license.visibility = View.GONE
            address.visibility = View.GONE
            name.visibility = View.GONE
            phonenumber.visibility = View.GONE
            floatingmenu.close(true)
            floatingmenu.clearAnimation()
        }
    }

    fun Store_Personal_info() {
        val cursor = myDB!!.readAllData()
        if (cursor != null) {
            while (cursor.moveToNext()) {

                list!!.add(
                    Personal_Info(
                        cursor.getInt(0), cursor.getString(1),
                        cursor.getString(2), cursor.getString(3),
                        cursor.getString(4), cursor.getString(5),
                        cursor.getString(6), cursor.getString(7),
                        cursor.getString(8), cursor.getString(9)
                    )
                )
            }
            Log.e("test", list.toString())
        }
    }
    fun Store_IDs() {
        val cursor = myDB!!.readAlldrivinglincene()
        if (cursor != null) {
            while (cursor.moveToNext()) {

                Ids!!.add(
                    IDs(
                        cursor.getInt(0), cursor.getString(1),
                        cursor.getString(2), cursor.getString(3),
                        cursor.getString(4), cursor.getString(5),
                        cursor.getString(6), cursor.getString(7),
                        cursor.getString(8), cursor.getString(9),
                        cursor.getString(10),cursor.getString(11)
                    )
                )
            }
            Log.e("test", list.toString())
        }
    }
    fun Store_Social_Media() {
        val cursor = myDB!!.readAllsms()
        if (cursor != null) {
            while (cursor.moveToNext()) {

                Social_list!!.add(
                    Social_Media(
                        cursor.getInt(0), cursor.getString(1),
                        cursor.getString(2), cursor.getString(3),
                        cursor.getString(4), cursor.getString(5))
                )
            }
            Log.e("test", list.toString())
        }
    }
}

