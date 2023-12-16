package com.mobiledev.diread.data.ui.view.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.mobiledev.diread.data.ResultState
import com.mobiledev.diread.data.ui.view.UserRepository
import kotlinx.coroutines.launch

class RegisterViewModel(private val userRepository: UserRepository) : ViewModel() {

    private val _registrationResult = MutableLiveData<ResultState>()
    val registrationResult: LiveData<ResultState> get() = _registrationResult

    fun register(name: String, email: String, password: String) {
        _registrationResult.value = ResultState.Loading

        viewModelScope.launch {
            val result = userRepository.register(email, password)
            _registrationResult.value = result
        }
    }
}
