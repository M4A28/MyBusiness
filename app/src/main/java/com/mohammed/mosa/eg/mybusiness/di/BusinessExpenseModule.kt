package com.mohammed.mosa.eg.mybusiness.di

import com.mohammed.mosa.eg.mybusiness.data.local.dao.BusinessExpenseDao
import com.mohammed.mosa.eg.mybusiness.data.local.db.AppDatabase
import com.mohammed.mosa.eg.mybusiness.data.repoimpl.BusinessExpenseRepositoryImpl
import com.mohammed.mosa.eg.mybusiness.domain.repo.BusinessExpenseRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object BusinessExpenseModule {

    @Provides
    @Singleton
    fun provideBusinessExpenseDao(appDatabase: AppDatabase): BusinessExpenseDao {
        return appDatabase.businessExpenseDao
    }

    @Provides
    @Singleton
    fun provideBusinessExpenseRepository(businessExpenseDao: BusinessExpenseDao): BusinessExpenseRepository {
        return BusinessExpenseRepositoryImpl(businessExpenseDao)
    }

}