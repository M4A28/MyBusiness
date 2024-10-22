package com.mohammed.mosa.eg.mybusiness.di

import com.mohammed.mosa.eg.mybusiness.data.local.dao.TenantDao
import com.mohammed.mosa.eg.mybusiness.data.local.db.AppDatabase
import com.mohammed.mosa.eg.mybusiness.data.repoimpl.TenantRepositoryImpl
import com.mohammed.mosa.eg.mybusiness.domain.repo.TenantRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TenantModule {

    @Provides
    @Singleton
    fun provideTenantDao(db: AppDatabase): TenantDao {
        return db.tenantDao
    }


    @Provides
    @Singleton
    fun provideTenantRepository(tenantDao: TenantDao): TenantRepository {
        return TenantRepositoryImpl(tenantDao)
    }



}