package com.mobiledev.diread.data.ui.view.register

import androidx.lifecycle.ViewModel

class RegisterViewModel (private val repository: UserRepository) : ViewModel() {
    fun register(nama: String, email: String, password: String) = repository.register(nama, email, password)
}