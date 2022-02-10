package com.mobilist.fcommerce.di.user_di

import com.mobilist.fcommerce.services.room.FCDatabase
import com.mobilist.fcommerce.services.room.user_api.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class UserModule {
    @Provides
    @Singleton
    fun provideChannelDao(appDatabase: FCDatabase): UserDao {
        return appDatabase.userDao()
    }

}