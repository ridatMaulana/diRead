package com.mobiledev.diread.data.ui.view.register

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
import com.example.submisionintermediate.data.response.RegisterResponse
import com.mobiledev.diread.data.ui.view.ViewModelFactory
import com.mobiledev.diread.data.ui.view.login.LoginActivity
import com.mobiledev.diread.databinding.ActivityRegisterBinding
import kotlinx.coroutines.launch

class RegisterActivity : AppCompatActivity() {
    private val viewModel by viewModels<RegisterViewModel> { ViewModelFactory.getInstance(this) }
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
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
        binding.btnSignup.setOnClickListener {
            showLoading(true)
            val name = binding.edtName.text.toString().trim()
            val email = binding.edtEmail.text.toString().trim()
            val password = binding.passwordEditText.text.toString()

            viewModel.viewModelScope.launch {
                try{
                    val response: RegisterResponse =viewModel.register(name, email, password)
                    if(response.error==false){
                        startActivity(Intent(this@RegisterActivity,LoginActivity::class.java))
                        finish()
                    }else{
                        Toast.makeText(this@RegisterActivity,"pendaftaran gagal:${response.message}",Toast.LENGTH_SHORT).show()
                    }

                }catch (e:Exception){
                    Toast.makeText(this@RegisterActivity,"pendaftaran gagal:${e.message}",Toast.LENGTH_SHORT).show()
                }
            }
            showLoading(false)
        }
    }

    private fun showToast(message: String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressIndicator.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
}