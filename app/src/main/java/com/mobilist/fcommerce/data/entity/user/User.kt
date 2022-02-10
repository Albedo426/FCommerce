package com.mobilist.fcommerce.app.data.entity.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.mobilist.fcommerce.data.model.LoginModel

@Entity(
    foreignKeys = [ForeignKey(
        entity = Role::class,
        parentColumns = arrayOf("UUID"),
        childColumns = arrayOf("Role"),
        onDelete = ForeignKey.CASCADE
    )]
)
data class User(
    var Username: String?,
    var UserPassword: String,
    var UserEmail: String,
    var Name: String?,
    var LastName: String?,
    var TC: String?,
    var Phone: String?,
    @ColumnInfo(index = true)
    var Role: Int?
){
    @PrimaryKey(autoGenerate = true)
    var UUID:Int=0
}

fun User.toLoginModel(): LoginModel {
    return LoginModel(UserEmail = UserEmail, UserPassword = UserPassword)
}