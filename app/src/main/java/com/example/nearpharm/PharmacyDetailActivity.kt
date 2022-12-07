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
import com.example.nearpharm.viewmodel.UserViewModel
import com.squareup.picasso.Picasso
import org.koin.android.viewmodel.ext.android.viewModel

class PharmacyDetailActivity : AppCompatActivity(R.layout.pharmacy_detail_activity) {
    private val average: TextView by viewProvider(R.id.avg_products)
    private val name: TextView by viewProvider(R.id.name_pharm)
    private val phone: TextView by viewProvider(R.id.phone_pharm)
    private val address: TextView by viewProvider(R.id.phone_pharm)
    private val logo: ImageView by viewProvider(R.id.logo)
    private val products: RecyclerView by viewProvider(R.id.recycler_products)
    private val pharmacyId: String by extraProvider("pharmacy-id-extra", "")
    private val pharmacyViewModel by viewModel<UserViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        products.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        pharmacyViewModel.getPharmacy(pharmacyId.toLong()).observe(this) {
            data {
                val noLogo = it.logo ?: "https://i.imgur.com/EZvCacK.png"
                average.text = it.products?.map { productModel ->
                    productModel.price
                }.toString()
                name.text = it.name
                Picasso.get().load(noLogo).into(logo)
                phone.text = it.phone
                address.text = it.address
                products.adapter = ProductAdapter(it.products ?: listOf())
            }
        }
    }
}