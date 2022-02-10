package com.mobilist.fcommerce.app.data.entity.product

import androidx.room.Entity
import androidx.room.PrimaryKey
/**
 *
 * is main (MainCategory) go to UUId
 * */
@Entity
data class Category(
    val Name: String,
    var MainCategory: Int?,//null olabilir girilmeyebilir

)
{
    @PrimaryKey(autoGenerate = true)
    var UUID:Int=0
}