package com.example.nearpharm.viewmodel

import androidx.lifecycle.ViewModel
import br.com.arch.toolkit.livedata.response.ResponseLiveData
import com.example.nearpharm.model.UserModel
import com.example.nearpharm.repository.UserRepository

class UserViewModel(private val repository: UserRepository): ViewModel() {
    fun getPharmacies(idUser: Long) : ResponseLiveData<List<UserModel>> {
        return repository.getPharmacies(idUser)
    }

    fun getPharmacy(idUser: Long) : ResponseLiveData<UserModel> {
        return repository.getPharmacy(idUser)
    }
}