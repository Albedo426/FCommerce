package com.mobilist.fcommerce.app.data.entity.product

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Brand(
    val Name: String,)
{
    @PrimaryKey(autoGenerate = true)
    var UUID:Int=0
}
