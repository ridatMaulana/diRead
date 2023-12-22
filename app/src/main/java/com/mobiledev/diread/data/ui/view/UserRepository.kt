package com.mobiledev.diread.data.ui.view

import com.example.submisionintermediate.data.response.LoginResponse
import com.example.submisionintermediate.data.response.RegisterResponse
import com.mobiledev.diread.data.pref.UserPreference
import com.mobiledev.diread.remote.retrofit.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class UserRepository private constructor(
    private val userPreference: UserPreference, val apiService: ApiService
) {
    suspend fun simpanPosisi(kode: String) {
        userPreference.simpanPosisi(kode)
    }

    fun getToken(): Flow<String?> {
        return userPreference.getUser()
    }

    suspend fun logout() {
        userPreference.logout()
    }

    suspend fun login(email: String, password: String): Flow<Result<LoginResponse>> = flow {
        try {
            val response = apiService.login(email, password)
            emit(Result.success(response))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(Result.failure(e))
        }
    }.flowOn(Dispatchers.IO)


    suspend fun register(name: String, email: String, password: String): RegisterResponse = try {
        apiService.register(name, email, password)
    } catch (e: Exception) {
        throw e
    }


    companion object {
        @Volatile
        private var instance: UserRepository? = null
        fun getInstance(
            userPreference: UserPreference, apiService: ApiService
        ): UserRepository = instance ?: synchronized(this) {
            instance ?: UserRepository(userPreference, apiService)
        }.also { instance = it }
    }
}