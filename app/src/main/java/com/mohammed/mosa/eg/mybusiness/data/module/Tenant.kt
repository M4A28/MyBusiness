package com.mohammed.mosa.eg.mybusiness.data.module

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "tenants")
data class Tenant(
    @PrimaryKey(autoGenerate = true)
    val roomId: Int,
    val roomNumber: String,
    val tenantName: String,
    val nationality: String,
    val dayToRent: Int,
    val residenceNumber: String,
    val phoneNumber: String,
    val rentAmount: Double,
    val currentRentDueDate: LocalDateTime,
    val nextRentDueDate: LocalDateTime
)
