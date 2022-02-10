package com.mobilist.fcommerce.data.entity.product

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.mobilist.fcommerce.app.data.entity.product.Brand
import com.mobilist.fcommerce.app.data.entity.product.Category
import com.mobilist.fcommerce.app.data.entity.product.Product
import com.mobilist.fcommerce.app.data.entity.user.User

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = Product::class,
            parentColumns = arrayOf("UUID"),
            childColumns = arrayOf("Product"),
            onDelete = ForeignKey.CASCADE
        )]
)
data class ProductPrice(
    @ColumnInfo(index = true)
    val Product: Int,
    val ProductDiscountRate: Int,
    val finishDate: String,
    val StartDate: String,
    val ProductPrice: Double,
){
    @PrimaryKey(autoGenerate = true)
    var UUID:Int=0
}
