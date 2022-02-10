package com.mobilist.fcommerce.di.product_di

import com.mobilist.fcommerce.services.room.FCDatabase
import com.mobilist.fcommerce.services.room.product_api.ProductDao
import com.mobilist.fcommerce.services.room.user_api.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class ProductModule {
    @Provides
    @Singleton
    fun provideChannelDao(appDatabase: FCDatabase): ProductDao {
        return appDatabase.productDao()
    }
}