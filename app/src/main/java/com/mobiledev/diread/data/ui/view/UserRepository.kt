package com.mobiledev.diread.data.ui.view

import androidx.lifecycle.LiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.mobiledev.diread.data.ResultState
import com.mobiledev.diread.data.pref.UserModel
import com.mobiledev.diread.data.pref.UserPreference
import com.mobiledev.diread.remote.retrofit.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.tasks.await

class UserRepository(
    private val userPreference: UserPreference,
    private val firebaseAuth: FirebaseAuth
    private val apiService: ApiService
) {

    suspend fun login(email: String, password: String): ResultState {
        return try {
            val authResult = firebaseAuth.signInWithEmailAndPassword(email, password).await()
            val user = authResult.user?.let {
                UserModel(it.uid, it.email ?: "")
            }

            if (user != null) {
                userPreference.saveSession(user)
            }

            ResultState.Success
        } catch (e: FirebaseAuthException) {
            ResultState.Error(e)
        } catch (e: Exception) {
            ResultState.Error(e)
        }
    }

    suspend fun register(email: String, password: String): ResultState {
        return try {
            val authResult = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
            val user = authResult.user?.let {
                UserModel(it.uid, it.email ?: "")
            }

            if (user != null) {
                userPreference.saveSession(user)
            }

            ResultState.Success
        } catch (e: FirebaseAuthException) {
            ResultState.Error(e)
        } catch (e: Exception) {
            ResultState.Error(e)
        }
    }
    suspend fun saveSession(user: UserModel) {
        userPreference.saveSession(user)
    }

    fun getSession(): Flow<UserModel> {
        return userPreference.getSession()
    }

    fun getJurnal():LiveData<List<Jurnal>> = apiService.getJurnal()
    suspend fun logout() {
        firebaseAuth.signOut()
        userPreference.logout()
    }
}