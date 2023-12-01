package com.mobiledev.diread.data.ui.view

import android.net.http.HttpException
import androidx.lifecycle.liveData
import com.google.gson.Gson
import com.mobiledev.diread.data.ResultState
import com.mobiledev.diread.data.pref.UserModel
import com.mobiledev.diread.data.pref.UserPreference
import com.mobiledev.diread.remote.response.ErrorResponse
import com.mobiledev.diread.remote.response.RegisterResponse
import com.mobiledev.diread.remote.retrofit.ApiService
import kotlinx.coroutines.flow.Flow

class UserRepository constructor(
    private val userPreference: UserPreference,
    private val apiService: ApiService
) {

    suspend fun saveSession(user: UserModel) {
        userPreference.saveSession(user)
    }

    fun getSession(): Flow<UserModel> {
        return userPreference.getSession()
    }

    suspend fun logout() {
        userPreference.logout()
    }

    fun register(nama: String, email: String, password: String) = liveData {
        emit(ResultState.Loading)
        try {
            val successResponse = apiService.register(nama, email, password)
            emit(ResultState.Success(successResponse))
        } catch (e: HttpException) {
            val errorBody = e.response()?.errorBody()?.string()
            val errorResponse = Gson().fromJson(errorBody, ErrorResponse::class.java)
            emit(ResultState.Error(errorResponse.message))
        }
    }

    fun login(email: String, password: String) = liveData {
        emit(ResultState.Loading)
        try {
            val successResponse = apiService.login(email, password)
            emit(ResultState.Success(successResponse))
        } catch (e: Exception) {
            if (e is HttpException) {
                val jsonInString = e.response()?.errorBody()?.string()
                val errorBody = Gson().fromJson(jsonInString, RegisterResponse::class.java)
                emit(ResultState.Error(errorBody.message.toString()))
            } else {
                emit(ResultState.Error(e.message.toString()))
            }
        }
    }
}