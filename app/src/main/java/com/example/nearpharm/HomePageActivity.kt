package com.example.nearpharm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class HomePageActivity: AppCompatActivity() {
    private var isUser: Boolean = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(isUser) {
            setContentView(R.layout.homepage_user_activity)
        } else {
            setContentView(R.layout.homepage_pharm_activity)
        }
    }

    private fun setupUser(){
        setContentView(R.layout.login_activity)

    }
}
