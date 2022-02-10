package com.mobilist.fcommerce.services.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mobilist.fcommerce.app.data.entity.informative.Chat
import com.mobilist.fcommerce.app.data.entity.informative.Comment
import com.mobilist.fcommerce.app.data.entity.informative.Like
import com.mobilist.fcommerce.app.data.entity.informative.Score
import com.mobilist.fcommerce.app.data.entity.informative.images_entity.ChatImage
import com.mobilist.fcommerce.app.data.entity.informative.images_entity.CommentImage
import com.mobilist.fcommerce.app.data.entity.product.Brand
import com.mobilist.fcommerce.app.data.entity.product.Category
import com.mobilist.fcommerce.app.data.entity.product.Product
import com.mobilist.fcommerce.app.data.entity.product.ProductImage
import com.mobilist.fcommerce.app.data.entity.sales.Cargo
import com.mobilist.fcommerce.app.data.entity.sales.Cart
import com.mobilist.fcommerce.app.data.entity.sales.Order
import com.mobilist.fcommerce.app.data.entity.user.*
import com.mobilist.fcommerce.data.entity.product.ProductPrice
import com.mobilist.fcommerce.services.room.product_api.ProductDao
import com.mobilist.fcommerce.services.room.user_api.UserDao
@Database(
    entities = [User::class, Adress::class, AdressType::class, Role::class, Card::class,
        Cargo::class, Cart::class, Order::class,
        Brand::class, Category::class, Product::class,  ProductImage::class,ProductPrice::class,
        Chat::class, Comment::class, Like::class, Score::class, ChatImage::class, CommentImage::class],
    version = 2
)
abstract  class FCDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun productDao(): ProductDao
}