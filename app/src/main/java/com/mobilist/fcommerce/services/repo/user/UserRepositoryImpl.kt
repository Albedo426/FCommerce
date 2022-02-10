package com.mobilist.fcommerce.services.repo.user

import com.mobilist.fcommerce.app.data.entity.user.User
import com.mobilist.fcommerce.data.model.LoginModel
import com.mobilist.fcommerce.services.room.user_api.UserDao
import javax.inject.Inject
//usecase gibi ama farklı use case kullanılıcak apinin altında olmayacak // kalıtım alıcak interfaceyi
class UserRepositoryImpl  @Inject constructor(private val userDao : UserDao): UserRepository {

    override suspend fun insert(user: User):Long {
     return userDao.insert(user)
    }
    override suspend fun insertAll(vararg users: User):List<Long> {
        return userDao.insertAll(*users)
    }
    override suspend fun loginUser(user: LoginModel):List<User> {
        //karar mercisi nereye gidicek nerden alıcak veriyi gibi
        return userDao.loginUser(user.UserEmail,user.UserPassword)
    }
    override suspend fun getAllUser():List<User> {
        return userDao.allUser()
    }

}