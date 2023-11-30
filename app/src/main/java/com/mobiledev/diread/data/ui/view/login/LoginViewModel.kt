package com.mobiledev.diread.data.ui.view.login

import androidx.lifecycle.ViewModel
import com.mobiledev.diread.data.pref.UserModel
import com.mobiledev.diread.data.ui.view.UserRepository

class LoginViewModel(private val repository: UserRepository) : ViewModel() {
    fun saveSession(user: UserModel) {
        viewModelScope.launch {
            repository.saveSession(user)
        }
    }

    fun login(email: String, password: String) = repository.login(email, password)
}