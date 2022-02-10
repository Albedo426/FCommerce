package com.mobilist.fcommerce.data.entity.sales

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.mobilist.fcommerce.app.data.entity.sales.Order
import com.mobilist.fcommerce.app.data.entity.user.Adress
import com.mobilist.fcommerce.app.data.entity.user.Card
import com.mobilist.fcommerce.app.data.entity.user.User

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = Order::class,
            parentColumns = arrayOf("UUID"),
            childColumns = arrayOf("Order"),
            onDelete = ForeignKey.CASCADE
        )]
)
data class OrderItem(
    @ColumnInfo(index = true)
    val OrderProduct: Int,
    @ColumnInfo(index = true)
    val Order: Int,
    val OrderDeliveryDate: String,
    val State: Int,//orderın içinde yeni entitity olmmasın tabloyu sil int al enuma parla
    val Quantity: Int,
){

    @PrimaryKey(autoGenerate = true)
    var UUID: Int = 0
}
