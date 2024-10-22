package com.mohammed.mosa.eg.mybusiness.domain.repo

import com.mohammed.mosa.eg.mybusiness.data.module.Vehicle
import kotlinx.coroutines.flow.Flow
import java.time.LocalDateTime

interface VehicleRepository {

    suspend fun upsertVehicle(vehicle: Vehicle)

    suspend fun upsertVehicles(vehicles: List<Vehicle>)

    suspend fun deleteVehicle(vehicle: Vehicle)

    suspend fun deleteVehicles(vehicles: List<Vehicle>)

    fun getVehiclesOrderedByLicensePlateNumber(): Flow<List<Vehicle>>

    fun getVehiclesOrderedBySerialNumber(): Flow<List<Vehicle>>

    fun getVehiclesOrderedByChassisNumber(): Flow<List<Vehicle>>

    fun getVehiclesOrderedByLicenseExpiryDate(): Flow<List<Vehicle>>

    fun getVehicleBySerialNumber(serialNumber: String): Flow<Vehicle>

    fun getExpiredVehicles(date: LocalDateTime): Flow<List<Vehicle>>

    fun getExpiredVehiclesInRange(currentDate: LocalDateTime, nextDate: LocalDateTime): Flow<List<Vehicle>>
}