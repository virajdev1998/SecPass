package com.example.secpass.Adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.secpass.R
import java.util.ArrayList

class Dashbord_Row_Adapterinternal constructor(private val activity: Activity, private val context: Context, private val SecPass_id: ArrayList<*>, private val SecPass_titlesms: ArrayList<*>, private val SecPass_emailusername: ArrayList<*>,
                                               private val SecPass_password: ArrayList<*>, private val SecPass_categorysms: ArrayList<*>, private val SecPass_notessms: ArrayList<*>,
                                               private val SecPass_fullname: ArrayList<*>, private val SecPass_nickname: ArrayList<*>, private val SecPass_dob: ArrayList<*>,
                                               private val SecPass_gender:ArrayList<*>
) : RecyclerView.Adapter<Dashbord_Row_Adapterinternal.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.activity_dashbord__row, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

    // holder.book_id_txt.text = SecPass_id[position].toString()
    //    holder.book_title_txt.text = SecPass_titlesms[position].toString()
        if(SecPass_emailusername!=null) {
            holder.Emailsms.text = SecPass_fullname[position].toString()
        }
        else{

        }
    //  holder.Emailsms.text = SecPass_emailusernameecs[position].toString()
    //    holder.book_pages_txt.text = SecPass_password[position].toString()
    //    holder.book_gender_txt.text = SecPass_categorysms[position].toString()
    //    holder.book_note_txt.text = SecPass_notessms[position].toString()
    //Recyclerview onClickListener
    /*  holder.mainLayout.setOnClickListener {
            val intent = Intent(context, UpdateActivity::class.java)
            intent.putExtra("id", book_id[position].toString())
            intent.putExtra("title", book_title[position].toString())
            intent.putExtra("author", book_author[position].toString())
            intent.putExtra("pages", book_pages[position].toString())
            intent.putExtra("gender", book_gender[position].toString())
            intent.putExtra("note", book_note[position].toString())
            activity.startActivityForResult(intent, 1)
        }*/
    }

    override fun getItemCount(): Int {
        return SecPass_id.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    //   var book_id_txt: TextView
        var Emailsms: TextView
    //  var book_author_txt: TextView
    //   var book_pages_txt: TextView
    //    var book_gender_txt: TextView
    //    var book_note_txt: TextView
        var mainLayout: LinearLayout

        init {
           // book_id_txt = itemView.findViewById(R.id.book_id_txt)
            Emailsms = itemView.findViewById(R.id.Email)
         //   book_author_txt = itemView.findViewById(R.id.book_author_txt)
     //       book_pages_txt = itemView.findViewById(R.id.book_pages_txt)
     //       book_gender_txt = itemView.findViewById(R.id.book_gender_txt)
    //        book_note_txt = itemView.findViewById(R.id.book_note_txt)
            mainLayout = itemView.findViewById(R.id.mainLayout)
            //Animate Recyclerview
            val translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim)
            mainLayout.animation = translate_anim
        }
    }



}