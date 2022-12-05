package com.example.nearpharm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatEditText

class LoginActivity : AppCompatActivity(R.layout.login_activity) {
    private val buttonLogin = findViewById<TextView>(R.id.login_button)
    private val buttonSignUp = findViewById<TextView>(R.id.signup_button)
    private val edtEmail = findViewById<AppCompatEditText>(R.id.email)
    private val edtPassword = findViewById<AppCompatEditText>(R.id.password)

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