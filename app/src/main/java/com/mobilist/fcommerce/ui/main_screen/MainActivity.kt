package com.mobilist.fcommerce.ui.main_screen

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.mobilist.fcommerce.R
import com.mobilist.fcommerce.databinding.ActivityMainBinding
import com.mobilist.fcommerce.util.CustomSharedPreferences
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    companion object {
        fun launch(context: Context) {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
    }
    private lateinit var navigationController: NavController
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navigationController = Navigation.findNavController(this, R.id.fragmentContainerView)
        NavigationUI.setupActionBarWithNavController(this,navigationController)
    }
    fun removeId(){
        //Log.e("TAG", "removeId: ", )
        val customSharedPreferences = CustomSharedPreferences(application)
        customSharedPreferences.removeUserId()
    }
}