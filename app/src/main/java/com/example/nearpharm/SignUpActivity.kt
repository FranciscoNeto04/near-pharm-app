package com.example.nearpharm

import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.isVisible

class SignUpActivity: AppCompatActivity(R.layout.signup_activity) {
    private val radioOptionClient = findViewById<RadioButton>(R.id.user_client)
    private val clientInformationForm = findViewById<ViewGroup>(R.id.user_client_information)
    private val pharmInformationForm = findViewById<ViewGroup>(R.id.user_pharm_information)
    private val signUpButton = findViewById<AppCompatButton>(R.id.signup_button)
    //Information form views - Client:
    private val clientName = findViewById<AppCompatButton>(R.id.name)
    private val clientEmail = findViewById<AppCompatButton>(R.id.email)
    private val clientPassword = findViewById<AppCompatButton>(R.id.password)
    private val clientAddress = findViewById<AppCompatButton>(R.id.address_user)
    private val clientPhone = findViewById<AppCompatButton>(R.id.telephone_client)
    private val clientCPF = findViewById<AppCompatButton>(R.id.cpf)
    //Information form views - Pharmacy:
    private val pharmName = findViewById<AppCompatButton>(R.id.name_pharm)
    private val pharmEmail = findViewById<AppCompatButton>(R.id.email_pharm)
    private val pharmPassword = findViewById<AppCompatButton>(R.id.password_pharm)
    private val pharmAddress = findViewById<AppCompatButton>(R.id.address_pharm)
    private val pharmPhone = findViewById<AppCompatButton>(R.id.telephone_pharm)
    private val pharmCNPJ = findViewById<AppCompatButton>(R.id.cnpj)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupInformationForm()
        signUpButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setupInformationForm() {
        if(radioOptionClient.isChecked) {
            pharmInformationForm.isVisible = false
            clientInformationForm.isVisible = true
        } else {
            pharmInformationForm.isVisible = true
            clientInformationForm.isVisible = false
        }
    }
}
