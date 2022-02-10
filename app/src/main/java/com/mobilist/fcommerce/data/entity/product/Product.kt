package com.mobilist.fcommerce.app.data.entity.product

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.mobilist.fcommerce.app.data.entity.user.User
import com.mobilist.fcommerce.data.model.ProductMainItemModel

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = arrayOf("UUID"),
            childColumns = arrayOf("ProductUser"),
            onDelete = ForeignKey.CASCADE
        ), ForeignKey(
            entity = Category::class,
            parentColumns = arrayOf("UUID"),
            childColumns = arrayOf("ProductCategory"),
            onDelete = ForeignKey.CASCADE
        ), ForeignKey(
            entity = Brand::class,
            parentColumns = arrayOf("UUID"),
            childColumns = arrayOf("ProductBrand"),
            onDelete = ForeignKey.CASCADE
        )]
)
data class Product(
    @ColumnInfo(index = true)
    val ProductBrand: Int,
    @ColumnInfo(index = true)
    val ProductUser: Int,
    @ColumnInfo(index = true)
    val ProductCategory: Int,
    val ProductName: String,
    val ProductMinDeclaration: String,
    val Declaration: String,
    val CoverImagePath:String,
    val Date: String,
    val Quantity: Int,
){
    @PrimaryKey(autoGenerate = true)
    var UUID:Int=0
}

data class ProductMainItem(
    val ProductName: String,
    val ProductMinDeclaration: String,
    val CoverImagePath:String,
    val StartDate:String,
    val finishDate:String,
    val ProductDiscountRate:Int,
    val ProductPrice:Double,
    val Quantity:Int,
    val UUID:Int,
)

fun ProductMainItem.toProductMainItem(): ProductMainItemModel {
    return ProductMainItemModel(ProductName = ProductName, ProductMinDeclaration = ProductMinDeclaration,
        CoverImagePath = CoverImagePath, StartDate = StartDate, finishDate = finishDate,
        ProductDiscountRate = ProductDiscountRate, Quantity =Quantity, UUID = UUID ,ProductPrice=ProductPrice)
}


