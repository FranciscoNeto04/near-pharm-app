package com.example.nearpharm

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.arch.toolkit.delegate.extraProvider
import br.com.arch.toolkit.delegate.viewProvider
import com.example.nearpharm.adapter.ProductAdapter
import com.example.nearpharm.model.ProductModel
import com.squareup.picasso.Picasso

class PharmacyDetailActivity: AppCompatActivity(R.layout.pharmacy_detail_activity) {
    private val average: TextView by viewProvider(R.id.avg_products)
    private val name: TextView by viewProvider(R.id.name_pharm)
    private val phone: TextView by viewProvider(R.id.phone_pharm)
    private val address: TextView by viewProvider(R.id.phone_pharm)
    private val logo:ImageView by viewProvider(R.id.logo)
    private val products: RecyclerView by viewProvider(R.id.recycler_products)
    private val pharmacyId: String by extraProvider("pharmacy-id-extra", "")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        average.text = getString(R.string.pharmacy_average_products, 20)
        name.text = "Droga Raia"
        Picasso.get().load("https://i.imgur.com/O981Moq.png").into(logo)
        phone.text = "(11) 4002-8922"
        address.text = "Rua Fictícia, número 666"

        products.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        products.adapter = ProductAdapter(listOf(
            ProductModel(
                101L,
                "Dipirona 1g",
                10.00,
                "Analgésico"
        )
        ))
    }
}