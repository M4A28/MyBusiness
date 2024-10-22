package com.mohammed.mosa.eg.mybusiness.di

import com.mohammed.mosa.eg.mybusiness.data.local.dao.LicenseDao
import com.mohammed.mosa.eg.mybusiness.data.local.db.AppDatabase
import com.mohammed.mosa.eg.mybusiness.data.repoimpl.LicenseRepositoryImpl
import com.mohammed.mosa.eg.mybusiness.domain.repo.LicenseRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LicenseModule {
    @Provides
    @Singleton
    fun provideLicenseDao(db: AppDatabase): LicenseDao {
        return db.licenseDao
    }

    @Provides
    @Singleton
    fun provideLicenseRepository(licenseDao: LicenseDao): LicenseRepository {
        return LicenseRepositoryImpl(licenseDao)
    }


}