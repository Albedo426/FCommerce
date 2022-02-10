package com.mobilist.fcommerce.app.data.entity.informative

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.mobilist.fcommerce.app.data.entity.product.Product
import com.mobilist.fcommerce.app.data.entity.user.User

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = arrayOf("UUID"),
            childColumns = arrayOf("SenderUser"),
            onDelete = ForeignKey.CASCADE
        ), ForeignKey(
            entity = User::class,
            parentColumns = arrayOf("UUID"),
            childColumns = arrayOf("ReceiverUser"),
            onDelete = ForeignKey.CASCADE
        )]
)
data class Chat(
    @ColumnInfo(index = true)
    val SenderUser: Int,
    @ColumnInfo(index = true)
    val ReceiverUser: Int,
    val ChatText: String,
    val ChatDate: String,
    val hasImage: Boolean,
){
    @PrimaryKey(autoGenerate = true)
    var UUID: Int = 0
}
