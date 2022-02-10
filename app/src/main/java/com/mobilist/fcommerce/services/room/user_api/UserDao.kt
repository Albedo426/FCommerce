package com.mobilist.fcommerce.services.room.user_api

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.mobilist.fcommerce.app.data.entity.user.User
import com.mobilist.fcommerce.data.model.LoginModel

@Dao
interface UserDao {
    @Insert
    suspend fun insert(user: User):Long

    @Insert
    suspend fun insertAll(vararg users:User):List<Long>

    @Query("SELECT * FROM User where UserEmail=:userModelMail and UserPassword=:userModelPassword")
    suspend fun loginUser(userModelMail: String,userModelPassword: String): List<User>

    @Query("SELECT * FROM User ")
    suspend fun allUser(): List<User>
}