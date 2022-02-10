package com.mobilist.fcommerce.app.data.entity.informative.images_entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.mobilist.fcommerce.app.data.entity.informative.Chat
import com.mobilist.fcommerce.app.data.entity.informative.Comment

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = Chat::class,
            parentColumns = arrayOf("UUID"),
            childColumns = arrayOf("Chat"),
            onDelete = ForeignKey.CASCADE
        )]
)
data class ChatImage(
    @ColumnInfo(index = true)
    val Chat: Int,
    val Path: String,
) {
    @PrimaryKey(autoGenerate = true)
    var UUID: Int = 0
}
