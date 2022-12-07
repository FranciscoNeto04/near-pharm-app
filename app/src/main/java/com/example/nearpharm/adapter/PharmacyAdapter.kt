package com.example.nearpharm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nearpharm.R
import com.example.nearpharm.model.UserModel

import com.squareup.picasso.Picasso

class PharmacyAdapter (private val pharmlist: List<UserModel>, private val distance: Double, val onClick: (UserModel) -> Unit):  RecyclerView.Adapter<PharmViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PharmViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.pharm_item, parent, false)
        return PharmViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PharmViewHolder, position: Int) {
        val currentItem = pharmlist[position]
        Picasso.get().load(currentItem.logo)?.into(holder.logo)
        holder.name.text = currentItem.name
        holder.address.text = currentItem.address
        holder.distance.text = distance.toString()
        holder.root.setOnClickListener {
            onClick.invoke(currentItem)
        }
    }

    override fun getItemCount(): Int = pharmlist.size

}

class PharmViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val root: ViewGroup = itemView.findViewById(R.id.root)
    val logo: ImageView = itemView.findViewById(R.id.pharm_logo)
    val name: TextView = itemView.findViewById(R.id.pharm_name)
    val address: TextView = itemView.findViewById(R.id.address_pharm)
    val distance: TextView = itemView.findViewById(R.id.pharm_distance)
}