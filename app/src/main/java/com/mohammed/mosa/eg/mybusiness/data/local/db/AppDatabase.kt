package com.mohammed.mosa.eg.mybusiness.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mohammed.mosa.eg.mybusiness.data.local.converters.LocalDateTimeConverter
import com.mohammed.mosa.eg.mybusiness.data.local.dao.BusinessExpenseDao
import com.mohammed.mosa.eg.mybusiness.data.local.dao.EmployeeDao
import com.mohammed.mosa.eg.mybusiness.data.local.dao.LicenseDao
import com.mohammed.mosa.eg.mybusiness.data.local.dao.MovementDao
import com.mohammed.mosa.eg.mybusiness.data.local.dao.TenantDao
import com.mohammed.mosa.eg.mybusiness.data.local.dao.VehicleDao
import com.mohammed.mosa.eg.mybusiness.data.module.BusinessExpense
import com.mohammed.mosa.eg.mybusiness.data.module.Employee
import com.mohammed.mosa.eg.mybusiness.data.module.License
import com.mohammed.mosa.eg.mybusiness.data.module.Movement
import com.mohammed.mosa.eg.mybusiness.data.module.Tenant
import com.mohammed.mosa.eg.mybusiness.data.module.Vehicle

@Database(
    entities = [
        Employee::class,
        License::class,
        BusinessExpense::class,
        Tenant::class,
        Movement::class,
        Vehicle::class],
    version = 1,
    exportSchema = true
)
@TypeConverters(LocalDateTimeConverter::class)
abstract class AppDatabase : RoomDatabase(){
    abstract val employeeDao: EmployeeDao
    abstract val licenseDao: LicenseDao
    abstract val businessExpenseDao: BusinessExpenseDao
    abstract val tenantDao: TenantDao
    abstract val movementDao: MovementDao
    abstract val vehicleDao: VehicleDao
}