package com.example.nearpharm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nearpharm.R
import com.example.nearpharm.model.ProductModel

class ProductAdapter (private val productList: List<ProductModel>):  RecyclerView.Adapter<ProductViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return ProductViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val currentItem = productList[position]
        holder.name.text = currentItem.nameProduct
        holder.type.text = currentItem.type
        holder.price.text = currentItem.price.toString()

    }

    override fun getItemCount(): Int = productList.size

}

class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val name: TextView = itemView.findViewById(R.id.product_name)
    val price: TextView = itemView.findViewById(R.id.price)
    val type: TextView = itemView.findViewById(R.id.type_product)
}