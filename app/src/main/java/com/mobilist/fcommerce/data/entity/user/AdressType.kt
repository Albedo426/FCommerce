package com.mobilist.fcommerce.app.data.entity.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
//kaldırabilirsin
@Entity
data class AdressType(

    @ColumnInfo(name = "TypeName")
    val TypeName: String
)
{
    @PrimaryKey(autoGenerate = true)
    var UUID:Int=0
}