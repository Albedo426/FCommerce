package com.mobilist.fcommerce.services.repo.product

import com.mobilist.fcommerce.app.data.entity.product.Product
import com.mobilist.fcommerce.app.data.entity.product.ProductMainItem
import com.mobilist.fcommerce.app.data.entity.user.User
import com.mobilist.fcommerce.data.model.LoginModel
import com.mobilist.fcommerce.services.repo.user.UserRepository
import com.mobilist.fcommerce.services.room.product_api.ProductDao
import com.mobilist.fcommerce.services.room.user_api.UserDao
import javax.inject.Inject

class ProductRepositoryImpl  @Inject constructor(private val productDao : ProductDao): ProductRepositroy {

    override suspend fun insert(user: Product): Long {
        return productDao.insert(user)
    }
    override suspend fun insertAll(vararg users: Product): List<Long> {
        return productDao.insertAll(*users)
    }
    override suspend fun allProduct(): List<Product> {
        return productDao.allProduct()
    }
    override suspend fun allProductById(Id: Int): Product {
        return productDao.allProductById(Id)
    }

    override suspend fun allProductByCategoryId(Id: Int): List<Product> {
        return productDao.allProductByCategoryId(Id)
    }

    override suspend fun allProductByName(name: String): List<Product> {
        return productDao.allProductByName(name)
    }

    override suspend fun allProductFromMainFragment(): List<ProductMainItem> {
        return productDao.allProductFromMainFragment()
    }

}
