package com.mobilist.fcommerce.ui.login_screen
import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.mobilist.fcommerce.ui.splah_screen.SplashActivity
import com.mobilist.fcommerce.base.BaseViwModel
import com.mobilist.fcommerce.data.model.LoginModel
import com.mobilist.fcommerce.services.repo.user.UserRepositoryImpl
import com.mobilist.fcommerce.ui.register_screen.RegisterActivity
import com.mobilist.fcommerce.util.CustomSharedPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel   @Inject constructor(application: Application,var userRepositoryImpl: UserRepositoryImpl) : BaseViwModel(application)  {
    var loginModel = LoginModel("","")
    var error = MutableLiveData<Boolean>()
    var isLoading = MutableLiveData<Boolean>(false)
    private val customSharedPreferences = CustomSharedPreferences(application)
    fun login(){
        isLoading.value=true
        launch {
            val users=userRepositoryImpl.loginUser(loginModel)
            Log.e("TAG", "login: "+userRepositoryImpl.getAllUser() )
            if(users.size==1){
                customSharedPreferences.saveUserId(users[0].UUID)
                SplashActivity.launch(getApplication())
                isLoading.value=false
            }else{
                error.value=true
            }
        }
    }
    fun goRegister(){
        RegisterActivity.launch(getApplication())
    }
}