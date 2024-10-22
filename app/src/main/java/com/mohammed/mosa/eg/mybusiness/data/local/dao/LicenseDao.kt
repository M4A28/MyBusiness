package com.mohammed.mosa.eg.mybusiness.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.mohammed.mosa.eg.mybusiness.data.module.License
import kotlinx.coroutines.flow.Flow
import java.time.LocalDateTime

@Dao
interface LicenseDao {

    @Upsert
    suspend fun upsertLicense(license: License)

    @Upsert
    suspend fun upsertLicenses(licenses: List<License>)

    @Delete
    suspend fun deleteLicense(license: License)

    @Delete
    suspend fun deleteLicenses(licenses: List<License>)

    @Query("SELECT * FROM licenses ORDER BY licenseOrRecordNumber ASC")
    fun getLicensesOrderedByLicenseOrRecordNumber(): Flow<List<License>>

    @Query("SELECT * FROM licenses ORDER BY expiryDate ASC")
    fun getLicensesOrderedByExpiryDate(): Flow<List<License>>

    @Query("SELECT * FROM licenses WHERE expiryDate BETWEEN :currentDate AND :nextDate")
    fun getExpiredLicensesInRange(currentDate: LocalDateTime, nextDate: LocalDateTime): Flow<List<License>>











}