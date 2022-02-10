package com.mobilist.fcommerce.app.data.entity.product

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.mobilist.fcommerce.app.data.entity.user.User

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = Product::class,
            parentColumns = arrayOf("UUID"),
            childColumns = arrayOf("ProductImageProduct"),
            onDelete = ForeignKey.CASCADE
        )]
)
data class ProductImage(
    val ProductImagePath: String,
    @ColumnInfo(index = true)
    val ProductImageProduct: Int,
){
    @PrimaryKey(autoGenerate = true)
    var UUID:Int=0
}
