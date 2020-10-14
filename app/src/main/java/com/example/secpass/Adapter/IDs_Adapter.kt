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
import com.example.secpass.modal.IDs

class IDs_Adapter constructor(var context: Context, var Ids: ArrayList<IDs>) :
    RecyclerView.Adapter<viewholderids>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholderids {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.activity_dashbordwifi__row__adapter, parent, false)
        return viewholderids(view)
    }

    override fun getItemCount(): Int {
        return Ids.size
    }

    override fun onBindViewHolder(holder: viewholderids, position: Int) {
        var pojo: IDs = Ids.get(position)
        holder.idsemail.setText(pojo.fullname)
        holder.idstital.setText(pojo.title)
        Glide
            .with(context)
            .load(pojo.title)
            .placeholder(R.drawable.instagram)
            .into(holder.ids_id)
    }
}

class viewholderids(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var ids_id: ImageView
    var idstital: TextView
    var idsemail: TextView

    init {
        ids_id = itemView.findViewById(R.id.ids_id)
        idstital = itemView.findViewById(R.id.idstital)
        idsemail = itemView.findViewById(R.id.idsemail)
    }

}
