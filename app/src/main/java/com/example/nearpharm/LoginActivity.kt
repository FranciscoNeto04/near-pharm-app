package com.example.nearpharm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.AppCompatEditText
import br.com.arch.toolkit.delegate.viewProvider

class LoginActivity : AppCompatActivity(R.layout.login_activity) {
    private val buttonLogin: Button by viewProvider(R.id.login_button)
    private val buttonSignUp: TextView  by viewProvider(R.id.signup_button)
    private val edtEmail: AppCompatEditText by viewProvider(R.id.cpf_cnpj)
    private val edtPassword: AppCompatEditText by viewProvider(R.id.password)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupButtons()
    }

    private fun setupButtons(){
        buttonLogin.setOnClickListener {
            val intent = Intent(this, HomePageActivity::class.java)
            startActivity(intent)
        }
        buttonSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}