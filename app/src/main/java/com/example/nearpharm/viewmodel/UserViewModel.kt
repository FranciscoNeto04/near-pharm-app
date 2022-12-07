package com.example.nearpharm.viewmodel

import androidx.lifecycle.ViewModel
import br.com.arch.toolkit.livedata.response.ResponseLiveData
import com.example.nearpharm.model.UserModel
import com.example.nearpharm.model.UsersResponse
import com.example.nearpharm.repository.UserRepository

class UserViewModel(private val repository: UserRepository): ViewModel() {
    fun getPharmacies() : ResponseLiveData<UsersResponse> {
        return repository.getPharmacies()
    }
    fun getUser(idUser: String) : ResponseLiveData<UserModel> {
        return repository.getPharmacy(idUser)
    }

    fun signUpUser(userData: UserModel): ResponseLiveData<Unit> {
        return repository.singUpUser(userData)
    }
}