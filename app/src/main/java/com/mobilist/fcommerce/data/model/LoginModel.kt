package com.mobilist.fcommerce.data.model

import com.mobilist.fcommerce.app.data.entity.user.User

data class LoginModel(//response request gibi adlarına ekleme yap
    var UserPassword: String,
    var UserEmail: String,
)

fun LoginModel.toLoginModel(): User {
    return User(UserEmail = UserEmail, UserPassword = UserPassword,
        Username = null, Name = null, LastName = null, TC = null, Phone =null, Role = null
    )
}

