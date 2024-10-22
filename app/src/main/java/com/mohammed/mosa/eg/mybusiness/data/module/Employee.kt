package com.mohammed.mosa.eg.mybusiness.data.module

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "employees")
data class Employee(
    @PrimaryKey
    val residenceNumber: String,
    val jobNumber: String,
    val name: String,
    val birthDate: LocalDateTime,
    val nationality: String,
    val job: String,
    val department: String,
    val salary: Double,
    val location: String,
    val phoneNumber: String,
    val email: String,
    val iban: String,
    val residenceExpiry: LocalDateTime,
    val workPermitExpiry: LocalDateTime,
    val contractExpiry: LocalDateTime,
    val insuranceExpiry: LocalDateTime
)
