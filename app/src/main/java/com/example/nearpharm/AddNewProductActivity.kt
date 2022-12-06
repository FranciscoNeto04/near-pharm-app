package com.example.nearpharm

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import br.com.arch.toolkit.delegate.viewProvider

class AddNewProductActivity: AppCompatActivity(R.layout.add_new_product) {
    private val productName: AppCompatEditText by viewProvider(R.id.name)
    private val productType: AppCompatEditText by viewProvider(R.id.type)
    private val productPrice: AppCompatEditText by viewProvider(R.id.price)
    private val addProduct by viewProvider<AppCompatButton>(R.id.add_button)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addProduct.setOnClickListener {
            val intent = Intent(this, HomePageActivity::class.java)
            startActivity(intent)
        }
    }
}