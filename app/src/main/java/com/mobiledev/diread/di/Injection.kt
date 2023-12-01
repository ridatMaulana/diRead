package com.mobiledev.diread.di

import android.content.Context
import com.mobiledev.diread.data.pref.UserPreference
import com.mobiledev.diread.data.pref.dataStore
import com.mobiledev.diread.data.ui.view.UserRepository
import com.mobiledev.diread.remote.retrofit.ApiConfig
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

object Injection {
    fun provideRepository(context: Context): UserRepository {
        val pref = UserPreference.getInstance(context.dataStore)
        val user = runBlocking { pref.getSession().first() }
        val apiService = ApiConfig.getApiService(user.token)
        return UserRepository(pref, apiService)
    }
}