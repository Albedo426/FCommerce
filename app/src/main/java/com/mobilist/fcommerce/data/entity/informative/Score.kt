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
            childColumns = arrayOf("User"),
            onDelete = ForeignKey.CASCADE
        ), ForeignKey(
            entity = Product::class,
            parentColumns = arrayOf("UUID"),
            childColumns = arrayOf("Product"),
            onDelete = ForeignKey.CASCADE
        )]
)
data class Score(
    @ColumnInfo(index = true)
    val User: Int,
    @ColumnInfo(index = true)
    val Product: Int,
    val ScorePoint:Int,
) {
    @PrimaryKey(autoGenerate = true)
    var UUID: Int = 0
}
