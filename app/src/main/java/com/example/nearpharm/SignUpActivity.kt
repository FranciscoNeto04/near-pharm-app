package com.example.nearpharm

import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.isVisible
import br.com.arch.toolkit.delegate.viewProvider
import com.example.nearpharm.model.UserModel
import com.example.nearpharm.viewmodel.UserViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class SignUpActivity: AppCompatActivity(R.layout.signup_activity) {
    private val radioOptionClient by viewProvider<RadioButton>(R.id.user_client)
    private val radioOptionPharm by viewProvider<RadioButton>(R.id.user_pharm)
    private val clientInformationForm by viewProvider<ViewGroup>(R.id.user_client_information)
    private val pharmInformationForm by viewProvider<ViewGroup>(R.id.user_pharm_information)
    private val signUpButton by viewProvider<AppCompatButton>(R.id.signup_button)
    //Information form views - Client:
    private val clientName by viewProvider<EditText>(R.id.name)
    private val clientEmail by viewProvider<EditText>(R.id.email)
    private val clientPassword by viewProvider<EditText>(R.id.password)
    private val clientAddress by viewProvider<EditText>(R.id.address_user)
    private val clientPhone by viewProvider<EditText>(R.id.telephone_client)
    private val clientCPF by viewProvider<EditText>(R.id.cpf)
    //Information form views - Pharmacy:
    private val pharmName by viewProvider<EditText>(R.id.name_pharm)
    private val pharmEmail by viewProvider<EditText>(R.id.email_pharm)
    private val pharmPassword by viewProvider<EditText>(R.id.password_pharm)
    private val pharmAddress by viewProvider<EditText>(R.id.address_pharm)
    private val pharmPhone by viewProvider<EditText>(R.id.telephone_pharm)
    private val pharmCNPJ by viewProvider<EditText>(R.id.cnpj)

    private val pharmacyViewModel: UserViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupInformationForm()
        clientInformationForm.isVisible = false
        pharmInformationForm.isVisible = false
        signUpButton.setOnClickListener {
            val isUser = isUserSignUp()
            pharmacyViewModel.signUpUser(
                (if(isUser) {
                    UserModel(
                        clientCPF.text.toString(),
                        clientName.text.toString(),
                        clientAddress.text.toString(),
                        clientPhone.text.toString(),
                        clientPassword.text.toString(),
                        false
                    )
                } else {
                    UserModel (
                        pharmCNPJ.text.toString(),
                        pharmName.text.toString(),
                        pharmAddress.text.toString(),
                        pharmPhone.text.toString(),
                        pharmPassword.text.toString(),
                        true
                    )
                })
            ).observe(this) {
                data {
                    val intent = Intent(this@SignUpActivity, LoginActivity::class.java)
                    startActivity(intent)
                }
                error { _ ->
                    Toast.makeText(this@SignUpActivity, "Erro ao fazer o cadastro", Toast.LENGTH_SHORT).show()
                }

            }
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

    private fun isUserSignUp(): Boolean{
       return radioOptionClient.isChecked
    }
}
