package com.mobiledev.diread.data.ui.view

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mobiledev.diread.data.ui.view.login.LoginViewModel
import com.mobiledev.diread.data.ui.view.main.MainViewModel
import com.mobiledev.diread.data.ui.view.profile.Profile
import com.mobiledev.diread.data.ui.view.profile.profileViewModel
import com.mobiledev.diread.data.ui.view.register.RegisterViewModel
import com.mobiledev.diread.di.Injection

class ViewModelFactory(private val repository: UserRepository) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> {
                MainViewModel(repository) as T
            }
            modelClass.isAssignableFrom(LoginViewModel::class.java) -> {
                LoginViewModel(repository) as T
            }
            modelClass.isAssignableFrom(RegisterViewModel::class.java)->{
                RegisterViewModel(repository) as T
            }
            modelClass.isAssignableFrom(profileViewModel::class.java)->{
                profileViewModel(repository)as T}

            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: ViewModelFactory? = null
        @JvmStatic
        fun getInstance(context: Context): ViewModelFactory {
            if (INSTANCE == null) {
                synchronized(ViewModelFactory::class.java) {
                    INSTANCE = ViewModelFactory(Injection.provideRepository(context))
                }
            }
            return INSTANCE as ViewModelFactory
        }
    }
}