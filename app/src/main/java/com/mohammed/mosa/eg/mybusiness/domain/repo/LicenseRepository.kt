package com.mohammed.mosa.eg.mybusiness.domain.repo


import com.mohammed.mosa.eg.mybusiness.data.module.License
import kotlinx.coroutines.flow.Flow
import java.time.LocalDateTime

interface LicenseRepository {

    suspend fun upsertLicense(license: License)

    suspend fun upsertLicenses(licenses: List<License>)

    suspend fun deleteLicense(license: License)

    suspend fun deleteLicenses(licenses: List<License>)

    fun getLicensesOrderedByLicenseOrRecordNumber(): Flow<List<License>>

    fun getLicensesOrderedByExpiryDate(): Flow<List<License>>

    fun getExpiredLicensesInRange(currentDate: LocalDateTime, nextDate: LocalDateTime): Flow<List<License>>
}