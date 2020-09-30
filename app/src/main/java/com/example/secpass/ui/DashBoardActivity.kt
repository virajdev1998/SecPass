package com.example.secpass.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.secpass.Adapter.Dashbordecs_Row_Adapter
import com.example.secpass.Adapter.Dashbordwifi_Row_Adapter
import com.example.secpass.R
import com.example.secpass.helper.MyDatabaseHelper
import com.github.clans.fab.FloatingActionMenu
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_dash_board.*
import java.util.ArrayList

class DashBoardActivity : AppCompatActivity(), View.OnClickListener,
    FloatingActionMenu.OnMenuToggleListener {

    private var isopened= false
    var recyclerView: RecyclerView? = null
    var recyclerViewecs: RecyclerView? = null
    var recyclerViewwifi: RecyclerView? = null
  //  var add_button: FloatingActionButton? = null
    var empty_imageview: ImageView? = null
    var no_data: TextView? = null
    private var myDB: MyDatabaseHelper? = null
    private var SecPass_id: ArrayList<String>? = null
    private var SecPass_titlesms: ArrayList<String>? = null
    private var SecPass_emailusername: ArrayList<String>? = null
    private var SecPass_password: ArrayList<String>? = null
    private var SecPass_categorysms: ArrayList<String>? = null
    private var SecPass_notessms: ArrayList<String>? = null

    private var Dashbord_Row_Adapterinternal: Dashbord_Row_Adapterinternal? = null

    //ECOMMERCESITES
    private var SecPass_idecs: ArrayList<String>? = null
    private var SecPass_titleecs: ArrayList<String>? = null
    private var SecPass_emailusernameecs: ArrayList<String>? = null
    private var SecPass_passwordecs: ArrayList<String>? = null
    private var SecPass_categoryecs: ArrayList<String>? = null
    private var SecPass_notesecs: ArrayList<String>? = null
    private var Dashbordecs_Row_Adapter: Dashbordecs_Row_Adapter? = null


    //WIFI
    private var SecPass_idwifi: ArrayList<String>? = null
    private var SecPass_titlewifi: ArrayList<String>? = null
    private var SecPass_devicenamewifi: ArrayList<String>? = null
    private var SecPass_passwordwifi: ArrayList<String>? = null
    private var SecPass_categorywifi: ArrayList<String>? = null
    private var SecPass_notewifi: ArrayList<String>? = null
    private var Dashbordwifi_Row_Adapter: Dashbordwifi_Row_Adapter? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)

        initView()
        myDB = MyDatabaseHelper(this)
        //SOCIALMIDIASITE
        SecPass_id = ArrayList()
        SecPass_titlesms = ArrayList()
        SecPass_emailusername = ArrayList()
        SecPass_password = ArrayList()
        SecPass_categorysms = ArrayList()
        SecPass_notessms = ArrayList()
        //ECOMMERCESITES
        SecPass_idecs = ArrayList()
        SecPass_titleecs = ArrayList()
        SecPass_emailusernameecs = ArrayList()
        SecPass_passwordecs = ArrayList()
        SecPass_categoryecs = ArrayList()
        SecPass_notesecs = ArrayList()
        //WIFI
        SecPass_idwifi = ArrayList()
        SecPass_titlewifi = ArrayList()
        SecPass_devicenamewifi = ArrayList()
        SecPass_passwordwifi = ArrayList()
        SecPass_categorywifi = ArrayList()
        SecPass_notewifi = ArrayList()


        //SOCIALMIDIASITE
        storeDataInArrays()
        Dashbord_Row_Adapterinternal = Dashbord_Row_Adapterinternal(this, this, SecPass_id!!, SecPass_titlesms!!, SecPass_emailusername!!,
            SecPass_password!!, SecPass_categorysms!!, SecPass_notessms!!)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView!!.adapter = Dashbord_Row_Adapterinternal
        recyclerView!!.layoutManager = LinearLayoutManager(this)

        //ECOMMERCESITES
        storeDataInArraysecs()
        Dashbordecs_Row_Adapter = Dashbordecs_Row_Adapter(this, this, SecPass_idecs!!, SecPass_titleecs!!, SecPass_emailusernameecs!!,
            SecPass_passwordecs!!, SecPass_categoryecs!!, SecPass_notesecs!!)
        recyclerViewecs = findViewById(R.id.recyclerViewecs)
        recyclerViewecs!!.adapter = Dashbordecs_Row_Adapter
        recyclerViewecs!!.layoutManager = LinearLayoutManager(this)

        //WIFI
        storeDataInArrayswifi()
        Dashbordwifi_Row_Adapter = Dashbordwifi_Row_Adapter(this, this, SecPass_idwifi!!, SecPass_titlewifi!!, SecPass_devicenamewifi!!,
            SecPass_passwordwifi!!, SecPass_categorywifi!!, SecPass_notewifi!!)
        recyclerViewwifi = findViewById(R.id.recyclerViewwifi)
        recyclerViewwifi!!.adapter = Dashbordwifi_Row_Adapter
        recyclerViewwifi!!.layoutManager = LinearLayoutManager(this)


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
        when(v?.id){
            R.id.ids -> {
                pan_card.visibility = View.VISIBLE
                election_card.visibility = View.VISIBLE
                passport.visibility = View.VISIBLE
                driving_license.visibility = View.VISIBLE
                ids.visibility = View.GONE
                personalinfo.visibility = View.GONE
                cards.visibility = View.GONE
                password.visibility = View.GONE
                wifi.visibility=View.GONE
                ecommerce.visibility=View.GONE
                socialmedia.visibility=View.GONE
                address.visibility = View.GONE
                name.visibility = View.GONE
                phonenumber.visibility = View.GONE
            }

            R.id.password -> {
                wifi.visibility=View.VISIBLE
                ecommerce.visibility=View.VISIBLE
                socialmedia.visibility=View.VISIBLE
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

            R.id.floatingmenu->{
                var a=0
                if(a%2!=0){
                    isopened=true
                    floatingmenu.close(isopened)
                    a+=1
                }
                else{
                    pan_card.visibility = View.GONE
                    election_card.visibility = View.GONE
                    passport.visibility = View.GONE
                    driving_license.visibility = View.GONE
                    address.visibility= View.GONE
                    name.visibility= View.GONE
                    phonenumber.visibility= View.GONE
                    wifi.visibility=View.GONE
                    ecommerce.visibility=View.GONE
                    socialmedia.visibility=View.GONE
                    a+=1
                }
            }

            R.id.personalinfo -> {
                address.visibility= View.VISIBLE
                name.visibility= View.VISIBLE
                phonenumber.visibility= View.VISIBLE
                ids.visibility = View.GONE
                personalinfo.visibility = View.GONE
                cards.visibility = View.GONE
                password.visibility = View.GONE
                pan_card.visibility = View.GONE
                election_card.visibility = View.GONE
                passport.visibility = View.GONE
                driving_license.visibility = View.GONE
                wifi.visibility=View.GONE
                ecommerce.visibility=View.GONE
                socialmedia.visibility=View.GONE
            }

            R.id.cards->{

            }

            R.id.pan_card->{
                startActivity(Intent(this,Add_PanCard::class.java))
            }

            R.id.election_card->{
                startActivity(Intent(this,AddElectionCardActivity::class.java))
            }

            R.id.passport->{
                startActivity(Intent(this,Add_Passport::class.java))
            }

            R.id.driving_license->{
                startActivity(Intent(this,DrivingLIcence::class.java))
            }

            R.id.wifi->{
                startActivity(Intent(this, AddWifiActivity::class.java))
            }

            R.id.ecommerce->{
                startActivity(Intent(this, Ecommerce_sites::class.java))
            }

            R.id.address->{
                startActivity(Intent(this,AddAddressActivity::class.java))
            }

            R.id.phonenumber->{
                startActivity(Intent(this, AddPhoneNumberActivity::class.java))
            }

            R.id.socialmedia -> {
                startActivity(Intent(this,social_media_sites::class.java))
            }
            R.id.name->{
                startActivity(Intent(this,Add_Name::class.java))
            }
        }
    }

    override fun onMenuToggle(opened: Boolean) {
        if(floatingmenu.isOpened) {
            ids.visibility = View.VISIBLE
            personalinfo.visibility = View.VISIBLE
            cards.visibility = View.VISIBLE
            password.visibility = View.VISIBLE

        }
        else{
            wifi.visibility=View.GONE
            ecommerce.visibility=View.GONE
            socialmedia.visibility=View.GONE
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
    private fun storeDataInArrays() {
        val cursor = myDB!!.readAllsms()
        if (cursor!!.count == 0) {
//            empty_imageview!!.visibility = View.VISIBLE
  //          no_data!!.visibility = View.VISIBLE
        } else {
            while (cursor.moveToNext()) {
                SecPass_id!!.add(cursor.getString(0))
                SecPass_titlesms!!.add(cursor.getString(1))
                SecPass_emailusername!!.add(cursor.getString(2))
                SecPass_password!!.add(cursor.getString(3))
                SecPass_categorysms!!.add(cursor.getString(4))
                SecPass_notessms!!.add(cursor.getString(5))
            }
       //     empty_imageview!!.visibility = View.GONE
        //    no_data!!.visibility = View.GONE
        }
    }
    private fun storeDataInArraysecs() {
        val cursor = myDB!!.readAllecs()
        if (cursor!!.count == 0) {
//            empty_imageview!!.visibility = View.VISIBLE
            //          no_data!!.visibility = View.VISIBLE
        } else {
            while (cursor.moveToNext()) {
                SecPass_idecs!!.add(cursor.getString(0))
                SecPass_titleecs!!.add(cursor.getString(1))
                SecPass_emailusernameecs!!.add(cursor.getString(2))
                SecPass_passwordecs!!.add(cursor.getString(3))
                SecPass_categoryecs!!.add(cursor.getString(4))
                SecPass_notesecs!!.add(cursor.getString(5))
            }
            //     empty_imageview!!.visibility = View.GONE
            //    no_data!!.visibility = View.GONE
        }
    }
    private fun storeDataInArrayswifi() {
        val cursor = myDB!!.readAllwifi()
        if (cursor!!.count == 0) {
//            empty_imageview!!.visibility = View.VISIBLE
            //          no_data!!.visibility = View.VISIBLE
        } else {
            while (cursor.moveToNext()) {
                SecPass_idwifi!!.add(cursor.getString(0))
                SecPass_titlewifi!!.add(cursor.getString(1))
                SecPass_devicenamewifi!!.add(cursor.getString(2))
                SecPass_passwordwifi!!.add(cursor.getString(3))
                SecPass_categorywifi!!.add(cursor.getString(4))
                SecPass_notewifi!!.add(cursor.getString(5))
            }
            //     empty_imageview!!.visibility = View.GONE
            //    no_data!!.visibility = View.GONE
        }
    }
}
