package com.mohammed.mosa.eg.mybusiness.data.module

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime
@Entity(tableName = "licenses")
data class License(
    @PrimaryKey
    val licenseOrRecordNumber: String,
    val ownerName: String,
    val ownerId: String,
    val idOrRecordNumber: String,
    val activity: String,
    val classification: String,
    val expiryDate: LocalDateTime,
    val municipality: String,
    val localMunicipality: String,
    val licenseType: String
)
