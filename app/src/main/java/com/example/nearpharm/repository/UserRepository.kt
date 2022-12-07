package com.example.nearpharm.repository

import br.com.arch.toolkit.livedata.response.MutableResponseLiveData
import br.com.arch.toolkit.livedata.response.ResponseLiveData
import com.example.nearpharm.api.UserApi
import com.example.nearpharm.model.UserModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UserRepository(private val user: UserApi) {

    fun getPharmacies(idUser: Long): ResponseLiveData<List<UserModel>> {
        val liveData: MutableResponseLiveData<List<UserModel>> = MutableResponseLiveData<List<UserModel>>()
        GlobalScope.launch {
            try {
                liveData.postLoading()
                val userLivedata = user.getUserPharmacy(idUser)
                liveData.postData(userLivedata)
            } catch (e: Exception) {
                liveData.postError(e)
            }
        }
        return liveData
    }

    fun getPharmacy(idUser: Long): ResponseLiveData<UserModel> {
        val liveData: MutableResponseLiveData<UserModel> = MutableResponseLiveData<UserModel>()
        GlobalScope.launch {
            try {
                liveData.postLoading()
                val userLivedata = user.getPharmacy(idUser)
                liveData.postData(userLivedata)
            } catch (e: Exception) {
                liveData.postError(e)
            }
        }
        return liveData
    }
}