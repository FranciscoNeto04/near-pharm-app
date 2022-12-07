package com.example.nearpharm

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.arch.toolkit.delegate.extraProvider
import br.com.arch.toolkit.delegate.viewProvider
import com.example.nearpharm.adapter.PharmacyAdapter
import com.example.nearpharm.adapter.ProductAdapter
import com.example.nearpharm.model.ProductModel
import com.example.nearpharm.model.UserModel
import com.example.nearpharm.viewmodel.UserViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.squareup.picasso.Picasso
import org.koin.android.viewmodel.ext.android.viewModel
import kotlin.random.Random

class HomePageActivity: AppCompatActivity() {
    private val pharmacyViewModel: UserViewModel by viewModel()
    private val createProduct by viewProvider<FloatingActionButton>(R.id.fab)
    private val map by viewProvider<ImageView>(R.id.map)
    private val pharmacies by viewProvider<RecyclerView>(R.id.recycler)
    private val products by viewProvider<RecyclerView>(R.id.recycler_products)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val isPharm = intent.extras?.getBoolean("is-pharm-extra")
        if(isPharm == false) {
            setContentView(R.layout.homepage_user_activity)
            pharmacies.layoutManager = LinearLayoutManager(this@HomePageActivity, LinearLayoutManager.VERTICAL, false)
            setupDataUser()
        } else {
            setContentView(R.layout.homepage_pharm_activity)
            products.layoutManager = LinearLayoutManager(this@HomePageActivity, LinearLayoutManager.VERTICAL, false)
            setupPharmacy()
        }
    }

    private fun onClickPharmacy(userModel: UserModel) {
        val intent = Intent(this, PharmacyDetailActivity::class.java)
        intent.putExtra("pharmacy-extra-id", userModel.cpf)
        startActivity(intent)
    }

    private fun setupPharmacy(){
        val adapterProducts = ProductAdapter(listOf(
            ProductModel(
                0,
                "Dipirona 500mg",
                9.00,
                "Analgésico"
            ),
            ProductModel(
                1,
                "Diclofenaco Potássico 250mg",
                12.00,
                "Anti-inflamatório"
            ),
            ProductModel(
                2,
                "Polaramine 2mg",
                15.00,
                "Antialérgico"
            ),
            ProductModel(
                2,
                "Polaramine 2mg",
                15.00,
                "Antialérgico"
            ),
            ProductModel(
                2,
                "Polaramine 2mg",
                15.00,
                "Antialérgico"
            )
        ))
        products.adapter = adapterProducts


        createProduct.setOnClickListener {
            val intent = Intent(this, AddNewProductActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setupDataUser(){
        Picasso.get().load("https://i.imgur.com/z7US03x.png").into(map)
        pharmacyViewModel.getPharmacies().observe(this) {
            data {
                val adapterCategory = PharmacyAdapter(it, this@HomePageActivity, randomizeDistance().toString(), ::onClickPharmacy)
                pharmacies.adapter = adapterCategory
            }
        }
    }

    private fun randomizeDistance(): Int {
       return Random.nextInt(5)
    }
}
