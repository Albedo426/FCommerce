package com.mobilist.fcommerce.services.room.product_api

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.mobilist.fcommerce.app.data.entity.product.Product
import com.mobilist.fcommerce.app.data.entity.product.ProductMainItem
import com.mobilist.fcommerce.app.data.entity.user.User
import com.mobilist.fcommerce.data.model.LoginModel

@Dao
interface ProductDao {
    @Insert
    suspend fun insert(product: Product):Long

    @Insert
    suspend fun insertAll(vararg users:Product):List<Long>

    @Query("SELECT * FROM Product")
    suspend fun allProduct(): List<Product>

    @Query("select Product.ProductName ,Product.ProductMinDeclaration,Product.UUID ,Quantity,ProductPrice.ProductPrice,ProductPrice.ProductDiscountRate,finishDate,StartDate,CoverImagePath from Product inner join ProductPrice on Product.UUID=ProductPrice.Product")
    suspend fun allProductFromMainFragment(): List<ProductMainItem>

    @Query("SELECT * FROM Product where UUID=:Id")
    suspend fun allProductById(Id:Int): Product

    @Query("SELECT * FROM Product where ProductCategory=:Id")
    suspend fun allProductByCategoryId(Id:Int): List<Product>

    @Query("SELECT * FROM Product where ProductName=:name")
    suspend fun allProductByName(name:String): List<Product>

}