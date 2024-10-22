package com.mohammed.mosa.eg.mybusiness.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.mohammed.mosa.eg.mybusiness.data.module.License
import com.mohammed.mosa.eg.mybusiness.data.module.Vehicle
import kotlinx.coroutines.flow.Flow
import java.time.LocalDateTime

@Dao
interface VehicleDao {

    @Upsert
    suspend fun upsertVehicle(vehicle: Vehicle)

    @Upsert
    suspend fun upsertVehicles(vehicles: List<Vehicle>)

    @Delete
    suspend fun deleteVehicle(vehicle: Vehicle)

    @Delete
    suspend fun deleteVehicles(vehicles: List<Vehicle>)

    @Query("SELECT * FROM vehicles ORDER BY licensePlateNumber ASC")
    fun getVehiclesOrderedByLicensePlateNumber(): Flow<List<Vehicle>>

    @Query("SELECT * FROM vehicles ORDER BY serialNumber ASC")
    fun getVehiclesOrderedBySerialNumber(): Flow<List<Vehicle>>

    @Query("SELECT * FROM vehicles ORDER BY chassisNumber ASC")
    fun getVehiclesOrderedByChassisNumber(): Flow<List<Vehicle>>

    @Query("SELECT * FROM Vehicles ORDER BY licenseExpiryDate ASC")
    fun getVehiclesOrderedByLicenseExpiryDate(): Flow<List<Vehicle>>

    @Query("SELECT * FROM vehicles WHERE serialNumber = :serialNumber")
    fun getVehicleBySerialNumber(serialNumber: String): Flow<Vehicle>


    @Query("SELECT * FROM vehicles WHERE licenseExpiryDate <= :date")
    fun getExpiredVehicles(date: LocalDateTime): Flow<List<Vehicle>>

    @Query("SELECT * FROM vehicles WHERE licenseExpiryDate BETWEEN :currentDate AND :nextDate")
    fun getExpiredVehiclesInRange(currentDate: LocalDateTime, nextDate: LocalDateTime): Flow<List<Vehicle>>

}