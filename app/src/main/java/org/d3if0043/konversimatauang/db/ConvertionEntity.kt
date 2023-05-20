package org.d3if0043.konversimatauang.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "convertion")
data class ConvertionEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    var tanggal: Long = System.currentTimeMillis(),
    var nominal: Float,
    var isIDR: Boolean
)
