package com.mobiledev.diread.data.ui.view.login

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.viewModelScope
import com.mobiledev.diread.data.ui.view.UserRepository
import com.mobiledev.diread.data.ui.view.ViewModelFactory
import com.mobiledev.diread.data.ui.view.main.MainActivity
import com.mobiledev.diread.data.ui.view.register.RegisterActivity
import com.mobiledev.diread.databinding.ActivityLoginBinding
import com.mobiledev.diread.di.Injection
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {
    private val viewModel by viewModels<LoginViewModel> { ViewModelFactory.getInstance(this) }
    private lateinit var binding:ActivityLoginBinding
    private lateinit var userRepository: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        userRepository= Injection.provideRepository(this)
        showLoading(false)
        setupView()
        setupAction()
    }

    private fun setupView() {
        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        supportActionBar?.hide()
    }

    private fun setupAction() {

        binding.clickableText.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.passwordEditText.text.toString()

            viewModel.viewModelScope.launch {
                val result=viewModel.login(email, password).first()
                if(result.isSuccess){
                    val loginResponse=result.getOrNull()
                    loginResponse?.loginResult.let { loginResult ->
                        loginResult?.token?.let { token->
                            viewModel.saveSession(token)
                        }
                    }
                    startActivity(Intent(this@LoginActivity,MainActivity::class.java))
                    finish()
                }else{
                    showLoading(false)
                    val error=result.exceptionOrNull()
                    Toast.makeText(this@LoginActivity,"login failed:${error?.message}",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun showToast(message: String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressIndicator.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
}