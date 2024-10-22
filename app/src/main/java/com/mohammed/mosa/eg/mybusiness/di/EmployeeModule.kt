package com.mohammed.mosa.eg.mybusiness.di

import com.mohammed.mosa.eg.mybusiness.data.local.dao.EmployeeDao
import com.mohammed.mosa.eg.mybusiness.data.local.db.AppDatabase
import com.mohammed.mosa.eg.mybusiness.data.repoimpl.EmployeeRepositoryImpl
import com.mohammed.mosa.eg.mybusiness.domain.repo.EmployeeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object EmployeeModule {
    @Provides
    @Singleton
    fun provideEmployeeDao(db: AppDatabase): EmployeeDao {
        return db.employeeDao
    }

    @Provides
    @Singleton
    fun provideEmployeeRepository(employeeDao: EmployeeDao): EmployeeRepository {
        return EmployeeRepositoryImpl(employeeDao)
    }



}