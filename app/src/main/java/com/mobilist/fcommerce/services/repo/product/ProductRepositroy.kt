package com.mobilist.fcommerce.services.repo.product

import androidx.room.Insert
import androidx.room.Query
import com.mobilist.fcommerce.app.data.entity.product.Product
import com.mobilist.fcommerce.app.data.entity.product.ProductMainItem

interface ProductRepositroy {
    suspend fun insert(product: Product):Long
    suspend fun insertAll(vararg users: Product):List<Long>
    suspend fun allProduct(): List<Product>
    suspend fun allProductById(Id:Int): Product
    suspend fun allProductByCategoryId(Id:Int): List<Product>
    suspend fun allProductByName(name:String): List<Product>
    suspend fun allProductFromMainFragment(): List<ProductMainItem>
}