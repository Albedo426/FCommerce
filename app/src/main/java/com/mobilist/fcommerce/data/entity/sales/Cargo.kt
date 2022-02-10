package com.mobilist.fcommerce.app.data.entity.sales

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.mobilist.fcommerce.app.data.entity.product.Product

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = Order::class,
            parentColumns = arrayOf("UUID"),
            childColumns = arrayOf("Order"),
            onDelete = ForeignKey.CASCADE
        )]
)
data class Cargo(
    @ColumnInfo(index = true)
    val Order: Int,
    val TrackingNo: String,
){

    @PrimaryKey(autoGenerate = true)
    var UUID:Int=0
}
