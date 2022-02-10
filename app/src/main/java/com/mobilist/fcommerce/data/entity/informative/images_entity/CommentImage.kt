package com.mobilist.fcommerce.app.data.entity.informative.images_entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.mobilist.fcommerce.app.data.entity.informative.Comment
import com.mobilist.fcommerce.app.data.entity.product.Product
import com.mobilist.fcommerce.app.data.entity.user.User

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = Comment::class,
            parentColumns = arrayOf("UUID"),
            childColumns = arrayOf("Comment"),
            onDelete = ForeignKey.CASCADE
        )]
)
data class CommentImage(
    @ColumnInfo(index = true)
    val Comment: Int,
    val Path: String,
) {
    @PrimaryKey(autoGenerate = true)
    var UUID: Int = 0
}

