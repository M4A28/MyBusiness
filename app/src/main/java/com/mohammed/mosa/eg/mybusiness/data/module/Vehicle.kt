package com.mohammed.mosa.eg.mybusiness.data.module

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "vehicles")
data class Vehicle(
    @PrimaryKey
    val serialNumber: String,
    val licensePlateNumber: String,
    val chassisNumber: String,
    val vehicleType: String,
    val color: String,
    val model: String,
    val brand: String,
    val manufacturingYear: Int,
    val estimatedValue: Double,
    val insuranceExpiryDate: LocalDateTime,
    val licenseExpiryDate: LocalDateTime,
    val periodicInspectionExpiryDate: LocalDateTime
)