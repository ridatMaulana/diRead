package com.mobiledev.diread.data.ui.view.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobiledev.diread.data.ResultState
import com.mobiledev.diread.data.ui.view.UserRepository
import kotlinx.coroutines.launch

class LoginViewModel(private val userRepository: UserRepository) : ViewModel() {

    private val _loginResult = MutableLiveData<ResultState>()
    val loginResult: LiveData<ResultState> get() = _loginResult

    fun login(email: String, password: String) {
        _loginResult.value = ResultState.Loading

        viewModelScope.launch {
            val result = userRepository.login(email, password)
            _loginResult.value = result
        }
    }
}