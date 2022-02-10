package com.mobilist.fcommerce.ui.register_screen

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.mobilist.fcommerce.app.data.entity.user.User
import com.mobilist.fcommerce.base.BaseViwModel
import com.mobilist.fcommerce.services.repo.user.UserRepositoryImpl
import com.mobilist.fcommerce.ui.login_screen.LoginActivity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(application: Application, var userRepositoryImpl: UserRepositoryImpl) : BaseViwModel(application)  {
    val userModel = User("","","","","","","",1)
    var error = MutableLiveData<Boolean>()
    var isLoading = MutableLiveData(false)
    fun saveUser(){
        isLoading.value=true
        launch {
            Log.e("TAG", "geldi")
            Log.e("TAG", userModel.toString())
            val users=userRepositoryImpl.insert(userModel)
            LoginActivity.launch(getApplication())
            isLoading.value=false
        }
    }
}