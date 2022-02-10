package com.mobilist.fcommerce.ui.register_screen

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.mobilist.fcommerce.databinding.ActivityRegisterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterActivity : AppCompatActivity() {
    companion object {
        fun launch(context: Context) {
            val intent = Intent(context, RegisterActivity::class.java)
            intent.flags=Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)
        }
    }
    private lateinit var binding: ActivityRegisterBinding
    private val viewModel: RegisterViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        binding.viewModel = viewModel
        setContentView(binding.root)
    }
}