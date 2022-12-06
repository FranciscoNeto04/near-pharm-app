package com.example.nearpharm

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.arch.toolkit.delegate.viewProvider
import com.example.nearpharm.adapter.PharmacyAdapter
import com.example.nearpharm.model.ProductModel
import com.example.nearpharm.model.UserModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomePageActivity: AppCompatActivity() {
    private val createProduct by viewProvider<FloatingActionButton>(R.id.fab)
    private val pharmacies by viewProvider<RecyclerView>(R.id.recycler)

    private var isUser: Boolean = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(isUser) {
            setupUser()
        } else {
            setupPharmacy()
        }
    }

    private fun setupUser(){
        setContentView(R.layout.homepage_user_activity)
        pharmacies.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        pharmacies.adapter = PharmacyAdapter(listOf(UserModel(
            100L,
            "https://i.imgur.com/O981Moq.png",
            null,
            "61.585.865/0001-51",
            "Droga Raia",
            "Rua Fictícia, número 666",
            "(11) 4002-8922",
            listOf(ProductModel(
                101L,
                "Dipirona 1g",
                10.00,
                "Analgésico"
            ))
        )), ::onClickPharmacy, 10.0)
    }

    private fun onClickPharmacy(userModel: UserModel) {
        val intent = Intent(this, PharmacyDetailActivity::class.java)
        intent.putExtra("pharmacy-extra-id", "id_long")
        startActivity(intent)
    }

    private fun setupPharmacy(){
        setContentView(R.layout.homepage_pharm_activity)
        createProduct.setOnClickListener {
            val intent = Intent(this, AddNewProductActivity::class.java)
            startActivity(intent)
        }
    }
}
