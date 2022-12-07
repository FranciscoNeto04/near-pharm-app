package com.example.nearpharm

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.arch.toolkit.delegate.viewProvider
import com.example.nearpharm.adapter.PharmacyAdapter
import com.example.nearpharm.model.UserModel
import com.example.nearpharm.viewmodel.UserViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.koin.android.viewmodel.ext.android.viewModel

class HomePageActivity: AppCompatActivity() {
    private val createProduct by viewProvider<FloatingActionButton>(R.id.fab)
    private val pharmacies by viewProvider<RecyclerView>(R.id.recycler)
    private val pharmacyViewModel by viewModel<UserViewModel>()

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
        setupData()
    }

    private fun onClickPharmacy(userModel: UserModel) {
        val intent = Intent(this, PharmacyDetailActivity::class.java)
        intent.putExtra("pharmacy-extra-id", 1000)
        startActivity(intent)
    }

    private fun setupPharmacy(){
        setContentView(R.layout.homepage_pharm_activity)
        createProduct.setOnClickListener {
            val intent = Intent(this, AddNewProductActivity::class.java)
            startActivity(intent)
        }
    }

    fun setupData(){
        pharmacyViewModel.getPharmacies(1000).observe(this) {
            data {
                val adapterCategory = PharmacyAdapter(it, 1.0, ::onClickPharmacy)
                pharmacies.adapter = adapterCategory
            }
        }
    }
}
