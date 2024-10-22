package com.mohammed.mosa.eg.mybusiness.data.repoimpl

import com.mohammed.mosa.eg.mybusiness.data.local.dao.LicenseDao
import com.mohammed.mosa.eg.mybusiness.data.module.License
import com.mohammed.mosa.eg.mybusiness.domain.repo.LicenseRepository
import kotlinx.coroutines.flow.Flow
import java.time.LocalDateTime
import javax.inject.Inject

class LicenseRepositoryImpl @Inject constructor(private val licenseDao: LicenseDao): LicenseRepository {
    override suspend fun upsertLicense(license: License) {
        licenseDao.upsertLicense(license)
    }

    override suspend fun upsertLicenses(licenses: List<License>) {
        licenseDao.upsertLicenses(licenses)
    }

    override suspend fun deleteLicense(license: License) {
        licenseDao.deleteLicense(license)
    }

    override suspend fun deleteLicenses(licenses: List<License>) {
        licenseDao.deleteLicenses(licenses)
    }

    override fun getLicensesOrderedByLicenseOrRecordNumber(): Flow<List<License>> {
        return licenseDao.getLicensesOrderedByLicenseOrRecordNumber()
    }

    override fun getLicensesOrderedByExpiryDate(): Flow<List<License>> {
        return licenseDao.getLicensesOrderedByExpiryDate()
    }

    override fun getExpiredLicensesInRange(
        currentDate: LocalDateTime,
        nextDate: LocalDateTime
    ): Flow<List<License>> {
        return licenseDao.getExpiredLicensesInRange(currentDate, nextDate)
    }

}