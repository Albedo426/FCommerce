package com.mobilist.fcommerce.ui.login_screen

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.mobilist.fcommerce.databinding.ActivityLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    companion object {
        fun launch(context: Context) {
            val intent = Intent(context, LoginActivity::class.java)
            intent.flags=Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)
        }
    }
    private lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        binding.viewModel = viewModel
        setContentView(binding.root)
        //observer()
    }
    private fun observer() {
        viewModel.isLoading.observe(this, Observer { loading ->
            loading?.let {
                if (loading) {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.constraintLayout.visibility = View.GONE
                } else {
                    binding.progressBar.visibility = View.GONE
                    binding.constraintLayout.visibility = View.VISIBLE
                }
            }
        })
        viewModel.error.observe(this, Observer { error ->
            error?.let {
                if (it) {
                    binding.progressBar.visibility = View.GONE
                    binding.constraintLayout.visibility = View.VISIBLE
                    Toast.makeText(
                        this,
                        "Kullanıcı bulunamadı" + viewModel.error.value,
                        Toast.LENGTH_SHORT
                    ).show()
                }

            }
        })
    }
}