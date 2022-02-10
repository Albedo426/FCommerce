package com.mobilist.fcommerce.data.model

import androidx.room.ColumnInfo
import com.mobilist.fcommerce.app.data.entity.product.Product
import com.mobilist.fcommerce.app.data.entity.user.User

data class ProductMainItemModel (
    var ProductName: String,
    var ProductPrice: Double,
    var ProductDiscountRate: Int,
    var CoverImagePath: String,
    var ProductMinDeclaration: String,
    var StartDate: String,
    var finishDate: String,
    var Quantity: Int,
    var UUID:Int,
        )
fun ProductMainItemModel.getProductDiscountRateString() :String{
    return "Sepette ${ProductDiscountRate.toString()} indirim"
}
fun ProductMainItemModel.getProductTotalPrice() :String{
    var l=1
    if(ProductDiscountRate!=0){
         l =ProductDiscountRate/100
    }
    val price =ProductPrice*ProductDiscountRate/100
    return  price.toString()
}