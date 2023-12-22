package com.mobiledev.diread.data.ui.view.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.submisionintermediate.data.response.LoginResponse
import com.mobiledev.diread.data.ui.view.UserRepository
import kotlinx.coroutines.launch


class LoginViewModel(private val userRepository: UserRepository) : ViewModel() {
    fun saveSession(kode: String) {
        viewModelScope.launch {
            userRepository.simpanPosisi(kode)
        }
    }

    suspend fun login(
        email: String,
        password: String
    ): kotlinx.coroutines.flow.Flow<Result<LoginResponse>> = userRepository.login(email, password)


}