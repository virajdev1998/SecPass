package com.example.secpass.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.secpass.R
import com.example.secpass.modal.Personal_Info

class Personal_info_Adapter constructor(var ctx: Context, var Ids: ArrayList<Personal_Info>) :
    RecyclerView.Adapter<Viewhoder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewhoder {
        val inflater = LayoutInflater.from(ctx)
        val view = inflater.inflate(R.layout.activity_dashbord__row, parent, false)
        return Viewhoder(view)
    }

    override fun getItemCount(): Int {
        return Ids.size
    }

    override fun onBindViewHolder(holder: Viewhoder, position: Int) {
        var pojo: Personal_Info = Ids.get(position)

        if (pojo.phonenumber==""){
            holder.Email_pi.setText(pojo.nickname)
        }
        else
        {
            holder.Email_pi.setText(pojo.phonenumber)
        }

        holder.tital_pi.setText(pojo.title)
        Glide
            .with(ctx)
            .load(pojo.title)
            .placeholder(R.drawable.instagram)
            .into(holder.id_pi)
    }

}

class Viewhoder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var id_pi: ImageView
    var tital_pi: TextView
    var Email_pi: TextView

    init {
        id_pi = itemView.findViewById(R.id.id_pi)
        tital_pi = itemView.findViewById(R.id.tital_pi)
        Email_pi = itemView.findViewById(R.id.Email_pi)
    }

}
