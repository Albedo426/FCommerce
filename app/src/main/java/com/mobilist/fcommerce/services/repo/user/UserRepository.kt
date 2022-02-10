package com.mobilist.fcommerce.services.repo.user

import com.mobilist.fcommerce.app.data.entity.user.User
import com.mobilist.fcommerce.data.model.LoginModel

interface UserRepository {
    suspend fun insert(user: User):Long
    suspend fun insertAll(vararg users: User):List<Long>
    suspend fun loginUser(user: LoginModel):List<User>
    suspend fun getAllUser():List<User>
}