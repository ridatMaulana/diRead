package com.mobiledev.diread.data.ui.view.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.mobiledev.diread.data.ui.view.UserRepository
import kotlinx.coroutines.launch

class MainViewModel(private val userRepository: UserRepository): ViewModel() {
    private val _userSession = MutableLiveData<String?>()
    val userSession: LiveData<String?>
        get() = _userSession


    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    private val _error = MutableLiveData<String>()
    val error: LiveData<String>
        get() = _error


    init {
        getSession()
    }
    fun getSession() {
        viewModelScope.launch {
            userRepository.getToken().collect { session ->
                _userSession.value = session
            }
        }
    }
    fun logout() {
        viewModelScope.launch {
            userRepository.logout()
        }
    }
}