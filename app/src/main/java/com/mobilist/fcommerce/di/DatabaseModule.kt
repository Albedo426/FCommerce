package com.mobilist.fcommerce.di

import android.content.Context
import androidx.room.Room
import com.mobilist.fcommerce.services.room.FCDatabase
import com.mobilist.fcommerce.services.room.user_api.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): FCDatabase {
        return Room.databaseBuilder(
            appContext,
            FCDatabase::class.java,
            "FCDatabase"
        ).build()
    }
}