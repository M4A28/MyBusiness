package com.mohammed.mosa.eg.mybusiness.data.module

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "movements")
data class Movement(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val employeeName: String,
    val departureDate: LocalDateTime,
    val returnDate: LocalDateTime,
    val destination: String,
    val notes: String
)
