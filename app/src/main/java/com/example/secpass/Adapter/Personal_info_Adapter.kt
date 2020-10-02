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
        val view = inflater.inflate(R.layout.activity_dashbordecs__row__adapter, parent, false)
        return Viewhoder(view)
    }

    override fun getItemCount(): Int {
        return Ids.size
    }

    override fun onBindViewHolder(holder: Viewhoder, position: Int) {
        var pojo: Personal_Info = Ids.get(position)
        holder.txt_email.setText(pojo.fullname)
        holder.txt_book.setText(pojo.title)
        Glide
            .with(ctx)
            .load(pojo.title)
            .placeholder(R.drawable.instagram)
            .into(holder.img_logo)
    }

}

class Viewhoder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var img_logo: ImageView
    var txt_book: TextView
    var txt_email: TextView

    init {
        img_logo = itemView.findViewById(R.id.book_id_txt)
        txt_book = itemView.findViewById(R.id.book_title_txt)
        txt_email = itemView.findViewById(R.id.mail)
    }

}
