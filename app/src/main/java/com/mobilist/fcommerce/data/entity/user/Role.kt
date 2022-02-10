package com.mobilist.fcommerce.app.data.entity.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Role(
    @ColumnInfo(name = "RoleName")
    val RoleName: String

){
    @PrimaryKey(autoGenerate = true)
    var UUID:Int = 0
}
