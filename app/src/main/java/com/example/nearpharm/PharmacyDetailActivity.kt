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
import com.example.nearpharm.viewmodel.UserViewModel
import com.squareup.picasso.Picasso
import org.koin.android.viewmodel.ext.android.viewModel
import kotlin.random.Random

class PharmacyDetailActivity : AppCompatActivity(R.layout.pharmacy_detail_activity) {
    private val average: TextView by viewProvider(R.id.avg_products)
    private val name: TextView by viewProvider(R.id.name_pharm)
    private val phone: TextView by viewProvider(R.id.phone_pharm)
    private val address: TextView by viewProvider(R.id.address_pharm)
    private val logo: ImageView by viewProvider(R.id.logo)
    private val products: RecyclerView by viewProvider(R.id.recycler_products)
    private val pharmacyId: String by extraProvider("pharmacy-id-extra", "")
    private val pharmacyViewModel: UserViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Picasso.get().load("https://i.imgur.com/EZvCacK.png").into(logo)
        average.text = getString(R.string.pharmacy_average_products, randomize())
        products.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        pharmacyViewModel.getUser(pharmacyId).observe(this) {
            data {
                name.text = it.name
                phone.text = it.phone
                address.text = it.address
                products.adapter = ProductAdapter(randomizeProducts())
            }
        }
    }

    private fun randomize() : String {
        return Random.nextInt(50).toString()
    }
    private fun randomizeProducts(): List<ProductModel> {
        var result = Random.nextInt(2)
           return if(result == 1) {
                listOf(
                    ProductModel(
                        0,
                        "Dipirona 1g",
                        10.00,
                        "Analgésico"
                    ),
                    ProductModel(
                        1,
                        "Diclofenaco 500mg",
                        14.00,
                        "Anti-inflamatório"
                    ),
                    ProductModel(
                        2,
                        "Polaramine 2mg",
                        15.00,
                        "Antialérgico"
                    )
                )
            } else {
                listOf(
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
                )
            }
    }
}