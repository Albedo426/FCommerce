package com.mobilist.fcommerce.app.data.entity.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [ForeignKey(
        entity = User::class,
        parentColumns = arrayOf("UUID"),
        childColumns = arrayOf("User"),
        onDelete = ForeignKey.CASCADE
    )]
)
//masterpass kart kaydetme için sistem //son 4 hanesini kaydediceksin kart nosunun
data class Card(
    val CardNo: String,
    @ColumnInfo(index = true)
    val User: Int
){
    @PrimaryKey(autoGenerate = true)
    var UUID:Int=0
}
