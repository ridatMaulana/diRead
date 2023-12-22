package com.mobiledev.diread.data.ui.view.register

import androidx.lifecycle.ViewModel
import com.example.submisionintermediate.data.response.RegisterResponse
import com.mobiledev.diread.data.ui.view.UserRepository

class RegisterViewModel(private val userRepository: UserRepository) : ViewModel() {

    suspend fun register(name: String, email: String, password: String): RegisterResponse {
        return userRepository.register(name, email, password)
    }
}
