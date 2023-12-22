package com.mobiledev.diread.data.ui.view.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobiledev.diread.data.ui.view.UserRepository
import kotlinx.coroutines.launch

class profileViewModel(private val userRepository: UserRepository): ViewModel() {
    fun logout() {
        viewModelScope.launch {
            userRepository.logout()
        }
    }
}