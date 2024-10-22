package com.mohammed.mosa.eg.mybusiness.data.repoimpl

import com.mohammed.mosa.eg.mybusiness.data.local.dao.VehicleDao
import com.mohammed.mosa.eg.mybusiness.data.module.Vehicle
import com.mohammed.mosa.eg.mybusiness.domain.repo.VehicleRepository
import kotlinx.coroutines.flow.Flow
import java.time.LocalDateTime
import javax.inject.Inject

class VehicleRepositoryImpl @Inject constructor(private val vehicleDao: VehicleDao): VehicleRepository {
    override suspend fun upsertVehicle(vehicle: Vehicle) {
        vehicleDao.upsertVehicle(vehicle)
    }

    override suspend fun upsertVehicles(vehicles: List<Vehicle>) {
        vehicleDao.upsertVehicles(vehicles)
    }

    override suspend fun deleteVehicle(vehicle: Vehicle) {
        vehicleDao.deleteVehicle(vehicle)
    }

    override suspend fun deleteVehicles(vehicles: List<Vehicle>) {
        vehicleDao.deleteVehicles(vehicles)
    }

    override fun getVehiclesOrderedByLicensePlateNumber(): Flow<List<Vehicle>> {
        return vehicleDao.getVehiclesOrderedByLicensePlateNumber()
    }

    override fun getVehiclesOrderedBySerialNumber(): Flow<List<Vehicle>> {
        return vehicleDao.getVehiclesOrderedBySerialNumber()
    }

    override fun getVehiclesOrderedByChassisNumber(): Flow<List<Vehicle>> {
        return vehicleDao.getVehiclesOrderedByChassisNumber()
    }

    override fun getVehiclesOrderedByLicenseExpiryDate(): Flow<List<Vehicle>> {
        return vehicleDao.getVehiclesOrderedByLicenseExpiryDate()
    }

    override fun getVehicleBySerialNumber(serialNumber: String): Flow<Vehicle> {
        return vehicleDao.getVehicleBySerialNumber(serialNumber)
    }

    override fun getExpiredVehicles(date: LocalDateTime): Flow<List<Vehicle>> {
        return vehicleDao.getExpiredVehicles(date)
    }

    override fun getExpiredVehiclesInRange(
        currentDate: LocalDateTime,
        nextDate: LocalDateTime
    ): Flow<List<Vehicle>> {
        return vehicleDao.getExpiredVehiclesInRange(currentDate, nextDate)
    }


}