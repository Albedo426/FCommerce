package com.mobilist.fcommerce.ui.splah_screen

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mobilist.fcommerce.databinding.ActivitySplashBinding
import com.mobilist.fcommerce.ui.login_screen.LoginActivity
import com.mobilist.fcommerce.ui.main_screen.MainActivity
import com.mobilist.fcommerce.util.CustomSharedPreferences

class SplashActivity : AppCompatActivity() {
    companion object {
        fun launch(context: Context) {
            val intent = Intent(context, SplashActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            //
            context.startActivity(intent)
        }
    }

    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        RouterControl()
    }

    private fun RouterControl() {
        val customSharedPreferences = CustomSharedPreferences(application)
        //customSharedPreferences.removeUserId();
        val userId = customSharedPreferences.getUserId()
        if (userId != null && userId != 0) {
            MainActivity.launch(this)
        } else {
            LoginActivity.launch(this)
        }
    }
}