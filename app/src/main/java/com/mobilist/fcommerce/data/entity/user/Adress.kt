package com.mobilist.fcommerce.app.data.entity.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = arrayOf("UUID"),
            childColumns = arrayOf("User"),
            onDelete = ForeignKey.CASCADE
        ), ForeignKey(
            entity = AdressType::class,
            parentColumns = arrayOf("UUID"),
            childColumns = arrayOf("AdressType"),
            onDelete = ForeignKey.CASCADE
        )]
)
data class Adress(
    val Address: String,
    val Address2: String,
    val City: String,
    @ColumnInfo(index = true)
    val AdressType: Int,//this will change (like get enum class )
    val Phone: String,
    val State: String,
    val PostalCode: Int,
    @ColumnInfo(index = true)
    val User: Int
)
{

    @PrimaryKey(autoGenerate = true)
    var UUID:Int=0
}