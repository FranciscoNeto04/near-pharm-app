package com.example.nearpharm.repository

import br.com.arch.toolkit.livedata.response.MutableResponseLiveData
import br.com.arch.toolkit.livedata.response.ResponseLiveData
import com.example.nearpharm.api.UserApi
import com.example.nearpharm.model.UserModel
import com.example.nearpharm.model.UsersResponse
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UserRepository(private val user: UserApi) {

    fun getPharmacies(): ResponseLiveData<UsersResponse> {
        val liveData: MutableResponseLiveData<UsersResponse> = MutableResponseLiveData<UsersResponse>()
        GlobalScope.launch {
            try {
                liveData.postLoading()
                val userLivedata = UsersResponse(
                    listOf<UserModel>(
                        UserModel(
                            "500",
                            "Drogasil",
                            "Av. do Oratório, 5683 - Jardim Angela (Zona Leste), São Paulo - SP, 03221-300",
                            "(11) 941309021",
                            "123",
                            true
                        ),
                        UserModel(
                            "600",
                            "Drogaria São Paulo",
                            "R. Cachoeira Nova Vida, 14 - Vila Pte. Rasa, São Paulo - SP, 03881-100",
                            "(11) 4002-8922",
                            "123",
                            true
                        ),
                        UserModel(
                            "700",
                            "Farma G",
                            "R. Ana Clara, 357 - Vila Mendes, São Paulo - SP, 03257-000",
                            "(11) 27189877",
                            "123",
                            true
                        ),
                        UserModel(
                            "800",
                            "Drogaria São José",
                            "R. Leonilda, 630 - Vila Camilopolis, Santo André - SP, 09240-260",
                            "(11) 44611977",
                            "123",
                            true
                        )
                    )
                )
                liveData.postData(userLivedata)
            } catch (e: Exception) {
                liveData.postError(e)
            }
        }
        return liveData
    }

    fun getPharmacy(idUser: String): ResponseLiveData<UserModel> {
        val liveData: MutableResponseLiveData<UserModel> = MutableResponseLiveData<UserModel>()
        GlobalScope.launch {
            try {
                liveData.postLoading()
                val userLivedata = user.getPharmacy(idUser.toLong())
                liveData.postData(userLivedata)
            } catch (e: Exception) {
                liveData.postError(e)
            }
        }
        return liveData
    }

    fun singUpUser(userData: UserModel): ResponseLiveData<Unit> {
        val liveData:  MutableResponseLiveData<Unit> = MutableResponseLiveData<Unit>()
        GlobalScope.launch {
            try {
                liveData.postLoading()
                val userLivedata = user.singUpUser(userData)
                liveData.postData(userLivedata)
            } catch (e: Exception) {
                liveData.postError(e)
            }
        }
        return liveData
    }
}