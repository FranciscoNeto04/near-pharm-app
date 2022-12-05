package com.example.nearpharm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class HomePageActivity: AppCompatActivity() {
    private var isUser: Boolean = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(isUser) {
            setContentView(R.layout.login_activity)
        } else {
            setContentView(R.layout.login_activity)
        }
    }
}
