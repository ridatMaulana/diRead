package com.mobiledev.diread.data.ui.view.welcome

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mobiledev.diread.data.pref.UserModel
import com.mobiledev.diread.data.ui.view.UserRepository

class WelcomeViewModel(private val repository: UserRepository) : ViewModel() {
    fun getSession(): LiveData<UserModel> {
        return repository.getSession().asLiveData()
    }
}