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
import com.example.secpass.modal.Social_Media

class Social_Media_Adapter constructor(var ctx: Context, var socialMedia: ArrayList<Social_Media>) :
    RecyclerView.Adapter<viewholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        val inflater = LayoutInflater.from(ctx)
        val view = inflater.inflate(R.layout.activity_dashbordecs__row__adapter, parent, false)
        return viewholder(view)

    }

    override fun getItemCount(): Int {
        return socialMedia.size
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        var pojo: Social_Media = socialMedia.get(position)
        holder.emailsms.setText(pojo.emal_username)
        holder.titalsms.setText(pojo.title)
        Glide
            .with(ctx)
            .load(pojo.title)
            .placeholder(R.drawable.instagram)
            .into(holder.id_sms)
    }
}
class viewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var id_sms: ImageView
    var titalsms: TextView
    var emailsms: TextView

    init {
        id_sms = itemView.findViewById(R.id.id_sms)
        titalsms = itemView.findViewById(R.id.titalsms)
        emailsms = itemView.findViewById(R.id.emailsms)
    }

}
