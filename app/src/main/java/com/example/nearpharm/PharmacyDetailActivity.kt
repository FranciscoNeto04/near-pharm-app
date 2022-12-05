package com.example.nearpharm

import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nearpharm.adapter.ProductAdapter

class PharmacyDetailActivity: AppCompatActivity(R.layout.pharmacy_detail_activity) {
    private val average = findViewById<TextView>(R.id.avg_products)
    private val products = findViewById<RecyclerView>(R.id.recycler_products)
    private val name = findViewById<TextView>(R.id.name_pharm)
    private val phone = findViewById<TextView>(R.id.phone_pharm)
    private val logo = findViewById<ImageView>(R.id.logo)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        average.text = getString(R.string.pharmacy_average_products, 20)
        products.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        products.adapter = ProductAdapter(listOf())
    }
}