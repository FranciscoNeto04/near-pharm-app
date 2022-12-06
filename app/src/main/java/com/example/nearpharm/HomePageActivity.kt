package com.example.nearpharm

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import br.com.arch.toolkit.delegate.viewProvider
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomePageActivity: AppCompatActivity() {
    private val createProduct by viewProvider<FloatingActionButton>(R.id.fab)

    private var isUser: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(isUser) {
            setupUser()
        } else {
            setupPharmacy()
        }
    }

    private fun setupUser(){
        setContentView(R.layout.login_activity)

    }

    private fun setupPharmacy(){
        setContentView(R.layout.homepage_pharm_activity)
        createProduct.setOnClickListener {
            val intent = Intent(this, AddNewProductActivity::class.java)
            startActivity(intent)
        }
    }
}
