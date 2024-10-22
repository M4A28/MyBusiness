package com.mohammed.mosa.eg.mybusiness.di

import com.mohammed.mosa.eg.mybusiness.data.local.dao.VehicleDao
import com.mohammed.mosa.eg.mybusiness.data.local.db.AppDatabase
import com.mohammed.mosa.eg.mybusiness.data.repoimpl.VehicleRepositoryImpl
import com.mohammed.mosa.eg.mybusiness.domain.repo.VehicleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class VehicleModule {

    @Provides
    @Singleton
    fun provideVehicleDao(db: AppDatabase): VehicleDao {
        return db.vehicleDao
    }

    @Provides
    @Singleton
    fun provideVehicleRepository(vehicleDao: VehicleDao): VehicleRepository {
        return VehicleRepositoryImpl(vehicleDao)
    }




}