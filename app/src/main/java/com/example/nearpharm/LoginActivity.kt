package com.example.nearpharm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import br.com.arch.toolkit.delegate.viewProvider
import com.example.nearpharm.model.LoginModel
import com.example.nearpharm.model.LoginResponse
import com.example.nearpharm.model.UserModel
import com.example.nearpharm.retrofit.ApiInterface
import com.example.nearpharm.retrofit.RetrofitInstance
import com.example.nearpharm.viewmodel.UserViewModel
import okhttp3.ResponseBody
import org.koin.android.viewmodel.ext.android.viewModel
import retrofit2.Response

class LoginActivity : AppCompatActivity(R.layout.login_activity) {
    private val buttonLogin: Button by viewProvider(R.id.login_button)
    private val buttonSignUp: TextView  by viewProvider(R.id.signup_button)
    private val edtEmail: EditText by viewProvider(R.id.cpf_cnpj)
    private val edtPassword: EditText by viewProvider(R.id.password)
    private val pharmacyViewModel: UserViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupButtons()
    }

    private fun setupButtons(){
        buttonLogin.setOnClickListener {
            signin(edtEmail.text.toString(),edtPassword.text.toString())
        }
        buttonSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

    private fun signin(token: String, password: String){
        val retIn = RetrofitInstance.getRetrofitInstance().create(ApiInterface::class.java)
        val signInInfo = LoginModel(token, password)
        retIn.signin(signInInfo).enqueue(object : retrofit2.Callback<LoginResponse> {
            override fun onFailure(call: retrofit2.Call<LoginResponse>, t: Throwable) {
                Toast.makeText(
                    this@LoginActivity,
                    t.message,
                    Toast.LENGTH_SHORT
                ).show()
            }
            override fun onResponse(call: retrofit2.Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.code() == 200) {
                    com.example.nearpharm.model.UserData.isPharm = response.body()!!.isPharm
                    val intent = Intent(this@LoginActivity, HomePageActivity::class.java)
                    intent.putExtra("is-pharm-extra", response.body()!!.isPharm)
                    startActivity(intent)
                    Toast.makeText(this@LoginActivity, "Login success!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@LoginActivity, "Login failed!", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}