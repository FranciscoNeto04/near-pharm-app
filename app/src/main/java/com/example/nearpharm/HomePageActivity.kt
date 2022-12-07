package com.example.nearpharm

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.arch.toolkit.delegate.extraProvider
import br.com.arch.toolkit.delegate.viewProvider
import com.example.nearpharm.adapter.PharmacyAdapter
import com.example.nearpharm.adapter.ProductAdapter
import com.example.nearpharm.model.UserModel
import com.example.nearpharm.viewmodel.UserViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.koin.android.viewmodel.ext.android.viewModel
import kotlin.random.Random

class HomePageActivity: AppCompatActivity() {
    private val pharmacyViewModel: UserViewModel by viewModel()
    private val createProduct by viewProvider<FloatingActionButton>(R.id.fab)
    private val pharmacies by viewProvider<RecyclerView>(R.id.recycler)
    private val pharmacyId by extraProvider<Boolean>("is-pharm-extra")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        pharmacyViewModel.getUser(pharmacyId.toString()).observe(this) {
            data {
                if(!it.isPharm) {
                    setContentView(R.layout.homepage_user_activity)
                    pharmacies.layoutManager = LinearLayoutManager(this@HomePageActivity, LinearLayoutManager.VERTICAL, false)
                    setupDataUser()
                } else {
                    setContentView(R.layout.homepage_pharm_activity)
                    setupPharmacy()
                }
            }
        }

    }

    private fun onClickPharmacy(userModel: UserModel) {
        val intent = Intent(this, PharmacyDetailActivity::class.java)
        intent.putExtra("pharmacy-extra-id", userModel.cpf)
        startActivity(intent)
    }

    private fun setupPharmacy(){
        createProduct.setOnClickListener {
            val intent = Intent(this, AddNewProductActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setupDataUser(){
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
