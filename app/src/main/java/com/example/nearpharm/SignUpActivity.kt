package com.example.nearpharm

import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.isVisible
import br.com.arch.toolkit.delegate.viewProvider

class SignUpActivity: AppCompatActivity(R.layout.signup_activity) {
    private val radioOptionClient by viewProvider<RadioButton>(R.id.user_client)
    private val radioOptionPharm by viewProvider<RadioButton>(R.id.user_pharm)
    private val clientInformationForm by viewProvider<ViewGroup>(R.id.user_client_information)
    private val pharmInformationForm by viewProvider<ViewGroup>(R.id.user_pharm_information)
    private val signUpButton by viewProvider<AppCompatButton>(R.id.signup_button)
    //Information form views - Client:
    private val clientName by viewProvider<AppCompatButton>(R.id.name)
    private val clientEmail by viewProvider<AppCompatButton>(R.id.email)
    private val clientPassword by viewProvider<AppCompatButton>(R.id.password)
    private val clientAddress by viewProvider<AppCompatButton>(R.id.address_user)
    private val clientPhone by viewProvider<AppCompatButton>(R.id.telephone_client)
    private val clientCPF by viewProvider<AppCompatButton>(R.id.cpf)
    //Information form views - Pharmacy:
    private val pharmName by viewProvider<AppCompatButton>(R.id.name_pharm)
    private val pharmEmail by viewProvider<AppCompatButton>(R.id.email_pharm)
    private val pharmPassword by viewProvider<AppCompatButton>(R.id.password_pharm)
    private val pharmAddress by viewProvider<AppCompatButton>(R.id.address_pharm)
    private val pharmPhone by viewProvider<AppCompatButton>(R.id.telephone_pharm)
    private val pharmCNPJ by viewProvider<AppCompatButton>(R.id.cnpj)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupInformationForm()
        clientInformationForm.isVisible = false
        pharmInformationForm.isVisible = false
        signUpButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setupInformationForm() {
        radioOptionClient.setOnClickListener {
            pharmInformationForm.isVisible = false
            clientInformationForm.isVisible = true
        }
        radioOptionPharm.setOnClickListener {
            pharmInformationForm.isVisible = true
            clientInformationForm.isVisible = false
        }
    }
}
